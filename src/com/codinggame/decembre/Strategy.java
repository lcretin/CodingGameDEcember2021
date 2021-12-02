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
        Distances distance;
        Distances disMin = null;
        Distances disMinAvailable = null;
        for(int i=0; i<myStations.length; i++){
            for (Planet planet: planets){
                distance = new Distances(myStations[i], planet);
                disMin = distance.getSmallerDistance(disMin);
                disMinAvailable = distance.getSmallerAvailableDistance(disMinAvailable);
                //System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());
            }
        }
        Distances distanceToPlay = disMin;
        if(distanceToPlay.getStation().isAvailable()) {
                return preCommand+applyColonizeWithAllienAttempt(myBonus,distanceToPlay);
        }else{
            //do we have an avaialble station with the same distance ? if yes, let's colonize with it ....
            if(disMinAvailable != null && disMinAvailable.getValueStationPlanet() <= disMin.getValueStationPlanet()){
                return preCommand+applyColonizeWithAllienAttempt(myBonus,disMinAvailable) ;
            }
            //... else let's try to apply a bonus to the non available better one
            //do dwe have a ENERGY BONUS to allow resupply and colonize in one shot
            return preCommand+applyEnergyAndColonize_Or_Resupply(myBonus, applyColonizeWithAllienAttempt(myBonus,distanceToPlay));
            
        }
    }

    public String applyTechPreCommand(){
        String resultCommand = "";
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station
        for(Bonus bonus: myBonus){
            System.err.println("Bonus -> "+ bonus.getBonus());
            int techREsearchBonusNum = -1;
            String commandName = "";
            if(BonusType.NEW_TECH.equals(bonus.getBonus())) {
                techREsearchBonusNum = 0;
                System.err.println("Found Bonus NEW TECH");
                commandName = "NEW_TECH ";
            }else if(BonusType.TECH_RESEARCH_2.equals(bonus.getBonus())) {
                techREsearchBonusNum = 1;
                System.err.println("Found Bonus TechREsearch 2");
                commandName = "TECH_RESEARCH ";
            }else if(BonusType.TECH_RESEARCH_3.equals(bonus.getBonus())) {
                System.err.println("Found Bonus TechREsearch 3");
                techREsearchBonusNum = 2;
                commandName = "TECH_RESEARCH ";
            }if(BonusType.TECH_RESEARCH_4.equals(bonus.getBonus())) {
                System.err.println("Found Bonus TechREsearch 4");
                techREsearchBonusNum = 3;
                commandName = "TECH_RESEARCH ";
            }
            if (techREsearchBonusNum >= 0) {
                for (int i = 0; i < myStations.length; i++) {
                    Station station = myStations[i];

                    if (station.getTerraformingSkill() == techREsearchBonusNum) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);
                        station.terraformingSkill += 1;
                        break;
                    } else if (station.getAlienSkill() == techREsearchBonusNum) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);
                        station.alienSkill += 1;
                        break;
                    } else if (station.getEngineeringSkill() == techREsearchBonusNum) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);
                        station.engineeringSkill += 1;
                        break;
                    } else if (station.getAgricultureSkill() == techREsearchBonusNum) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);
                        station.agricultureSkill += 1;
                        break;
                    }
                }
            }
        }
        if (!"".equals(resultCommand)){
            resultCommand += " ";
        }
        System.err.println("PreCommand-> ["+resultCommand+"]");
        return resultCommand;
    }

    public  boolean isBonusAvailable(ArrayList<Bonus> myBonus, BonusType bonusType ){
        if(myBonus == null){
            return false;
        }
        for(Bonus bonus: myBonus){
            if(bonusType.equals(bonus.getBonus())){
                return true;
            }
        }
        return false;
    }

    public String applyEnergyAndColonize_Or_Resupply (ArrayList<Bonus> myBonus, String colonizeAction)
    {
        if(isBonusAvailable(myBonus, BonusType.ENERGY_CORE)){
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
        if (distanceToPlay.getValueStationPlanet()>=2 && isBonusAvailable(myBonus, BonusType.ALIEN_ARTIFACT))
        {
            prefixAllien+= "ALLIEN_ARTIFACT 0 1 ";
        }
        
        String colonizeAction="COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus();
        return prefixAllien + colonizeAction;
    }
}
