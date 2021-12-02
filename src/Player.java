/*
This file has been generated Thu Dec 02 17:08:39 CET 2021
*/

import java.util.Scanner;import java.util.ArrayList;
class Player {
class Distances {  // Distances.java, 3
    private Station station;  // Distances.java, 5
    private Planet planet;  // Distances.java, 6
    private Integer valueStationPlanet = null;  // Distances.java, 7
    private Integer disValueTerraforming = null;  // Distances.java, 10
    private Integer disValueAlien = null;  // Distances.java, 11
    private Integer disValueEngineering = null;  // Distances.java, 12
    private Integer disValueAgriculture = null;  // Distances.java, 13
    public Distances(Station station, Planet planet){  // Distances.java, 15
        this.station = station;  // Distances.java, 16
        this.planet = planet;   // Distances.java, 17
        this.compute();  // Distances.java, 18
    }  // Distances.java, 19
    public void compute(){  // Distances.java, 21
        Integer result = null;  // Distances.java, 22
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 23
        if(this.planet.getTerraformingTaskLeftValue() != 0 ) {  // Distances.java, 24
            disValueTerraforming = this.planet.getTerraformingTaskLeftValue() - this.station.getTerraformingSkill();  // Distances.java, 25
            if(disValueTerraforming < 0){  // Distances.java, 26
                disValueTerraforming = 0;  // Distances.java, 27
            }  // Distances.java, 28
            if(result == null){  // Distances.java, 29
                result = disValueTerraforming;  // Distances.java, 30
            }else{  // Distances.java, 31
                result += disValueTerraforming;  // Distances.java, 32
            }  // Distances.java, 33
        }  // Distances.java, 34
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 37
        if(this.planet.getAlienTaskLeftValue() != 0 ) {  // Distances.java, 38
            disValueAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();  // Distances.java, 39
            if(disValueAlien < 0){  // Distances.java, 40
                disValueAlien = 0;  // Distances.java, 41
            }  // Distances.java, 42
            if(result == null){  // Distances.java, 43
                result = disValueAlien;  // Distances.java, 44
            }else{  // Distances.java, 45
                result += disValueAlien;  // Distances.java, 46
            }  // Distances.java, 47
        }  // Distances.java, 48
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 52
        if(this.planet.getEngineeringTaskLeftValue() != 0 ) {  // Distances.java, 53
            disValueEngineering = this.planet.getEngineeringTaskLeftValue() - this.station.getEngineeringSkill();  // Distances.java, 54
            if(disValueEngineering < 0){  // Distances.java, 55
                disValueEngineering = 0;  // Distances.java, 56
            }  // Distances.java, 57
            if(result == null){  // Distances.java, 58
                result = disValueEngineering;  // Distances.java, 59
            }else{  // Distances.java, 60
                result += disValueEngineering;  // Distances.java, 61
            }  // Distances.java, 62
        }  // Distances.java, 63
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 66
        if(this.planet.getAgricultureTaskLeftValue() != 0 ) {  // Distances.java, 67
            disValueAgriculture= this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();  // Distances.java, 68
            if(disValueAgriculture < 0){  // Distances.java, 69
                disValueAgriculture = 0;  // Distances.java, 70
            }  // Distances.java, 71
            if(result == null){  // Distances.java, 72
                result = disValueAgriculture;  // Distances.java, 73
            }else{  // Distances.java, 74
                result += disValueAgriculture;  // Distances.java, 75
            }  // Distances.java, 76
        }  // Distances.java, 77
       this.valueStationPlanet = result;  // Distances.java, 79
    }  // Distances.java, 80
    public boolean isSmallerThan(Distances distances){  // Distances.java, 82
        return distances == null || (distances.valueStationPlanet != null && this.valueStationPlanet < distances.valueStationPlanet);  // Distances.java, 83
    }  // Distances.java, 84
    public Distances getSmallerDistance(Distances distances){  // Distances.java, 86
           if(this.isSmallerThan(distances)){  // Distances.java, 87
               return this;  // Distances.java, 88
           }else{  // Distances.java, 89
               return distances;  // Distances.java, 90
           }  // Distances.java, 91
    }  // Distances.java, 92
    public Distances getSmallerAvailableDistance(Distances distances){  // Distances.java, 94
        if(this.isSmallerThan(distances) && this.getStation().isAvailable()){  // Distances.java, 95
            return this;  // Distances.java, 96
        }else{  // Distances.java, 97
            return distances;  // Distances.java, 98
        }  // Distances.java, 99
    }  // Distances.java, 100
    public Station getStation() {  // Distances.java, 102
        return station;  // Distances.java, 103
    }  // Distances.java, 104
    public Planet getPlanet() {  // Distances.java, 106
        return planet;  // Distances.java, 107
    }  // Distances.java, 108
    public int getValueStationPlanet() {  // Distances.java, 110
        return valueStationPlanet;  // Distances.java, 111
    }  // Distances.java, 112
    public Integer getValueTerraformingStationPlanet(){  // Distances.java, 114
        return disValueTerraforming;  // Distances.java, 115
    }  // Distances.java, 116
    public Integer getValueAlienStationPlanet(){  // Distances.java, 118
        return disValueAlien;  // Distances.java, 119
    }  // Distances.java, 120
    public Integer getValueEngineeringStationPlanet(){  // Distances.java, 122
        return disValueEngineering;  // Distances.java, 123
    }  // Distances.java, 124
    public Integer getValueAgricultureStationPlanet(){  // Distances.java, 126
        return disValueAgriculture;  // Distances.java, 127
    }  // Distances.java, 128
}  // Distances.java, 129

enum BonusType  // BonusType.java, 3
    {  // BonusType.java, 4
        ENERGY_CORE("ENERGY_CORE"),  // BonusType.java, 5
        TECH_RESEARCH_2("TECH_RESEARCH_2"),  // BonusType.java, 6
        TECH_RESEARCH_3("TECH_RESEARCH_3"),  // BonusType.java, 7
        TECH_RESEARCH_4("TECH_RESEARCH_4"),  // BonusType.java, 8
        NEW_TECH("NEW_TECH"),  // BonusType.java, 9
        POINTS_1("POINTS_1"),  // BonusType.java, 10
        POINTS_2("POINTS_2"),  // BonusType.java, 11
        POINTS_3("POINTS_3"),  // BonusType.java, 12
        ALIEN_ARTIFACT("ALIEN_ARTIFACT");  // BonusType.java, 13
        private String bonusValue;  // BonusType.java, 15
        BonusType(String bonusValue) {  // BonusType.java, 17
            this.bonusValue = bonusValue;  // BonusType.java, 18
        }  // BonusType.java, 19
        public String getBonusValue() {  // BonusType.java, 21
            return bonusValue;  // BonusType.java, 22
        }  // BonusType.java, 23
    }  // BonusType.java, 24

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
}  // Station.java, 84

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
    private ArrayList<Planet>  planets = new ArrayList<Planet> ();  // Strategy.java, 11
    private ArrayList<Bonus> myBonus = new ArrayList<Bonus>();  // Strategy.java, 12
    private ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();  // Strategy.java, 13
    public Strategy(Station[] myStations , Station[] oppStations, ArrayList<Planet>  planets, ArrayList<Bonus> myBonus, ArrayList<Bonus> oppBonus){  // Strategy.java, 15
        this.myStations = myStations;  // Strategy.java, 16
        this.oppStations = oppStations;  // Strategy.java, 17
        this.planets = planets;  // Strategy.java, 18
        this.myBonus = myBonus;  // Strategy.java, 19
        this.oppBonus = oppBonus;  // Strategy.java, 20
    }  // Strategy.java, 21
    public String execute(){  // Strategy.java, 23
        String preCommand = applyTechPreCommand();  // Strategy.java, 24
        // main actions: COLONIZE | RESUPPLY  // Strategy.java, 25
        // bonus actions: ENERGY_CORE | ALIEN_ARTIFACT | TECH_RESEARCH | NEW_TECH  // Strategy.java, 26
        // Append text after any command and that text will appear on screen.  // Strategy.java, 27
        Distances distance;  // Strategy.java, 28
        Distances disMin = null;  // Strategy.java, 29
        Distances disMinAvailable = null;  // Strategy.java, 30
        for(int i=0; i<myStations.length; i++){  // Strategy.java, 31
            for (Planet planet: planets){  // Strategy.java, 32
                distance = new Distances(myStations[i], planet);  // Strategy.java, 33
                disMin = distance.getSmallerDistance(disMin);  // Strategy.java, 34
                disMinAvailable = distance.getSmallerAvailableDistance(disMinAvailable);  // Strategy.java, 35
                //System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());  // Strategy.java, 36
            }  // Strategy.java, 37
        }  // Strategy.java, 38
        Distances distanceToPlay = disMin;  // Strategy.java, 39
        if(distanceToPlay.getStation().isAvailable()) {  // Strategy.java, 40
                return preCommand+applyColonizeWithAllienAttempt(myBonus,distanceToPlay);  // Strategy.java, 41
        }else{  // Strategy.java, 42
            //do we have an avaialble station with the same distance ? if yes, let's colonize with it ....  // Strategy.java, 43
            if(disMinAvailable != null && disMinAvailable.getValueStationPlanet() <= disMin.getValueStationPlanet()){  // Strategy.java, 44
                return preCommand+applyColonizeWithAllienAttempt(myBonus,disMinAvailable) ;  // Strategy.java, 45
            }  // Strategy.java, 46
            //... else let's try to apply a bonus to the non available better one  // Strategy.java, 47
            //do dwe have a ENERGY BONUS to allow resupply and colonize in one shot  // Strategy.java, 48
            return preCommand+applyEnergyAndColonize_Or_Resupply(myBonus, applyColonizeWithAllienAttempt(myBonus,distanceToPlay));  // Strategy.java, 49
        }  // Strategy.java, 51
    }  // Strategy.java, 52
    public String applyTechPreCommand(){  // Strategy.java, 54
        String resultCommand = "";  // Strategy.java, 55
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station  // Strategy.java, 56
        for(Bonus bonus: myBonus){  // Strategy.java, 57
            System.err.println("Bonus -> "+ bonus.getBonus());  // Strategy.java, 58
            int techREsearchBonusNum = -1;  // Strategy.java, 59
            String commandName = "";  // Strategy.java, 60
            if(BonusType.NEW_TECH.equals(bonus.getBonus())) {  // Strategy.java, 61
                techREsearchBonusNum = 0;  // Strategy.java, 62
                System.err.println("Found Bonus NEW TECH");  // Strategy.java, 63
                commandName = "NEW_TECH ";  // Strategy.java, 64
            }else if(BonusType.TECH_RESEARCH_2.equals(bonus.getBonus())) {  // Strategy.java, 65
                techREsearchBonusNum = 1;  // Strategy.java, 66
                System.err.println("Found Bonus TechREsearch 2");  // Strategy.java, 67
                commandName = "TECH_RESEARCH ";  // Strategy.java, 68
            }else if(BonusType.TECH_RESEARCH_3.equals(bonus.getBonus())) {  // Strategy.java, 69
                System.err.println("Found Bonus TechREsearch 3");  // Strategy.java, 70
                techREsearchBonusNum = 2;  // Strategy.java, 71
                commandName = "TECH_RESEARCH ";  // Strategy.java, 72
            }if(BonusType.TECH_RESEARCH_4.equals(bonus.getBonus())) {  // Strategy.java, 73
                System.err.println("Found Bonus TechREsearch 4");  // Strategy.java, 74
                techREsearchBonusNum = 3;  // Strategy.java, 75
                commandName = "TECH_RESEARCH ";  // Strategy.java, 76
            }  // Strategy.java, 77
            if (techREsearchBonusNum >= 0) {  // Strategy.java, 78
                for (int i = 0; i < myStations.length; i++) {  // Strategy.java, 79
                    Station station = myStations[i];  // Strategy.java, 80
                    if (station.getTerraformingSkill() == techREsearchBonusNum) {  // Strategy.java, 82
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);  // Strategy.java, 83
                        station.terraformingSkill += 1;  // Strategy.java, 84
                        break;  // Strategy.java, 85
                    } else if (station.getAlienSkill() == techREsearchBonusNum) {  // Strategy.java, 86
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);  // Strategy.java, 87
                        station.alienSkill += 1;  // Strategy.java, 88
                        break;  // Strategy.java, 89
                    } else if (station.getEngineeringSkill() == techREsearchBonusNum) {  // Strategy.java, 90
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);  // Strategy.java, 91
                        station.engineeringSkill += 1;  // Strategy.java, 92
                        break;  // Strategy.java, 93
                    } else if (station.getAgricultureSkill() == techREsearchBonusNum) {  // Strategy.java, 94
                        resultCommand = commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);  // Strategy.java, 95
                        station.agricultureSkill += 1;  // Strategy.java, 96
                        break;  // Strategy.java, 97
                    }  // Strategy.java, 98
                }  // Strategy.java, 99
            }  // Strategy.java, 100
        }  // Strategy.java, 101
        if (!"".equals(resultCommand)){  // Strategy.java, 102
            resultCommand += " ";  // Strategy.java, 103
        }  // Strategy.java, 104
        System.err.println("PreCommand-> ["+resultCommand+"]");  // Strategy.java, 105
        return resultCommand;  // Strategy.java, 106
    }  // Strategy.java, 107
    public  boolean isBonusAvailable(ArrayList<Bonus> myBonus, BonusType bonusType ){  // Strategy.java, 109
        if(myBonus == null){  // Strategy.java, 110
            return false;  // Strategy.java, 111
        }  // Strategy.java, 112
        for(Bonus bonus: myBonus){  // Strategy.java, 113
            if(bonusType.equals(bonus.getBonus())){  // Strategy.java, 114
                return true;  // Strategy.java, 115
            }  // Strategy.java, 116
        }  // Strategy.java, 117
        return false;  // Strategy.java, 118
    }  // Strategy.java, 119
    public String applyEnergyAndColonize_Or_Resupply (ArrayList<Bonus> myBonus, String colonizeAction)  // Strategy.java, 121
    {  // Strategy.java, 122
        if(isBonusAvailable(myBonus, BonusType.ENERGY_CORE)){  // Strategy.java, 123
            return BonusType.ENERGY_CORE+" "+ colonizeAction;  // Strategy.java, 124
        }  // Strategy.java, 125
        else{  // Strategy.java, 126
            //no choice  // Strategy.java, 127
            return "RESUPPLY";  // Strategy.java, 128
        }  // Strategy.java, 129
    }  // Strategy.java, 130
    public String applyColonizeWithAllienAttempt(ArrayList<Bonus> myBonus, Distances distanceToPlay)  // Strategy.java, 132
    {  // Strategy.java, 133
        String prefixAllien = "";  // Strategy.java, 134
        if (distanceToPlay.getValueStationPlanet()>=2 && isBonusAvailable(myBonus, BonusType.ALIEN_ARTIFACT))  // Strategy.java, 135
        {  // Strategy.java, 136
            prefixAllien+= "ALLIEN_ARTIFACT 0 1 ";  // Strategy.java, 137
        }  // Strategy.java, 138
        String colonizeAction="COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus();  // Strategy.java, 140
        return prefixAllien + colonizeAction;  // Strategy.java, 141
    }  // Strategy.java, 142
}  // Strategy.java, 143

