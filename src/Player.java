/*
This file has been generated Thu Dec 02 15:45:47 CET 2021
*/

import java.util.Scanner;import java.util.ArrayList;
class Player {
class Distances {  // Distances.java, 3
    private Station station;  // Distances.java, 5
    private Planet planet;  // Distances.java, 6
    private Integer valueStationPlanet = null;  // Distances.java, 7
    public Distances(Station station, Planet planet){  // Distances.java, 9
        this.station = station;  // Distances.java, 10
        this.planet = planet;   // Distances.java, 11
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
        if(this.planet.getEngineeringTaskLeftValue() != 0 ) {  // Distances.java, 53
            int disEng = this.planet.getEngineeringTaskLeftValue() - this.station.getEngineeringSkill();  // Distances.java, 54
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
    public Distances getSmallerAvailableDistance(Distances distances){  // Distances.java, 100
        if(this.isSmallerThan(distances) && this.getStation().isAvailable()){  // Distances.java, 101
            return this;  // Distances.java, 102
        }else{  // Distances.java, 103
            return distances;  // Distances.java, 104
        }  // Distances.java, 105
    }  // Distances.java, 106
    public Station getStation() {  // Distances.java, 108
        return station;  // Distances.java, 109
    }  // Distances.java, 110
    public Planet getPlanet() {  // Distances.java, 112
        return planet;  // Distances.java, 113
    }  // Distances.java, 114
    public int getValueStationPlanet() {  // Distances.java, 116
        return valueStationPlanet;  // Distances.java, 117
    }  // Distances.java, 118
}  // Distances.java, 119

enum BonusType  // BonusType.java, 3
    {  // BonusType.java, 4
        ENERGY_CORE("ENERGY_CORE"),  // BonusType.java, 5
        TECH_RESEARCH_2("TECH_RESEARCH_2"),  // BonusType.java, 6
        TECH_RESEARCH_3("TECH_RESEARCH_3"),  // BonusType.java, 7
        TECH_RESEARCH_4("TECH_RESEARCH_4"),  // BonusType.java, 8
        POINTS_1("POINTS_1"),  // BonusType.java, 9
        POINTS_2("POINTS_2"),  // BonusType.java, 10
        POINTS_3("POINTS_3"),  // BonusType.java, 11
        ALIEN_ARTIFACT("ALIEN_ARTIFACT");  // BonusType.java, 12
        private String bonusValue;  // BonusType.java, 14
        BonusType(String bonusValue) {  // BonusType.java, 16
            this.bonusValue = bonusValue;  // BonusType.java, 17
        }  // BonusType.java, 18
        public String getBonusValue() {  // BonusType.java, 20
            return bonusValue;  // BonusType.java, 21
        }  // BonusType.java, 22
    }  // BonusType.java, 23

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

class Bonus {  // Bonus.java, 5
    private BonusType bonus;  // Bonus.java, 7
    public Bonus(String bonus){  // Bonus.java, 9
        this.bonus = BonusType.valueOf(bonus);  // Bonus.java, 10
    }  // Bonus.java, 11
    public BonusType getBonus() {  // Bonus.java, 13
        return bonus;  // Bonus.java, 14
    }  // Bonus.java, 15
    /*public static void main(String[] args) {  // Bonus.java, 17
        Bonus bonus = new Bonus("ENERGY_CORE");  // Bonus.java, 18
    }*/  // Bonus.java, 20
}  // Bonus.java, 21

class Strategy {  // Strategy.java, 5
    private Station[] myStations = new Station[4];  // Strategy.java, 8
    private Station[] oppStations = new Station[4];  // Strategy.java, 10
    private Planet[] planets = new Planet[5];  // Strategy.java, 11
    private ArrayList<Bonus> myBonus = new ArrayList<Bonus>();  // Strategy.java, 12
    private ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();  // Strategy.java, 13
    public Strategy(Station[] myStations , Station[] oppStations, Planet[] planets, ArrayList<Bonus> myBonus, ArrayList<Bonus> oppBonus){  // Strategy.java, 15
        this.myStations = myStations;  // Strategy.java, 16
        this.oppStations = oppStations;  // Strategy.java, 17
        this.planets = planets;  // Strategy.java, 18
        this.myBonus = myBonus;  // Strategy.java, 19
        this.oppBonus = oppBonus;  // Strategy.java, 20
    }  // Strategy.java, 21
    public String execute(){  // Strategy.java, 23
        // main actions: COLONIZE | RESUPPLY  // Strategy.java, 24
        // bonus actions: ENERGY_CORE | ALIEN_ARTIFACT | TECH_RESEARCH | NEW_TECH  // Strategy.java, 25
        // Append text after any command and that text will appear on screen.  // Strategy.java, 26
        Distances distance;  // Strategy.java, 27
        Distances disMin = null;  // Strategy.java, 28
        Distances disMinAvailable = null;  // Strategy.java, 29
        for(int i=0; i<myStations.length; i++){  // Strategy.java, 30
            for (int p = 0; p < planets.length; p++){  // Strategy.java, 31
                distance = new Distances(myStations[i], planets[p]);  // Strategy.java, 32
                disMin = distance.getSmallerDistance(disMin);  // Strategy.java, 33
                disMinAvailable = distance.getSmallerAvailableDistance(disMinAvailable);  // Strategy.java, 34
            }  // Strategy.java, 35
        }  // Strategy.java, 36
        //System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());  // Strategy.java, 37
        Distances distanceToPlay = disMin;  // Strategy.java, 38
        String colonizeAction="COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus();  // Strategy.java, 40
        if(distanceToPlay.getStation().isAvailable()) {  // Strategy.java, 41
                return colonizeAction;  // Strategy.java, 42
        }else{  // Strategy.java, 43
            //do dwe have a ENERGY BONUS to allow resupply and colonize in one shot  // Strategy.java, 44
            if(disMinAvailable != null && disMinAvailable.getValueStationPlanet() <= disMin.getValueStationPlanet()){  // Strategy.java, 45
                return "COLONIZE " + disMinAvailable.getStation().getStationId() + " " + disMinAvailable.getPlanet().getPlanetId() + " " + disMinAvailable.getPlanet().getBestBonus();  // Strategy.java, 46
            }  // Strategy.java, 47
            if(isBonusAvailable(myBonus, BonusType.ENERGY_CORE)){  // Strategy.java, 48
                return BonusType.ENERGY_CORE+" "+colonizeAction;  // Strategy.java, 49
            }  // Strategy.java, 50
            else{  // Strategy.java, 51
                //no choice  // Strategy.java, 52
                return "RESUPPLY";  // Strategy.java, 53
            }  // Strategy.java, 54
        }  // Strategy.java, 56
    }  // Strategy.java, 57
    public  boolean isBonusAvailable(ArrayList<Bonus> myBonus, BonusType bonusType ){  // Strategy.java, 59
        if(myBonus == null){  // Strategy.java, 60
            return false;  // Strategy.java, 61
        }  // Strategy.java, 62
        for(Bonus bonus: myBonus){  // Strategy.java, 63
            if(bonusType.equals(bonus.getBonus())){  // Strategy.java, 64
                return true;  // Strategy.java, 65
            }  // Strategy.java, 66
        }  // Strategy.java, 67
        return false;  // Strategy.java, 68
    }  // Strategy.java, 69
}  // Strategy.java, 70

class Main {  // Main.java, 6
    Station[] myStations = new Station[4];  // Main.java, 8
    Station[] oppStations = new Station[4];  // Main.java, 9
    Planet[] planets = new Planet[5];  // Main.java, 10
    ArrayList<Bonus> myBonus = new ArrayList<Bonus>();  // Main.java, 11
    ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();  // Main.java, 12
    Strategy strategy = new Strategy(myStations,oppStations,planets, myBonus, oppBonus);  // Main.java, 14
    public Main(String[] args) {  // Main.java, 16
        Scanner in = new Scanner(System.in);  // Main.java, 17
        int myCounter = 0;  // Main.java, 19
        int oppCounter = 0;  // Main.java, 20
        for (int i = 0; i < 8; i++) {  // Main.java, 21
            int stationId = in.nextInt();  // Main.java, 22
            int mine = in.nextInt();  // Main.java, 23
            int objectiveScore = in.nextInt(); // receive these points if tech level objectives are met  // Main.java, 24
            int obj0 = in.nextInt();  // Main.java, 25
            int obj1 = in.nextInt();  // Main.java, 26
            int obj2 = in.nextInt();  // Main.java, 27
            int obj3 = in.nextInt();  // Main.java, 28
            StationObjective sto = new StationObjective(objectiveScore, obj0, obj1, obj2, obj3);  // Main.java, 30
            Station st = new Station(stationId, mine);  // Main.java, 31
            st.myStationObj = sto;  // Main.java, 32
            if (st.isMine() == 1) {  // Main.java, 34
                myStations[myCounter] = st;  // Main.java, 35
                myCounter++;  // Main.java, 36
            } else {  // Main.java, 37
                oppStations[oppCounter] = st;  // Main.java, 38
                oppCounter++;  // Main.java, 39
            }  // Main.java, 40
        }  // Main.java, 42
        // game loop  // Main.java, 44
        while (true) {  // Main.java, 45
            int sectorIndex = in.nextInt();  // Main.java, 46
            for (int i = 0; i < 8; i++) {  // Main.java, 47
                int stationId = in.nextInt();  // Main.java, 48
                int mine = in.nextInt();  // Main.java, 49
                int available = in.nextInt();  // Main.java, 50
                int tech0 = in.nextInt();  // Main.java, 51
                int tech1 = in.nextInt();  // Main.java, 52
                int tech2 = in.nextInt();  // Main.java, 53
                int tech3 = in.nextInt();  // Main.java, 54
                Station currentSt = getStationById(myStations,oppStations, stationId);  // Main.java, 56
                currentSt.setTechLevel(tech0, tech1, tech2, tech3);  // Main.java, 57
                currentSt.setAvailable(available);  // Main.java, 58
            }  // Main.java, 59
            int planetCount = in.nextInt();  // Main.java, 60
            for (int i = 0; i < planetCount; i++) {  // Main.java, 61
                int planetId = in.nextInt();  // Main.java, 62
                int tasks0 = in.nextInt();  // Main.java, 63
                int tasks1 = in.nextInt();  // Main.java, 64
                int tasks2 = in.nextInt();  // Main.java, 65
                int tasks3 = in.nextInt();  // Main.java, 66
                int myContribution = in.nextInt(); // the amount of tasks you have already completed  // Main.java, 67
                int oppContribution = in.nextInt();  // Main.java, 68
                int colonizationScore = in.nextInt(); // points awarded to the colonizer having completed the most tasks  // Main.java, 69
                String bonus0 = in.next();  // Main.java, 70
                String bonus1 = in.next();  // Main.java, 71
                Planet p = new Planet(planetId, tasks0, tasks1, tasks2, tasks3, myContribution, oppContribution, colonizationScore, bonus0, bonus1);  // Main.java, 73
                planets[i] = p;  // Main.java, 74
            }  // Main.java, 76
            // Reinit  // Main.java, 78
            oppBonus.clear();  // Main.java, 79
            myBonus.clear();  // Main.java, 80
            int bonusCount = in.nextInt(); // bonuses in both you and your opponent's inventories  // Main.java, 81
            for (int i = 0; i < bonusCount; i++) {  // Main.java, 82
                int mine = in.nextInt();  // Main.java, 83
                String bonus = in.next();  // Main.java, 84
                Bonus bon = new Bonus(bonus);  // Main.java, 85
                System.err.println("mine=" + mine+ ", Bonus="+bonus);  // Main.java, 86
                if(mine == 1){  // Main.java, 87
                    myBonus.add(bon);  // Main.java, 88
                }else{  // Main.java, 89
                    oppBonus.add(bon);  // Main.java, 90
                }  // Main.java, 91
            }  // Main.java, 92
            int myColonizationScore = in.nextInt(); // points from planet colonization, does not include bonus points  // Main.java, 93
            int oppColonizationScore = in.nextInt();  // Main.java, 94
            // Write an action using System.out.println()  // Main.java, 96
            // To debug: System.err.println("Debug messages...");  // Main.java, 97
            //printMyStations(myStations);  // Main.java, 99
            //printOppStations(oppStations);  // Main.java, 100
            //printPlanets(planets);  // Main.java, 101
            String execute =  strategy.execute();  // Main.java, 102
            System.err.println("Command = "+ execute);  // Main.java, 103
            System.out.println(execute);  // Main.java, 104
        }  // Main.java, 105
    }  // Main.java, 106
    public Station getStationById(Station[] myStations, Station[] oppStations, int id)  // Main.java, 108
    {  // Main.java, 109
        for (int i=0;i<=3;i++)  // Main.java, 110
        {  // Main.java, 111
            if (id==myStations[i].stationId)  // Main.java, 112
                return myStations[i];  // Main.java, 113
        }  // Main.java, 114
        for (int i=0;i<=3;i++)  // Main.java, 115
        {  // Main.java, 116
            if (id==oppStations[i].stationId)  // Main.java, 117
                return oppStations[i];  // Main.java, 118
        }  // Main.java, 119
        return null;  // Main.java, 121
    }  // Main.java, 122
    public void printMyStations(Station[] myStations)  // Main.java, 124
    {  // Main.java, 125
        for (int i=0;i<4;i++)  // Main.java, 126
        {  // Main.java, 127
            System.err.println("my Station " + myStations[i].stationId + " available=" + myStations[i].isAvailable + " tech1" + myStations[i].terraformingSkill + " tech2" + myStations[i].alienSkill + " tech3" + myStations[i].engineeringSkill + " tech4" + myStations[i].agricultureSkill);  // Main.java, 128
            System.err.println("  obj score = " + myStations[i].myStationObj.scoreIfReached + " obj terra=" + myStations[i].myStationObj.terraLevelObj +   " obj alien=" + myStations[i].myStationObj.alienLevelObj);  // Main.java, 129
        }  // Main.java, 130
    }  // Main.java, 131
    public void printOppStations(Station[] oppStations)  // Main.java, 133
    {  // Main.java, 134
        for (int i=0;i<4;i++)  // Main.java, 135
        {  // Main.java, 136
            System.err.println("opp Station " + oppStations[i].stationId + " available=" + oppStations[i].isAvailable + " tech1" + oppStations[i].terraformingSkill + " tech2" + oppStations[i].alienSkill + " tech3" + oppStations[i].engineeringSkill + " tech4" + oppStations[i].agricultureSkill);  // Main.java, 137
        }  // Main.java, 138
    }  // Main.java, 139
    public void printPlanets(Planet[] planets)  // Main.java, 141
    {  // Main.java, 142
        for (int i=0;i<5;i++)  // Main.java, 143
        {  // Main.java, 144
            System.err.println("Planet "  + planets[i].planetId + " task1" + planets[i].terraformingTaskLeftValue + " task2" + planets[i].alienTaskLeftValue + " task3" + planets[i].engineeringTaskLeftValue + " task4" + planets[i].agricultureTaskLeftValue);  // Main.java, 145
            System.err.println("     myContribution=" + planets[i].myContributionTotalTaks + " oppContribution=" + planets[i].oppContributionTotalTasks + " score=" + planets[i].colonizationScore + " bonus0="+ planets[i].bonus0 + " bonus1=" + planets[i].bonus1);  // Main.java, 146
        }  // Main.java, 147
    }  // Main.java, 148
}  // Main.java, 149

public static void main(String[] args) { (new Player()).new Main(args); }
}