package com.codinggame.decembre;

import java.util.ArrayList;

public class Strategy {


    private Station[] myStations = new Station[4];

    private Station[] oppStations = new Station[4];
    private ArrayList<Planet>  planets = new ArrayList<Planet> ();
    private ArrayList<Bonus> myBonus = new ArrayList<Bonus>();
    private ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();

    public Strategy(Station[] myStations , Station[] oppStations, ArrayList<Planet>  planets, ArrayList<Bonus> myBonus, ArrayList<Bonus> oppBonus){
        this.myStations = myStations;
        this.oppStations = oppStations;
        this.planets = planets;
        this.myBonus = myBonus;
        this.oppBonus = oppBonus;
    }

    public String execute(){
        String preCommand = applyTechPreCommand();
        // main actions: COLONIZE | RESUPPLY
        // bonus actions: ENERGY_CORE | ALIEN_ARTIFACT | TECH_RESEARCH | NEW_TECH
        // Append text after any command and that text will appear on screen.
        ArrayList<Distances> distancesArrayList = new ArrayList<>();
        Distances distance;
        Distances disMin = null;
        Distances disMinAvailable = null;
        for(int i=0; i<myStations.length; i++){
            for (Planet planet: planets){
                distance = new Distances(myStations[i], planet);
                if(distancesArrayList.size() == 0){
                    distancesArrayList.add(distance);
                    disMin = distance;
                }else{
                    if(distance.isSmallerDistanceThan(disMin)){
                        distancesArrayList.clear();
                        distancesArrayList.add(distance);
                        disMin = distance;
                    }else if(distance.isEqualDistanceThan(disMin)){
                        distancesArrayList.add(distance);
                    }
                }
                //System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());
            }
        }


        Distances distanceToPlay = getBestTokenUsableFromList(distancesArrayList) ;
        System.err.println("Number of min Dist="+distancesArrayList.size());
        System.err.println("Distrance To play:"+distanceToPlay.toString());

        if(distanceToPlay.getStation().isAvailable()) {
                return preCommand+applyColonizeWithAllienAttempt(myBonus,distanceToPlay);
        }else{
            //do we have an avaialble station with the same distance ? if yes, let's colonize with it ....
            disMinAvailable = getBestTokenUsableFromList(geAvailablesFromList(distancesArrayList));
            if(disMinAvailable != null && disMinAvailable.getDisValueStationPlanet() <= distanceToPlay.getDisValueStationPlanet()){
                System.err.println("Distrance To play (Min Available):"+disMinAvailable.toString());

                return preCommand+applyColonizeWithAllienAttempt(myBonus,disMinAvailable) ;
            }
            //... else let's try to apply a bonus to the non available better one
            //do dwe have a ENERGY BONUS to allow resupply and colonize in one shot
            return preCommand+applyEnergyAndColonize_Or_Resupply(myBonus, applyColonizeWithAllienAttempt(myBonus,distanceToPlay));
            
        }
    }

    public ArrayList<Distances> geAvailablesFromList(ArrayList<Distances> distancesArrayList){
        ArrayList<Distances> list = new ArrayList<>();
        if (distancesArrayList != null){
            for(Distances distances: distancesArrayList){
                if(distances.getStation().isAvailable()){
                    list.add(distances);
                }
            }
        }
        return list;
    }

    public Distances getBestTokenUsableFromList(ArrayList<Distances> distancesArrayList){
        if (distancesArrayList == null){
            return null;
        }
        Distances prev = null;
        Distances cur = null;
        for(Distances distances: distancesArrayList){
            if(prev == null){
                prev = distances;
                cur = distances;
            }else{
                if(cur.getUsableToken() > prev.getUsableToken()){
                    prev = cur;
                }
            }
        }
        return prev;
    }

