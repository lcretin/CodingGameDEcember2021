package com.codinggame.decembre;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Strategy {

    private Logger logger = new Logger();

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
        
        String techResearchBonusPreCommand = applyTechPreCommand();
        String cmd;
        Distances newDistanceToPlay = null;

        ArrayList<Distances> distancesArrayList=computeAllDIstances();
        Distances distanceToPlay = getBestTokenUsableFromList(distancesArrayList,myBonus) ;
        logger.println("Distrance To play:"+distanceToPlay.toString());

        //is the station to play from a distance point of view available?...
        if(distanceToPlay.getStation().isAvailable()) {
                //#######################################################################################
                // ALLIEN + COLONIZE
                cmd = techResearchBonusPreCommand+applyColonizeWithAllienAttempt(myBonus,distanceToPlay);
                logger.println("COMMAND1 = "+ cmd);
                return cmd;
        }else{
            //... else do we have an avaialble station with the same distance ? if yes, let's colonize with it ....
            newDistanceToPlay = getBestTokenUsableFromList(geAvailablesFromList(distancesArrayList),myBonus);
            if(newDistanceToPlay != null && newDistanceToPlay.getDisValueStationPlanet() <= distanceToPlay.getDisValueStationPlanet()){
                logger.println("Distance To play (Min Available):"+newDistanceToPlay.toString());
                 //#######################################################################################
                // ALLIEN + COLONIZE (NEXT AVAILABLE STATION IF FIRST IS DISABLED)
                cmd = techResearchBonusPreCommand+applyColonizeWithAllienAttempt(myBonus,newDistanceToPlay) ;
                logger.println("COMMAND2 = "+ cmd);
                return cmd;
            }
            //... else let's try to apply a bonus to the non available better one
            //do we have a ENERGY BONUS to allow resupply and colonize in one shot
             //#######################################################################################
                // ENERGY +ALLIEN + COLONIZE or RESUPPLY
                cmd = techResearchBonusPreCommand+applyEnergyAndColonize_Or_Resupply(myBonus, applyColonizeWithAllienAttempt(myBonus,distanceToPlay));
                logger.println("COMMAND3 = "+ cmd);
                return cmd;
            
        }
    }

    /**
     * compute all needed distances and tokens
     * @return
     */
    public ArrayList<Distances> computeAllDIstances()
    {
        ArrayList<Distances> distancesArrayList = new ArrayList<>();

        Distances distance;
        Distances disMin = null;
        
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
                //logger.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());
            }
        }

        logger.println("Number of min Dist="+distancesArrayList.size());
        
        return distancesArrayList;
    }

    /**
     * 
     * @param distancesArrayList
     * @return a list whit only available stations in every distance
     */
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

    /**
     * 
     * @param distancesArrayList
     * @return the best Distances object (max usage of skills tokens when all distances are equal)
     */
    public Distances getBestTokenUsableFromList(ArrayList<Distances> distancesArrayList, ArrayList<Bonus> myBonus){
        if (distancesArrayList == null || distancesArrayList.size()==0){
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
           
        //if same nbr of tokens, chose the station/planet where we can win against the opp
        //Build the list of Distances with the same nbr of token to be used
        ArrayList<Distances> optimizedForTokenDistances = new ArrayList<Distances>();
        for(Distances distances: distancesArrayList){
            if (distances.getUsableToken() == prev.getUsableToken())
                optimizedForTokenDistances.add(distances);
        }

        boolean usedAlienBonus = isAlienTokenElligible(myBonus, optimizedForTokenDistances.get(0));
  
        //if we can be better than the opp let's do it
        for(Distances optimDis: optimizedForTokenDistances){
            if (optimDis.willBeBetter(usedAlienBonus))
                return optimDis;
        }

        //if we can complete a colonization and win against the opp at teh same time, let's do it
        for(Distances optimDis: optimizedForTokenDistances){
        if (optimDis.willCompleteColonize(usedAlienBonus))
            return optimDis;
        }
        
        return optimizedForTokenDistances.get(0);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //    *****          *****      *       *   *      *       ********
    //    *    *        *     *     * *     *   *      *       *
    //    *****         *     *     *   *   *   *      *       *
    //    *    *        *     *     *     * *   *      *       ********
    //    *    *        *     *     *      **   *      *              *
    //    *****          *****      *       *   ********       ********
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Try to use the TECH_RESEARCH BONUS
     * @return
     */
    public String applyTechPreCommand(){
        String resultCommand = "";
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station
        for(Bonus bonus: myBonus){
            logger.println(bonus.toString());
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
                for (int i = 0; i < myStations.length; i++) {
                    Station station = myStations[i];
                   
                    if (station.getTerraformingSkill() == techREsearchBonusNum && station.isTerraformingObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);
                        station.terraformingSkill += 1;

                        logger.println("Station impacted: "+station.toString());
                        break;
                    } else if (station.getAlienSkill() == techREsearchBonusNum && station.isAlienObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);
                        station.alienSkill += 1;
                        logger.println("Station impacted: "+station.toString());
                        break;
                    } else if (station.getEngineeringSkill() == techREsearchBonusNum && station.isEngineeringObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);
                        station.engineeringSkill += 1;
                        logger.println("Station impacted: "+station.toString());
                        break;
                    } else if (station.getAgricultureSkill() == techREsearchBonusNum && station.isAgricultureObjectiveReached()) {
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);
                        station.agricultureSkill += 1;
                        logger.println("Station impacted: "+station.toString());
                        break;
                    }
                }
                if ("".equals(resultCommand)) //bonus not used to fill station objective, let's fill the first available task-station
                {
                    for (int i = 0; i < myStations.length; i++) {
                        Station station = myStations[i];
                        if (station.getTerraformingSkill() == techREsearchBonusNum) {
                            resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);
                            station.terraformingSkill += 1;
                            logger.println("Station impacted: "+station.toString());
                            break;
                        } else if (station.getAlienSkill() == techREsearchBonusNum) {
                            resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);
                            station.alienSkill += 1;
                            logger.println("Station impacted: "+station.toString());
                            break;
                        } else if (station.getEngineeringSkill() == techREsearchBonusNum) {
                            resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);
                            station.engineeringSkill += 1;
                            logger.println("Station impacted: "+station.toString());
                            break;
                        } else if (station.getAgricultureSkill() == techREsearchBonusNum) {
                            resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);
                            station.agricultureSkill += 1;
                            logger.println("Station impacted: "+station.toString());
                            break;
                        }
                    }
                }
            }
        }
        if (!"".equals(resultCommand)){
            resultCommand += " ";
        }
        logger.println("PreCommand = "+resultCommand);
        return resultCommand;
    }

    /**
     * ENERGY BONUS AND COLONIZE (BUILT FROM OUTSIDE AND PASSED)
     * @param myBonus
     * @param colonizeAction
     * @return
     */
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

    /**
     * ALIEN AND BUILD COLONIZE
     * @param myBonus
     * @param distanceToPlay
     * @return
     */
    public String applyColonizeWithAllienAttempt(ArrayList<Bonus> myBonus, Distances distanceToPlay)
    {
        String prefixAllien = "";
        if (isAlienTokenElligible(myBonus, distanceToPlay))
        {
            int bonusCounter = 2;
            int[] tasks = new int[2];
            int currentTerraValue = 0;
            if (distanceToPlay.getValueTerraformingStationPlanet()!=null)
                currentTerraValue = distanceToPlay.getValueTerraformingStationPlanet();

            int currentAllienValue = 0;
            if (distanceToPlay.getValueAlienStationPlanet()!=null)
                currentAllienValue = distanceToPlay.getValueAlienStationPlanet();

            int currentEngValue = 0;
            if (distanceToPlay.getValueEngineeringStationPlanet()!=null)
                currentEngValue = distanceToPlay.getValueEngineeringStationPlanet();

            int currentAgriValue = 0;
            if (distanceToPlay.getValueAgricultureStationPlanet()!=null)
                currentAgriValue = distanceToPlay.getValueAgricultureStationPlanet();

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

    //this method is called twice : applyColonizeWithAllienAttempt and execute to tune best token
    public Boolean isAlienTokenElligible(ArrayList<Bonus> myBonus, Distances distanceToPlay)
    {
        return distanceToPlay.getDisValueStationPlanet()>=2 && BonusType.ALIEN_ARTIFACT.isBonusAvailableInList(myBonus);
    }

}
