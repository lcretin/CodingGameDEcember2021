package com.codinggame.decembre;

import java.util.Scanner;

public class Main {

    Station[] myStations = new Station[4];
    Station[] oppStations = new Station[4];
    Planet[] planets = new Planet[5];

    Strategy strategy = new Strategy(myStations,oppStations,planets);

    public Main(String[] args) {
        Scanner in = new Scanner(System.in);

        int myCounter = 0;
        int oppCounter = 0;
        for (int i = 0; i < 8; i++) {
            int stationId = in.nextInt();
            int mine = in.nextInt();
            int objectiveScore = in.nextInt(); // receive these points if tech level objectives are met
            int obj0 = in.nextInt();
            int obj1 = in.nextInt();
            int obj2 = in.nextInt();
            int obj3 = in.nextInt();

            StationObjective sto = new StationObjective(objectiveScore, obj0, obj1, obj2, obj3);
            Station st = new Station(stationId, mine);
            st.myStationObj = sto;

            if (st.isMine() == 1) {
                myStations[myCounter] = st;
                myCounter++;
            } else {
                oppStations[oppCounter] = st;
                oppCounter++;
            }

        }

        // game loop
        while (true) {
            int sectorIndex = in.nextInt();
            for (int i = 0; i < 8; i++) {
                int stationId = in.nextInt();
                int mine = in.nextInt();
                int available = in.nextInt();
                int tech0 = in.nextInt();
                int tech1 = in.nextInt();
                int tech2 = in.nextInt();
                int tech3 = in.nextInt();

                Station currentSt = getStationById(myStations,oppStations, stationId);
                currentSt.setTechLevel(tech0, tech1, tech2, tech3);
                currentSt.setAvailable(available);
            }
            int planetCount = in.nextInt();
            for (int i = 0; i < planetCount; i++) {
                int planetId = in.nextInt();
                int tasks0 = in.nextInt();
                int tasks1 = in.nextInt();
                int tasks2 = in.nextInt();
                int tasks3 = in.nextInt();
                int myContribution = in.nextInt(); // the amount of tasks you have already completed
                int oppContribution = in.nextInt();
                int colonizationScore = in.nextInt(); // points awarded to the colonizer having completed the most tasks
                String bonus0 = in.next();
                String bonus1 = in.next();

                Planet p = new Planet(planetId, tasks0, tasks1, tasks2, tasks3, myContribution, oppContribution, colonizationScore, bonus0, bonus1);
                planets[i] = p;

            }
            int bonusCount = in.nextInt(); // bonuses in both you and your opponent's inventories
            for (int i = 0; i < bonusCount; i++) {
                int mine = in.nextInt();
                String bonus = in.next();
            }
            int myColonizationScore = in.nextInt(); // points from planet colonization, does not include bonus points
            int oppColonizationScore = in.nextInt();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            //printMyStations(myStations);
            //printOppStations(oppStations);
            //printPlanets(planets);

            System.out.println(strategy.execute());
        }
    }

    public Station getStationById(Station[] myStations, Station[] oppStations, int id)
    {
        for (int i=0;i<=3;i++)
        {
            if (id==myStations[i].stationId)
                return myStations[i];
        }
        for (int i=0;i<=3;i++)
        {
            if (id==oppStations[i].stationId)
                return oppStations[i];
        }

        return null;
    }

    public void printMyStations(Station[] myStations)
    {
        for (int i=0;i<4;i++)
        {
            System.err.println("my Station " + myStations[i].stationId + " available=" + myStations[i].isAvailable + " tech1" + myStations[i].terraformingSkill + " tech2" + myStations[i].alienSkill + " tech3" + myStations[i].engineeringSkill + " tech4" + myStations[i].agricultureSkill);
            System.err.println("  obj score = " + myStations[i].myStationObj.scoreIfReached + " obj terra=" + myStations[i].myStationObj.terraLevelObj +   " obj alien=" + myStations[i].myStationObj.alienLevelObj);
        }
    }

    public void printOppStations(Station[] oppStations)
    {
        for (int i=0;i<4;i++)
        {
            System.err.println("opp Station " + oppStations[i].stationId + " available=" + oppStations[i].isAvailable + " tech1" + oppStations[i].terraformingSkill + " tech2" + oppStations[i].alienSkill + " tech3" + oppStations[i].engineeringSkill + " tech4" + oppStations[i].agricultureSkill);
        }
    }

    public void printPlanets(Planet[] planets)
    {
        for (int i=0;i<5;i++)
        {
            System.err.println("Planet "  + planets[i].planetId + " task1" + planets[i].terraformingTaskLeftValue + " task2" + planets[i].alienTaskLeftValue + " task3" + planets[i].engineeringTaskLeftValue + " task4" + planets[i].agricultureTaskLeftValue);
            System.err.println("     myContribution=" + planets[i].myContributionTotalTaks + " oppContribution=" + planets[i].oppContributionTotalTasks + " score=" + planets[i].colonizationScore + " bonus0="+ planets[i].bonus0 + " bonus1=" + planets[i].bonus1);
        }
    }
}