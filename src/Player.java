/*
This file has been generated
*/

import java.util.Scanner;
class Player {
class Distances {  // Distances.java, 3
    private Station station;  // Distances.java, 5
    private Planet planet;  // Distances.java, 6
    private Integer valueStationPlanet = null;  // Distances.java, 7
    public Distances(Station station, Planet planet){  // Distances.java, 9
        this.station = station;  // Distances.java, 10
        this.planet = planet;  // Distances.java, 11
        this.compute();  // Distances.java, 12
    }  // Distances.java, 13
    public void compute(){  // Distances.java, 15
        Integer result = null;  // Distances.java, 16
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 17
        if(this.planet.getTerraformingTaskLeftValue() != 0 ) {  // Distances.java, 18
            int disTerra = this.planet.getTerraformingTaskLeftValue() - this.station.getTerraformingSkill();  // Distances.java, 19
            if(disTerra < 0){  // Distances.java, 20
                if(result == null){  // Distances.java, 21
                    result = 0;  // Distances.java, 22
                }  // Distances.java, 23
            }else{  // Distances.java, 24
                if(result == null){  // Distances.java, 25
                    result = disTerra;  // Distances.java, 26
                }else{  // Distances.java, 27
                    result += disTerra;  // Distances.java, 28
                }  // Distances.java, 29
            }  // Distances.java, 30
        }  // Distances.java, 31
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 34
        if(this.planet.getAlienTaskLeftValue() != 0 ) {  // Distances.java, 35
            int disAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();  // Distances.java, 36
            if(disAlien < 0){  // Distances.java, 37
                if(result == null){  // Distances.java, 38
                    result = 0;  // Distances.java, 39
                }  // Distances.java, 40
            }else{  // Distances.java, 41
                if(result == null){  // Distances.java, 42
                    result = disAlien;  // Distances.java, 43
                }else{  // Distances.java, 44
                    result += disAlien;  // Distances.java, 45
                }  // Distances.java, 46
            }  // Distances.java, 47
        }  // Distances.java, 48
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 52
        if(this.planet.getAlienTaskLeftValue() != 0 ) {  // Distances.java, 53
            int disEng = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();  // Distances.java, 54
            if(disEng < 0){  // Distances.java, 55
                if(result == null){  // Distances.java, 56
                    result = 0;  // Distances.java, 57
                }  // Distances.java, 58
            }else{  // Distances.java, 59
                if(result == null){  // Distances.java, 60
                    result = disEng;  // Distances.java, 61
                }else{  // Distances.java, 62
                    result += disEng;  // Distances.java, 63
                }  // Distances.java, 64
            }  // Distances.java, 65
        }  // Distances.java, 66
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 69
        if(this.planet.getAgricultureTaskLeftValue() != 0 ) {  // Distances.java, 70
            int disAgri = this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();  // Distances.java, 71
            if(disAgri < 0){  // Distances.java, 72
                if(result == null){  // Distances.java, 73
                    result = 0;  // Distances.java, 74
                }  // Distances.java, 75
            }else{  // Distances.java, 76
                if(result == null){  // Distances.java, 77
                    result = disAgri;  // Distances.java, 78
                }else{  // Distances.java, 79
                    result += disAgri;  // Distances.java, 80
                }  // Distances.java, 81
            }  // Distances.java, 82
        }  // Distances.java, 83
       this.valueStationPlanet = result;  // Distances.java, 85
    }  // Distances.java, 86
    public boolean isSmallerThan(Distances distances){  // Distances.java, 88
        return distances == null || (distances.valueStationPlanet != null && this.valueStationPlanet < distances.valueStationPlanet);  // Distances.java, 89
    }  // Distances.java, 90
    public Distances getSmallerDistance(Distances distances){  // Distances.java, 92
           if(this.isSmallerThan(distances)){  // Distances.java, 93
               return this;  // Distances.java, 94
           }else{  // Distances.java, 95
               return distances;  // Distances.java, 96
           }  // Distances.java, 97
    }  // Distances.java, 98
    public Station getStation() {  // Distances.java, 100
        return station;  // Distances.java, 101
    }  // Distances.java, 102
    public Planet getPlanet() {  // Distances.java, 104
        return planet;  // Distances.java, 105
    }  // Distances.java, 106
    public int getValueStationPlanet() {  // Distances.java, 108
        return valueStationPlanet;  // Distances.java, 109
    }  // Distances.java, 110
}  // Distances.java, 111

class StationObjective {  // StationObjective.java, 3
    int scoreIfReached;  // StationObjective.java, 4
    int terraLevelObj;  // StationObjective.java, 6
    int alienLevelObj;  // StationObjective.java, 7
    int engineeringLevelObj;  // StationObjective.java, 8
    int agricultureLevelObj;  // StationObjective.java, 9
    public StationObjective(int score,int obj0, int obj1, int obj2, int obj3)  // StationObjective.java, 11
    {  // StationObjective.java, 12
        this.scoreIfReached=score;  // StationObjective.java, 13
        this.terraLevelObj=obj0;  // StationObjective.java, 14
        this.alienLevelObj=obj1;  // StationObjective.java, 15
        this.engineeringLevelObj=obj2;  // StationObjective.java, 16
        this.agricultureLevelObj=obj3;  // StationObjective.java, 17
    }  // StationObjective.java, 18
}  // StationObjective.java, 19

class Planet {  // Planet.java, 3
    int planetId;  // Planet.java, 4
    //left to complete  // Planet.java, 5
    int terraformingTaskLeftValue;  // Planet.java, 6
    int alienTaskLeftValue;  // Planet.java, 7
    int engineeringTaskLeftValue;  // Planet.java, 8
    int agricultureTaskLeftValue;  // Planet.java, 9
    int myContributionTotalTaks;  // Planet.java, 11
    int oppContributionTotalTasks;  // Planet.java, 12
    int colonizationScore;  // Planet.java, 14
    String bonus0;  // Planet.java, 16
    String bonus1;  // Planet.java, 17
    public Planet(int id, int tValue, int alValue, int eValue, int agValue, int myC, int oppC, int coloScore,String bonus0, String bonus1)  // Planet.java, 20
    {  // Planet.java, 21
        this.planetId=id;  // Planet.java, 22
        this.terraformingTaskLeftValue =tValue;  // Planet.java, 23
        this.alienTaskLeftValue =alValue;  // Planet.java, 24
        this.engineeringTaskLeftValue =eValue;  // Planet.java, 25
        this.agricultureTaskLeftValue =agValue;  // Planet.java, 26
        this.myContributionTotalTaks = myC;  // Planet.java, 27
        this.oppContributionTotalTasks=oppC;  // Planet.java, 28
        this.colonizationScore=coloScore;  // Planet.java, 29
        this.bonus0=bonus0;  // Planet.java, 30
        this.bonus1=bonus1;  // Planet.java, 31
    }  // Planet.java, 32
    public int getPlanetId() {  // Planet.java, 34
        return planetId;  // Planet.java, 35
    }  // Planet.java, 36
    public int getTerraformingTaskLeftValue() {  // Planet.java, 38
        return terraformingTaskLeftValue;  // Planet.java, 39
    }  // Planet.java, 40
    public int getAlienTaskLeftValue() {  // Planet.java, 42
        return alienTaskLeftValue;  // Planet.java, 43
    }  // Planet.java, 44
    public int getEngineeringTaskLeftValue() {  // Planet.java, 46
        return engineeringTaskLeftValue;  // Planet.java, 47
    }  // Planet.java, 48
    public int getAgricultureTaskLeftValue() {  // Planet.java, 50
        return agricultureTaskLeftValue;  // Planet.java, 51
    }  // Planet.java, 52
    public int getMyContributionTotalTaks() {  // Planet.java, 54
        return myContributionTotalTaks;  // Planet.java, 55
    }  // Planet.java, 56
    public int getOppContributionTotalTasks() {  // Planet.java, 58
        return oppContributionTotalTasks;  // Planet.java, 59
    }  // Planet.java, 60
    public int getColonizationScore() {  // Planet.java, 62
        return colonizationScore;  // Planet.java, 63
    }  // Planet.java, 64
    public String getBonus0() {  // Planet.java, 66
        return bonus0;  // Planet.java, 67
    }  // Planet.java, 68
    public String getBonus1() {  // Planet.java, 70
        return bonus1;  // Planet.java, 71
    }  // Planet.java, 72
    public String getBestBonus(){  // Planet.java, 74
        return "0";  // Planet.java, 75
    }  // Planet.java, 76
}  // Planet.java, 77

class Station {  // Station.java, 3
    int stationId;  // Station.java, 4
    int isMine;  // Station.java, 5
    int isAvailable;  // Station.java, 6
    //tech values  // Station.java, 8
    int terraformingSkill;  // Station.java, 9
    int alienSkill;  // Station.java, 10
    int engineeringSkill;  // Station.java, 11
    int agricultureSkill;  // Station.java, 12
    //  // Station.java, 14
    StationObjective myStationObj;  // Station.java, 15
    //constructor  // Station.java, 17
    public Station(int id,int isMine)  // Station.java, 18
    {  // Station.java, 19
        this.stationId=id;  // Station.java, 20
        this.isMine=isMine;  // Station.java, 21
    }  // Station.java, 23
    public void setTechLevel(int tValue,int alValue,int eValue,int agValue)  // Station.java, 24
    {  // Station.java, 25
        this.terraformingSkill =tValue;  // Station.java, 26
        this.alienSkill =alValue;  // Station.java, 27
        this.engineeringSkill =eValue;  // Station.java, 28
        this.agricultureSkill =agValue;  // Station.java, 29
    }  // Station.java, 30
    public void setAvailable(int available)  // Station.java, 32
    {  // Station.java, 33
        this.isAvailable=available;  // Station.java, 34
    }  // Station.java, 35
    public int isMine()  // Station.java, 37
    {  // Station.java, 38
        return isMine;  // Station.java, 39
    }  // Station.java, 40
    public boolean isAvailable()  // Station.java, 42
    {  // Station.java, 43
        return isAvailable==1;  // Station.java, 44
    }  // Station.java, 45
    public void setObjective(StationObjective stO)  // Station.java, 47
    {  // Station.java, 48
        this.myStationObj=stO;  // Station.java, 49
    }  // Station.java, 50
    public int getStationId() {  // Station.java, 52
        return stationId;  // Station.java, 53
    }  // Station.java, 54
    public int getIsMine() {  // Station.java, 56
        return isMine;  // Station.java, 57
    }  // Station.java, 58
    public int getIsAvailable() {  // Station.java, 60
        return isAvailable;  // Station.java, 61
    }  // Station.java, 62
    public int getTerraformingSkill() {  // Station.java, 64
        return terraformingSkill;  // Station.java, 65
    }  // Station.java, 66
    public int getAlienSkill() {  // Station.java, 68
        return alienSkill;  // Station.java, 69
    }  // Station.java, 70
    public int getEngineeringSkill() {  // Station.java, 72
        return engineeringSkill;  // Station.java, 73
    }  // Station.java, 74
    public int getAgricultureSkill() {  // Station.java, 76
        return agricultureSkill;  // Station.java, 77
    }  // Station.java, 78
    public StationObjective getMyStationObj() {  // Station.java, 80
        return myStationObj;  // Station.java, 81
    }  // Station.java, 82
}  // Station.java, 83

class Strategy {  // Strategy.java, 3
    private Station[] myStations = new Station[4];  // Strategy.java, 6
    private Station[] oppStations = new Station[4];  // Strategy.java, 8
    private Planet[] planets = new Planet[5];  // Strategy.java, 9
    public Strategy(Station[] myStations , Station[] oppStations, Planet[] planets){  // Strategy.java, 11
        this.myStations = myStations;  // Strategy.java, 12
        this.oppStations = oppStations;  // Strategy.java, 13
        this.planets = planets;  // Strategy.java, 14
    }  // Strategy.java, 15
    public String execute(){  // Strategy.java, 17
        // main actions: COLONIZE | RESUPPLY  // Strategy.java, 18
        // bonus actions: ENERGY_CORE | ALIEN_ARTIFACT | TECH_RESEARCH | NEW_TECH  // Strategy.java, 19
        // Append text after any command and that text will appear on screen.  // Strategy.java, 20
        Distances distance;  // Strategy.java, 21
        Distances disMin = null;  // Strategy.java, 22
        for(int i=0; i<myStations.length; i++){  // Strategy.java, 23
            for (int p = 0; p < planets.length; p++){  // Strategy.java, 24
                distance = new Distances(myStations[i], planets[p]);  // Strategy.java, 25
                disMin = distance.getSmallerDistance(disMin);  // Strategy.java, 26
                System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());  // Strategy.java, 27
            }  // Strategy.java, 28
        }  // Strategy.java, 29
        if(disMin.getStation().isAvailable()) {  // Strategy.java, 31
            return "COLONIZE " + disMin.getStation().getStationId() + " " + disMin.getPlanet().getPlanetId() + " " + disMin.getPlanet().getBestBonus();  // Strategy.java, 32
        }else{  // Strategy.java, 33
            return "RESUPPLY";  // Strategy.java, 34
        }  // Strategy.java, 35
    }  // Strategy.java, 36
}  // Strategy.java, 38