enum TechEnum {  // TechEnum.java, 3
    TERRAFORMING,  // TechEnum.java, 4
    ALIEN,  // TechEnum.java, 5
    ENGINEERING,  // TechEnum.java, 6
    AGRICULTURE;  // TechEnum.java, 7
    public static int getCode(TechEnum techEnum){  // TechEnum.java, 10
        if(TERRAFORMING.equals(techEnum)){  // TechEnum.java, 11
            return 0;  // TechEnum.java, 12
        }else if(ALIEN.equals(techEnum)){  // TechEnum.java, 13
            return 1;  // TechEnum.java, 14
        }else if (ENGINEERING.equals(techEnum)){  // TechEnum.java, 15
            return 2;  // TechEnum.java, 16
        }else{  // TechEnum.java, 17
            return 3;  // TechEnum.java, 18
        }  // TechEnum.java, 19
    }  // TechEnum.java, 20
}  // TechEnum.java, 21

class Main {  // Main.java, 6
    Station[] myStations = new Station[4];  // Main.java, 8
    Station[] oppStations = new Station[4];  // Main.java, 9
    ArrayList<Planet> planets = new ArrayList<Planet>();  // Main.java, 10
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
            // re-init planet  // Main.java, 61
            planets.clear();  // Main.java, 62
            int planetCount = in.nextInt();  // Main.java, 64
            for (int i = 0; i < planetCount; i++) {  // Main.java, 65
                int planetId = in.nextInt();  // Main.java, 66
                int tasks0 = in.nextInt();  // Main.java, 67
                int tasks1 = in.nextInt();  // Main.java, 68
                int tasks2 = in.nextInt();  // Main.java, 69
                int tasks3 = in.nextInt();  // Main.java, 70
                int myContribution = in.nextInt(); // the amount of tasks you have already completed  // Main.java, 71
                int oppContribution = in.nextInt();  // Main.java, 72
                int colonizationScore = in.nextInt(); // points awarded to the colonizer having completed the most tasks  // Main.java, 73
                String bonus0 = in.next();  // Main.java, 74
                String bonus1 = in.next();  // Main.java, 75
                Planet p = new Planet(planetId, tasks0, tasks1, tasks2, tasks3, myContribution, oppContribution, colonizationScore, bonus0, bonus1);  // Main.java, 77
                planets.add(p);  // Main.java, 78
            }  // Main.java, 80
            // Reinit  // Main.java, 82
            oppBonus.clear();  // Main.java, 83
            myBonus.clear();  // Main.java, 84
            int bonusCount = in.nextInt(); // bonuses in both you and your opponent's inventories  // Main.java, 85
            for (int i = 0; i < bonusCount; i++) {  // Main.java, 86
                int mine = in.nextInt();  // Main.java, 87
                String bonus = in.next();  // Main.java, 88
                Bonus bon = new Bonus(bonus);  // Main.java, 89
                System.err.println("mine=" + mine+ ", Bonus="+bonus);  // Main.java, 90
                if(mine == 1){  // Main.java, 91
                    myBonus.add(bon);  // Main.java, 92
                }else{  // Main.java, 93
                    oppBonus.add(bon);  // Main.java, 94
                }  // Main.java, 95
            }  // Main.java, 96
            int myColonizationScore = in.nextInt(); // points from planet colonization, does not include bonus points  // Main.java, 97
            int oppColonizationScore = in.nextInt();  // Main.java, 98
            // Write an action using System.out.println()  // Main.java, 100
            // To debug: System.err.println("Debug messages...");  // Main.java, 101
            //printMyStations(myStations);  // Main.java, 103
            //printOppStations(oppStations);  // Main.java, 104
            //printPlanets(planets);  // Main.java, 105
            String execute =  strategy.execute();  // Main.java, 106
            System.err.println("Command = "+ execute);  // Main.java, 107
            System.out.println(execute);  // Main.java, 108
        }  // Main.java, 109
    }  // Main.java, 110
    public Station getStationById(Station[] myStations, Station[] oppStations, int id)  // Main.java, 112
    {  // Main.java, 113
        for (int i=0;i<=3;i++)  // Main.java, 114
        {  // Main.java, 115
            if (id==myStations[i].stationId)  // Main.java, 116
                return myStations[i];  // Main.java, 117
        }  // Main.java, 118
        for (int i=0;i<=3;i++)  // Main.java, 119
        {  // Main.java, 120
            if (id==oppStations[i].stationId)  // Main.java, 121
                return oppStations[i];  // Main.java, 122
        }  // Main.java, 123
        return null;  // Main.java, 125
    }  // Main.java, 126
    public void printMyStations(Station[] myStations)  // Main.java, 128
    {  // Main.java, 129
        for (int i=0;i<4;i++)  // Main.java, 130
        {  // Main.java, 131
            System.err.println("my Station " + myStations[i].stationId + " available=" + myStations[i].isAvailable + " tech1" + myStations[i].terraformingSkill + " tech2" + myStations[i].alienSkill + " tech3" + myStations[i].engineeringSkill + " tech4" + myStations[i].agricultureSkill);  // Main.java, 132
            System.err.println("  obj score = " + myStations[i].myStationObj.scoreIfReached + " obj terra=" + myStations[i].myStationObj.terraLevelObj +   " obj alien=" + myStations[i].myStationObj.alienLevelObj);  // Main.java, 133
        }  // Main.java, 134
    }  // Main.java, 135
    public void printOppStations(Station[] oppStations)  // Main.java, 137
    {  // Main.java, 138
        for (int i=0;i<4;i++)  // Main.java, 139
        {  // Main.java, 140
            System.err.println("opp Station " + oppStations[i].stationId + " available=" + oppStations[i].isAvailable + " tech1" + oppStations[i].terraformingSkill + " tech2" + oppStations[i].alienSkill + " tech3" + oppStations[i].engineeringSkill + " tech4" + oppStations[i].agricultureSkill);  // Main.java, 141
        }  // Main.java, 142
    }  // Main.java, 143
    public void printPlanets(Planet[] planets)  // Main.java, 145
    {  // Main.java, 146
        for (int i=0;i<5;i++)  // Main.java, 147
        {  // Main.java, 148
            System.err.println("Planet "  + planets[i].planetId + " task1" + planets[i].terraformingTaskLeftValue + " task2" + planets[i].alienTaskLeftValue + " task3" + planets[i].engineeringTaskLeftValue + " task4" + planets[i].agricultureTaskLeftValue);  // Main.java, 149
            System.err.println("     myContribution=" + planets[i].myContributionTotalTaks + " oppContribution=" + planets[i].oppContributionTotalTasks + " score=" + planets[i].colonizationScore + " bonus0="+ planets[i].bonus0 + " bonus1=" + planets[i].bonus1);  // Main.java, 150
        }  // Main.java, 151
    }  // Main.java, 152
}  // Main.java, 153

public static void main(String[] args) { (new Player()).new Main(args); }
}