    public String applyTechPreCommand(){
        String resultCommand = "";
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station
        for(Bonus bonus: myBonus){
            System.err.println(bonus.toString());
            int techREsearchBonusNum = -1;
            String commandName = "";
            if(BonusType.NEW_TECH.equals(bonus.getBonus())) {
                techREsearchBonusNum = 0;
                commandName = "NEW_TECH ";
            }else if(BonusType.TECH_RESEARCH_2.equals(bonus.getBonus())) {
                techREsearchBonusNum = 1;
                commandName = "TECH_RESEARCH ";
            }else if(BonusType.TECH_RESEARCH_3.equals(bonus.getBonus())) {
                techREsearchBonusNum = 2;
                commandName = "TECH_RESEARCH ";
            }if(BonusType.TECH_RESEARCH_4.equals(bonus.getBonus())) {
                techREsearchBonusNum = 3;
                commandName = "TECH_RESEARCH ";
            }
            if (techREsearchBonusNum >= 0) {
                boolean isBonusUsed=false;
                for (int i = 0; i < myStations.length; i++) {
                    Station station = myStations[i];

                    if (station.getTerraformingSkill() == techREsearchBonusNum && station.isTerraformingObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);
                        station.terraformingSkill += 1;
                        isBonusUsed=true;
                        break;
                    } else if (station.getAlienSkill() == techREsearchBonusNum && station.isAlienObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);
                        station.alienSkill += 1;
                        isBonusUsed=true;
                        break;
                    } else if (station.getEngineeringSkill() == techREsearchBonusNum && station.isEngineeringObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);
                        station.engineeringSkill += 1;
                        isBonusUsed=true;
                        break;
                    } else if (station.getAgricultureSkill() == techREsearchBonusNum && station.isAgricultureObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);
                        station.agricultureSkill += 1;
                        isBonusUsed=true;
                        break;
                    }
                }
                if (!isBonusUsed) //bonus not used to fill station objective, let's fill the first available task-station
                {
                    if (station.getTerraformingSkill() == techREsearchBonusNum) {
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);
                        station.terraformingSkill += 1;
                        System.err.println("Station impacted: "+station.toString());
                        break;
                    } else if (station.getAlienSkill() == techREsearchBonusNum) {
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);
                        station.alienSkill += 1;
                        System.err.println("Station impacted: "+station.toString());
                        break;
                    } else if (station.getEngineeringSkill() == techREsearchBonusNum) {
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);
                        station.engineeringSkill += 1;
                        System.err.println("Station impacted: "+station.toString());
                        break;
                    } else if (station.getAgricultureSkill() == techREsearchBonusNum) {
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);
                        station.agricultureSkill += 1;
                        System.err.println("Station impacted: "+station.toString());
                        break;
                    }
                }
            }
        }
        if (!"".equals(resultCommand)){
            resultCommand += " ";
        }
        System.err.println("PreCommand = "+resultCommand);
        return resultCommand;
    }

    public String applyEnergyAndColonize_Or_Resupply (ArrayList<Bonus> myBonus, String colonizeAction)
    {
        if(BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus)){
            return BonusType.ENERGY_CORE+" "+ colonizeAction;
        }
        else{
            //no choice
            return "RESUPPLY";
        }
    }

    public String applyColonizeWithAllienAttempt(ArrayList<Bonus> myBonus, Distances distanceToPlay)
    {
        String prefixAllien = "";
        if (distanceToPlay.getDisValueStationPlanet()>=2 && BonusType.ALIEN_ARTIFACT.isBonusAvailableInList(myBonus))
        {
            int allien0;
            int allien1;
            int bonusCounter = 2;
            int[] tasks = new int[2];
            int currentTerraValue = distanceToPlay.getValueTerraformingStationPlanet();
            int currentAllienValue = distanceToPlay.getValueAlienStationPlanet();
            int currentEngValue = distanceToPlay.getValueEngineeringStationPlanet();
            int currentAgriValue = distanceToPlay.getValueAgricultureStationPlanet();
            
            while (currentTerraValue>=1 && bonusCounter>0)
             {   
                tasks[tasks.length-bonusCounter] = 0; //0 for terra
                bonusCounter--;
                currentTerraValue--;
             }
             while (currentAllienValue>=1 && bonusCounter>0)
             {   
                tasks[tasks.length-bonusCounter] = 1; //0 for allien
                bonusCounter--;
                currentAllienValue--;
             }
             while (currentEngValue>=1 && bonusCounter>0)
             {   
                tasks[tasks.length-bonusCounter] = 2; //0 for eng
                bonusCounter--;
                currentEngValue--;
             }
             while (currentAgriValue>=1 && bonusCounter>0)
             {   
                tasks[tasks.length-bonusCounter] = 3; //0 for agri
                bonusCounter--;
                currentAgriValue--;
             }
                 

            prefixAllien+= "ALLIEN_ARTIFACT " + tasks[0] + " "+ tasks[1] + " ";
        }
        
        String colonizeAction="COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus(myBonus);
        return prefixAllien + colonizeAction;
    }
}
