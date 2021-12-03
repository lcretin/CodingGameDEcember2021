package com.codinggame.decembre;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

    private Logger logger = new Logger();

    private Station[] myStations = new Station[4];

    private Station[] oppStations = new Station[4];
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<Bonus> myBonus = new ArrayList<Bonus>();
    private ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();

    public Strategy(Station[] myStations, Station[] oppStations, ArrayList<Planet> planets, ArrayList<Bonus> myBonus, ArrayList<Bonus> oppBonus) {
        this.myStations = myStations;
        this.oppStations = oppStations;
        this.planets = planets;
        this.myBonus = myBonus;
        this.oppBonus = oppBonus;
    }

    public String execute() {

        String techResearchBonusPreCommand = applyTechPreCommand();
        String cmd;
        Distances newDistanceToPlay = null;

        //ArrayList<Distances> distancesArrayList = computeAllSmallestDistances();
        ArrayList<Distances> distancesArrayList = computeAllDistances();
        logger.println(" Distance size "+distancesArrayList.size());
        Distances distanceToPlay = getBestTokenUsableFromList(distancesArrayList, myBonus);
        logger.println("Distance To play:" + distanceToPlay.toString());

        //is the station to play from a distance point of view available?...
        if (distanceToPlay.getStation().isAvailable()) {
            //#######################################################################################
            // ALLIEN + COLONIZE
            cmd = techResearchBonusPreCommand + applyColonizeWithAllienAttempt(myBonus, distanceToPlay);
            logger.println("COMMAND1 = " + cmd);
            return cmd;
        } else {
            //... else do we have an avaialble station with the same distance ? if yes, let's colonize with it ....
            newDistanceToPlay = getBestTokenUsableFromList(geAvailablesFromList(distancesArrayList), myBonus);
            if (newDistanceToPlay != null && newDistanceToPlay.getDisValueStationPlanet() <= distanceToPlay.getDisValueStationPlanet()) {
                logger.println("Distance To play (Min Available):" + newDistanceToPlay.toString());
                //#######################################################################################
                // ALLIEN + COLONIZE (NEXT AVAILABLE STATION IF FIRST IS DISABLED)
                cmd = techResearchBonusPreCommand + applyColonizeWithAllienAttempt(myBonus, newDistanceToPlay);
                logger.println("COMMAND2 = " + cmd);
                return cmd;
            }
            //... else let's try to apply a bonus to the non available better one
            //do we have a ENERGY BONUS to allow resupply and colonize in one shot
            //#######################################################################################
            // ENERGY +ALLIEN + COLONIZE or RESUPPLY
            cmd = techResearchBonusPreCommand + applyEnergyAndColonize_Or_Resupply(myBonus, applyColonizeWithAllienAttempt(myBonus, distanceToPlay));
            logger.println("COMMAND3 = " + cmd);
            return cmd;

        }
    }

    /**
     * compute all the smallest distances and tokens
     *
     * @return
     */
    public ArrayList<Distances> computeAllSmallestDistances() {
        ArrayList<Distances> distancesArrayList = new ArrayList<>();

        Distances distance;
        Distances disMin = null;

        for (int i = 0; i < myStations.length; i++) {
            for (Planet planet : planets) {
                distance = new Distances(myStations[i], planet);
                if (distancesArrayList.size() == 0) {
                    distancesArrayList.add(distance);
                    disMin = distance;
                } else {
                    if (distance.isSmallerDistanceThan(disMin)) {
                        distancesArrayList.clear();
                        distancesArrayList.add(distance);
                        disMin = distance;
                    } else if (distance.isEqualDistanceThan(disMin)) {
                        distancesArrayList.add(distance);
                    }
                }
                //logger.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());
            }
        }

        logger.println("Number of min Dist=" + distancesArrayList.size());

        return distancesArrayList;
    }


    /**
     * compute all the  distances and tokens
     *
     * @return
     */
    public ArrayList<Distances> computeAllDistances() {
        ArrayList<Distances> distancesArrayList = new ArrayList<>();

        Distances distance;

        for (int i = 0; i < myStations.length; i++) {
            for (Planet planet : planets) {
                distance = new Distances(myStations[i], planet);
                distancesArrayList.add(distance);
            }
        }

        return distancesArrayList;
    }

    /**
     * @param distancesArrayList
     * @return a list whit only available stations in every distance
     */
    public ArrayList<Distances> geAvailablesFromList(ArrayList<Distances> distancesArrayList) {
        ArrayList<Distances> list = new ArrayList<>();
        if (distancesArrayList != null) {
            for (Distances distances : distancesArrayList) {
                if (distances.getStation().isAvailable()) {
                    list.add(distances);
                }
            }
        }
        return list;
    }

    /**
     * @param distancesArrayList
     * @return the best Distances object (max usage of skills tokens when all distances are equal)
     */
    public Distances getBestTokenUsableFromList(ArrayList<Distances> distancesArrayList, ArrayList<Bonus> myBonus) {
        if (distancesArrayList == null || distancesArrayList.size() == 0) {
            return null;
        }

        for (Distances currDis : distancesArrayList) {
            if (currDis.willCompleteColonize(false))
                return currDis;
        }

        Distances prev = null;
        for (Distances distances : distancesArrayList) {
            if (prev == null) {
                prev = distances;
            } else {
                if (distances.getUsableToken() > prev.getUsableToken()) {
                    prev = distances;
                }
            }
        }

        logger.println("Usable token max is -> "+prev.toString());

        //if same nbr of tokens, chose the station/planet where we can win against the opp
        //Build the list of Distances with the same nbr of token to be used
        ArrayList<Distances> optimizedForTokenDistances = new ArrayList<Distances>();
        for (Distances distances : distancesArrayList) {
            if (distances.getUsableToken() == prev.getUsableToken())
            {
                logger.println(distances.toString());
                optimizedForTokenDistances.add(distances);
            }
        }

        boolean usedAlienBonus = isAlienTokenElligible(myBonus, optimizedForTokenDistances.get(0));

        //if we can be better than the opp let's do it
        for (Distances optimDis : optimizedForTokenDistances) {
            if (optimDis.willBeBetter(usedAlienBonus))
                return optimDis;
        }

        //if we can complete a colonization and win against the opp at teh same time, let's do it
        for (Distances optimDis : optimizedForTokenDistances) {
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
     *
     * @return
     */
    public String applyTechPreCommand() {
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station
        ArrayList<TechCommand> techCommands = new ArrayList<TechCommand>();
        List<TechEnum> techEnumList = TechEnum.getAllTechEnum();
        for (Bonus bonus : myBonus) {
            logger.println(bonus.toString());

            // Check that the bonus is a Tech Command
            if (BonusType.NEW_TECH.equals(bonus.getBonus()) ||
                    BonusType.TECH_RESEARCH_2.equals(bonus.getBonus()) ||
                    BonusType.TECH_RESEARCH_3.equals(bonus.getBonus()) ||
                    BonusType.TECH_RESEARCH_4.equals(bonus.getBonus())) {

                TechCommand bestForObjectiveCandidate = null;
                TechCommand defaultCandidate = null;
                TechCommand defaultNewTech = null;

                for (int i = 0; i < myStations.length; i++) {
                    Station station = myStations[i];
                    TechCommand currentTechCommand = new TechCommand(bonus.getBonus(), station);
                    TechCommand currentDefaultNewTechTechCommand = new TechCommand(BonusType.NEW_TECH, station);

                    for (TechEnum curTechEnum : techEnumList) {
                        if (defaultCandidate == null && currentTechCommand.canApplyTechEnum(curTechEnum)) {
                            currentTechCommand.setTechApplying(curTechEnum);
                            defaultCandidate = currentTechCommand;
                            System.err.println("***Default applying Techn Enum to --->" + defaultCandidate);
                        }
                        if (bestForObjectiveCandidate == null && currentTechCommand.canApplyBestObjectiveTechEnum(curTechEnum)) {
                            currentTechCommand.setTechApplying(curTechEnum);
                            bestForObjectiveCandidate = currentTechCommand;
                            System.err.println("***Best applying Tech Enum to --->" + bestForObjectiveCandidate);
                        }
                        // default on new tech only if the objective is not reached.
                        if (defaultNewTech == null && currentDefaultNewTechTechCommand.canApplyBestObjectiveTechEnum(curTechEnum)) {
                            currentDefaultNewTechTechCommand.setTechApplying(curTechEnum);
                            currentDefaultNewTechTechCommand.setBonusType(bonus.getBonus());
                            defaultNewTech = currentDefaultNewTechTechCommand;
                            System.err.println("***NEW TEch default applying Techn Enum to --->" + defaultNewTech);
                        }

                    }
                }

                logger.println("--->Found best " + bestForObjectiveCandidate);
                logger.println("--->Default " + defaultCandidate);
                logger.println("--->Default NEW TEch" + defaultNewTech);

                // Now I will add either the best to fulfill
                if (bestForObjectiveCandidate != null) {
                    bestForObjectiveCandidate.apply();
                    techCommands.add(bestForObjectiveCandidate);
                    logger.println("      BestObjectiveCandidate for Bonus " + bestForObjectiveCandidate.toString());
                } else if (defaultCandidate != null) {
                    defaultCandidate.apply();
                    techCommands.add(defaultCandidate);
                    logger.println("      Default Candidate for Bonus " + defaultCandidate.toString());
                } else if (defaultNewTech != null) {
                    defaultNewTech.apply();
                    techCommands.add(defaultNewTech);
                    logger.println("      Default NEW Tech for Bonus " + defaultNewTech.toString());
                } else {
                    logger.println("The Bonus is not applicable " + bonus.toString());
                }
            }
        }

        String command = "";

        if(!techCommands.isEmpty()) {
            for (TechCommand techCommand : techCommands) {
                command = techCommand.executeCommand();
            }
            command += " ";
        }

        logger.println("PreCommand = " + command);
        return command;
    }

    /**
     * ENERGY BONUS AND COLONIZE (BUILT FROM OUTSIDE AND PASSED)
     *
     * @param myBonus
     * @param colonizeAction
     * @return
     */
    public String applyEnergyAndColonize_Or_Resupply(ArrayList<Bonus> myBonus, String colonizeAction) {
        if (BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus)) {
            return BonusType.ENERGY_CORE + " " + colonizeAction;
        } else {
            //no choice
            return "RESUPPLY";
        }
    }

    /**
     * ALIEN AND BUILD COLONIZE
     *
     * @param myBonus
     * @param distanceToPlay
     * @return
     */
    public String applyColonizeWithAllienAttempt(ArrayList<Bonus> myBonus, Distances distanceToPlay) {
        String prefixAllien = "";
        if (isAlienTokenElligible(myBonus, distanceToPlay)) {
            int bonusCounter = 2;
            int[] tasks = new int[2];
            int currentTerraValue = 0;
            if (distanceToPlay.getValueTerraformingStationPlanet() != null)
                currentTerraValue = distanceToPlay.getValueTerraformingStationPlanet();

            int currentAllienValue = 0;
            if (distanceToPlay.getValueAlienStationPlanet() != null)
                currentAllienValue = distanceToPlay.getValueAlienStationPlanet();

            int currentEngValue = 0;
            if (distanceToPlay.getValueEngineeringStationPlanet() != null)
                currentEngValue = distanceToPlay.getValueEngineeringStationPlanet();

            int currentAgriValue = 0;
            if (distanceToPlay.getValueAgricultureStationPlanet() != null)
                currentAgriValue = distanceToPlay.getValueAgricultureStationPlanet();

            while (currentTerraValue >= 1 && bonusCounter > 0) {
                tasks[tasks.length - bonusCounter] = 0; //0 for terra
                bonusCounter--;
                currentTerraValue--;
            }
            while (currentAllienValue >= 1 && bonusCounter > 0) {
                tasks[tasks.length - bonusCounter] = 1; //0 for allien
                bonusCounter--;
                currentAllienValue--;
            }
            while (currentEngValue >= 1 && bonusCounter > 0) {
                tasks[tasks.length - bonusCounter] = 2; //0 for eng
                bonusCounter--;
                currentEngValue--;
            }
            while (currentAgriValue >= 1 && bonusCounter > 0) {
                tasks[tasks.length - bonusCounter] = 3; //0 for agri
                bonusCounter--;
                currentAgriValue--;
            }


            prefixAllien += BonusType.ALIEN_ARTIFACT + " " + tasks[0] + " " + tasks[1] + " ";
        }

        String colonizeAction = "COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus(myBonus);
        return prefixAllien + colonizeAction;
    }

    //this method is called twice : applyColonizeWithAllienAttempt and execute to tune best token
    public Boolean isAlienTokenElligible(ArrayList<Bonus> myBonus, Distances distanceToPlay) {
        return distanceToPlay.getDisValueStationPlanet() >= 2 && BonusType.ALIEN_ARTIFACT.isBonusAvailableInList(myBonus);
    }

/*
    public static void main(String[] args) {
        Station myStation1 = new Station(1, 1);
        myStation1.setTechLevel(2, 2, 0, 0);
        myStation1.setAvailable(1);
        StationObjective objective = new StationObjective(4, 2, 2, 0, 1);
        myStation1.setObjective(objective);

        Station myStation2 = new Station(2, 1);
        myStation2.setTechLevel(2, 2, 2, 2);
        myStation2.setAvailable(1);

        Station oppStation = new Station(2, 0);
        oppStation.setTechLevel(1, 1, 1, 1);

        Planet myPlanet1 = new Planet(1, 3, 3, 0, 0, 1, 0, 2, "ENERGY_CORE", "POINTS_3");
        Planet myPlanet2 = new Planet(2, 3, 3, 0, 0, 0, 1, 2, "ENERGY_CORE", "POINTS_3");
        Planet myPlanet3 = new Planet(2, 3, 3, 0, 0, 0, 1, 2, "ENERGY_CORE", "POINTS_3");

        Station[] myStations = new Station[2];
        Station[] oppStations = new Station[1];
        ArrayList<Planet> planets = new ArrayList<Planet>();

        myStations[0] = myStation1;
        myStations[1] = myStation2;
        oppStations[0] = oppStation;
        planets.add(myPlanet1);
        planets.add(myPlanet2);

        ArrayList<Bonus> myBonus = new ArrayList<Bonus>();
        myBonus.add(new Bonus("TECH_RESEARCH_4"));

        Strategy strategy = new Strategy(myStations, oppStations, planets, myBonus, null);
        strategy.applyTechPreCommand();
    }
    */


}