class Main {  // Main.java, 5
    Station[] myStations = new Station[4];  // Main.java, 7
    Station[] oppStations = new Station[4];  // Main.java, 8
    Planet[] planets = new Planet[5];  // Main.java, 9
    Strategy strategy = new Strategy(myStations,oppStations,planets);  // Main.java, 11
    public Main(String[] args) {  // Main.java, 13
        Scanner in = new Scanner(System.in);  // Main.java, 14
        int myCounter = 0;  // Main.java, 16
        int oppCounter = 0;  // Main.java, 17
        for (int i = 0; i < 8; i++) {  // Main.java, 18
            int stationId = in.nextInt();  // Main.java, 19
            int mine = in.nextInt();  // Main.java, 20
            int objectiveScore = in.nextInt(); // receive these points if tech level objectives are met  // Main.java, 21
            int obj0 = in.nextInt();  // Main.java, 22
            int obj1 = in.nextInt();  // Main.java, 23
            int obj2 = in.nextInt();  // Main.java, 24
            int obj3 = in.nextInt();  // Main.java, 25
            StationObjective sto = new StationObjective(objectiveScore, obj0, obj1, obj2, obj3);  // Main.java, 27
            Station st = new Station(stationId, mine);  // Main.java, 28
            st.myStationObj = sto;  // Main.java, 29
            if (st.isMine() == 1) {  // Main.java, 31
                myStations[myCounter] = st;  // Main.java, 32
                myCounter++;  // Main.java, 33
            } else {  // Main.java, 34
                oppStations[oppCounter] = st;  // Main.java, 35
                oppCounter++;  // Main.java, 36
            }  // Main.java, 37
        }  // Main.java, 39
        // game loop  // Main.java, 41
        while (true) {  // Main.java, 42
            int sectorIndex = in.nextInt();  // Main.java, 43
            for (int i = 0; i < 8; i++) {  // Main.java, 44
                int stationId = in.nextInt();  // Main.java, 45
                int mine = in.nextInt();  // Main.java, 46
                int available = in.nextInt();  // Main.java, 47
                int tech0 = in.nextInt();  // Main.java, 48
                int tech1 = in.nextInt();  // Main.java, 49
                int tech2 = in.nextInt();  // Main.java, 50
                int tech3 = in.nextInt();  // Main.java, 51
                Station currentSt = getStationById(myStations,oppStations, stationId);  // Main.java, 53
                currentSt.setTechLevel(tech0, tech1, tech2, tech3);  // Main.java, 54
                currentSt.setAvailable(available);  // Main.java, 55
            }  // Main.java, 56
            int planetCount = in.nextInt();  // Main.java, 57
            for (int i = 0; i < planetCount; i++) {  // Main.java, 58
                int planetId = in.nextInt();  // Main.java, 59
                int tasks0 = in.nextInt();  // Main.java, 60
                int tasks1 = in.nextInt();  // Main.java, 61
                int tasks2 = in.nextInt();  // Main.java, 62
                int tasks3 = in.nextInt();  // Main.java, 63
                int myContribution = in.nextInt(); // the amount of tasks you have already completed  // Main.java, 64
                int oppContribution = in.nextInt();  // Main.java, 65
                int colonizationScore = in.nextInt(); // points awarded to the colonizer having completed the most tasks  // Main.java, 66
                String bonus0 = in.next();  // Main.java, 67
                String bonus1 = in.next();  // Main.java, 68
                Planet p = new Planet(planetId, tasks0, tasks1, tasks2, tasks3, myContribution, oppContribution, colonizationScore, bonus0, bonus1);  // Main.java, 70
                planets[i] = p;  // Main.java, 71
            }  // Main.java, 73
            int bonusCount = in.nextInt(); // bonuses in both you and your opponent's inventories  // Main.java, 74
            for (int i = 0; i < bonusCount; i++) {  // Main.java, 75
                int mine = in.nextInt();  // Main.java, 76
                String bonus = in.next();  // Main.java, 77
            }  // Main.java, 78
            int myColonizationScore = in.nextInt(); // points from planet colonization, does not include bonus points  // Main.java, 79
            int oppColonizationScore = in.nextInt();  // Main.java, 80
            // Write an action using System.out.println()  // Main.java, 82
            // To debug: System.err.println("Debug messages...");  // Main.java, 83
            //printMyStations(myStations);  // Main.java, 85
            //printOppStations(oppStations);  // Main.java, 86
            //printPlanets(planets);  // Main.java, 87
            System.out.println(strategy.execute());  // Main.java, 89
        }  // Main.java, 90
    }  // Main.java, 91
    public Station getStationById(Station[] myStations, Station[] oppStations, int id)  // Main.java, 93
    {  // Main.java, 94
        for (int i=0;i<=3;i++)  // Main.java, 95
        {  // Main.java, 96
            if (id==myStations[i].stationId)  // Main.java, 97
                return myStations[i];  // Main.java, 98
        }  // Main.java, 99
        for (int i=0;i<=3;i++)  // Main.java, 100
        {  // Main.java, 101
            if (id==oppStations[i].stationId)  // Main.java, 102
                return oppStations[i];  // Main.java, 103
        }  // Main.java, 104
        return null;  // Main.java, 106
    }  // Main.java, 107
    public void printMyStations(Station[] myStations)  // Main.java, 109
    {  // Main.java, 110
        for (int i=0;i<4;i++)  // Main.java, 111
        {  // Main.java, 112
            System.err.println("my Station " + myStations[i].stationId + " available=" + myStations[i].isAvailable + " tech1" + myStations[i].terraformingSkill + " tech2" + myStations[i].alienSkill + " tech3" + myStations[i].engineeringSkill + " tech4" + myStations[i].agricultureSkill);  // Main.java, 113
            System.err.println("  obj score = " + myStations[i].myStationObj.scoreIfReached + " obj terra=" + myStations[i].myStationObj.terraLevelObj +   " obj alien=" + myStations[i].myStationObj.alienLevelObj);  // Main.java, 114
        }  // Main.java, 115
    }  // Main.java, 116
    public void printOppStations(Station[] oppStations)  // Main.java, 118
    {  // Main.java, 119
        for (int i=0;i<4;i++)  // Main.java, 120
        {  // Main.java, 121
            System.err.println("opp Station " + oppStations[i].stationId + " available=" + oppStations[i].isAvailable + " tech1" + oppStations[i].terraformingSkill + " tech2" + oppStations[i].alienSkill + " tech3" + oppStations[i].engineeringSkill + " tech4" + oppStations[i].agricultureSkill);  // Main.java, 122
        }  // Main.java, 123
    }  // Main.java, 124
    public void printPlanets(Planet[] planets)  // Main.java, 126
    {  // Main.java, 127
        for (int i=0;i<5;i++)  // Main.java, 128
        {  // Main.java, 129
            System.err.println("Planet "  + planets[i].planetId + " task1" + planets[i].terraformingTaskLeftValue + " task2" + planets[i].alienTaskLeftValue + " task3" + planets[i].engineeringTaskLeftValue + " task4" + planets[i].agricultureTaskLeftValue);  // Main.java, 130
            System.err.println("     myContribution=" + planets[i].myContributionTotalTaks + " oppContribution=" + planets[i].oppContributionTotalTasks + " score=" + planets[i].colonizationScore + " bonus0="+ planets[i].bonus0 + " bonus1=" + planets[i].bonus1);  // Main.java, 131
        }  // Main.java, 132
    }  // Main.java, 133
}  // Main.java, 134

public static void main(String[] args) { (new Player()).new Main(args); }
}