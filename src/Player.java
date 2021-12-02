/*
This file has been generated Thu Dec 02 21:26:32 CET 2021
*/

import java.util.Scanner;import java.util.ArrayList;
class Player {
class Distances {  // Distances.java, 5
    private Station station;  // Distances.java, 7
    private Planet planet;  // Distances.java, 8
    private Integer disValueStationPlanet = null;  // Distances.java, 10
    private Integer disValueTerraforming = null;  // Distances.java, 11
    private Integer disValueAlien = null;  // Distances.java, 12
    private Integer disValueEngineering = null;  // Distances.java, 13
    private Integer disValueAgriculture = null;  // Distances.java, 14
    private Integer usableToken = null;  // Distances.java, 16
    private Integer usableTokenTerraforming = null;  // Distances.java, 17
    private Integer usableTokenAlien = null;  // Distances.java, 18
    private Integer usableTokenEngineering = null;  // Distances.java, 19
    private Integer usableTokenAgriculture = null;  // Distances.java, 20
    public Distances(Station station, Planet planet){  // Distances.java, 22
        this.station = station;  // Distances.java, 23
        this.planet = planet;   // Distances.java, 24
        this.compute();  // Distances.java, 25
    }  // Distances.java, 26
    public void compute(){  // Distances.java, 28
        Integer result = null;  // Distances.java, 29
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 30
        if(this.planet.getTerraformingTaskLeftValue() != 0 ) {  // Distances.java, 31
            disValueTerraforming = this.planet.getTerraformingTaskLeftValue() - this.station.getTerraformingSkill();  // Distances.java, 32
            usableTokenTerraforming = Math.min(this.planet.getTerraformingTaskLeftValue(), this.station.getTerraformingSkill());  // Distances.java, 33
            if(disValueTerraforming < 0){  // Distances.java, 34
                disValueTerraforming = 0;  // Distances.java, 35
            }  // Distances.java, 36
            if(result == null){  // Distances.java, 37
                result = disValueTerraforming;  // Distances.java, 38
                usableToken = usableTokenTerraforming;  // Distances.java, 39
            }else{  // Distances.java, 40
                result += disValueTerraforming;  // Distances.java, 41
                usableToken += usableTokenTerraforming;  // Distances.java, 42
            }  // Distances.java, 43
        }  // Distances.java, 44
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 47
        if(this.planet.getAlienTaskLeftValue() != 0 ) {  // Distances.java, 48
            disValueAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();  // Distances.java, 49
            usableTokenAlien = Math.min(this.planet.getAlienTaskLeftValue(), this.station.getAlienSkill());  // Distances.java, 50
            if(disValueAlien < 0){  // Distances.java, 51
                disValueAlien = 0;  // Distances.java, 52
            }  // Distances.java, 53
            if(result == null){  // Distances.java, 54
                result = disValueAlien;  // Distances.java, 55
                usableToken = usableTokenAlien;  // Distances.java, 56
            }else{  // Distances.java, 57
                result += disValueAlien;  // Distances.java, 58
                usableToken += usableTokenAlien;  // Distances.java, 59
            }  // Distances.java, 60
        }  // Distances.java, 61
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 65
        if(this.planet.getEngineeringTaskLeftValue() != 0 ) {  // Distances.java, 66
            disValueEngineering = this.planet.getEngineeringTaskLeftValue() - this.station.getEngineeringSkill();  // Distances.java, 67
            usableTokenEngineering = Math.min(this.planet.getEngineeringTaskLeftValue(), this.station.getEngineeringSkill());  // Distances.java, 68
            if(disValueEngineering < 0){  // Distances.java, 69
                disValueEngineering = 0;  // Distances.java, 70
            }  // Distances.java, 71
            if(result == null){  // Distances.java, 72
                result = disValueEngineering;  // Distances.java, 73
                usableToken = usableTokenEngineering;  // Distances.java, 74
            }else{  // Distances.java, 75
                result += usableTokenEngineering;  // Distances.java, 76
            }  // Distances.java, 77
        }  // Distances.java, 78
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 81
        if(this.planet.getAgricultureTaskLeftValue() != 0 ) {  // Distances.java, 82
            disValueAgriculture= this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();  // Distances.java, 83
            usableTokenAgriculture = Math.min(this.planet.getAgricultureTaskLeftValue(), this.station.getAgricultureSkill());  // Distances.java, 84
            if(disValueAgriculture < 0){  // Distances.java, 85
                disValueAgriculture = 0;  // Distances.java, 86
            }  // Distances.java, 87
            if(result == null){  // Distances.java, 88
                result = disValueAgriculture;  // Distances.java, 89
                usableToken = usableTokenAgriculture;  // Distances.java, 90
            }else{  // Distances.java, 91
                result += disValueAgriculture;  // Distances.java, 92
                usableToken += usableTokenAgriculture;  // Distances.java, 93
            }  // Distances.java, 94
        }  // Distances.java, 95
       this.disValueStationPlanet = result;  // Distances.java, 97
    }  // Distances.java, 98
    public boolean isSmallerDistanceThan(Distances distances){  // Distances.java, 100
        return distances == null || (distances.disValueStationPlanet != null && this.disValueStationPlanet < distances.disValueStationPlanet);  // Distances.java, 101
    }  // Distances.java, 102
    public boolean isEqualDistanceThan(Distances distances){  // Distances.java, 104
        return distances != null && distances.disValueStationPlanet != null && this.disValueStationPlanet == distances.disValueStationPlanet;  // Distances.java, 105
    }  // Distances.java, 106
    public Distances getSmallerDistance(Distances distances){  // Distances.java, 108
           if(this.isSmallerDistanceThan(distances)){  // Distances.java, 109
               return this;  // Distances.java, 110
           }else{  // Distances.java, 111
               return distances;  // Distances.java, 112
           }  // Distances.java, 113
    }  // Distances.java, 114
    public Distances getSmallerAvailableDistance(Distances distances){  // Distances.java, 116
        if(this.isSmallerDistanceThan(distances) && this.getStation().isAvailable()){  // Distances.java, 117
            return this;  // Distances.java, 118
        }else{  // Distances.java, 119
            return distances;  // Distances.java, 120
        }  // Distances.java, 121
    }  // Distances.java, 122
    public Station getStation() {  // Distances.java, 124
        return station;  // Distances.java, 125
    }  // Distances.java, 126
    public Planet getPlanet() {  // Distances.java, 128
        return planet;  // Distances.java, 129
    }  // Distances.java, 130
    public int getDisValueStationPlanet() {  // Distances.java, 132
        return disValueStationPlanet;  // Distances.java, 133
    }  // Distances.java, 134
    public Integer getValueTerraformingStationPlanet(){  // Distances.java, 136
        return disValueTerraforming;  // Distances.java, 137
    }  // Distances.java, 138
    public Integer getValueAlienStationPlanet(){  // Distances.java, 140
        return disValueAlien;  // Distances.java, 141
    }  // Distances.java, 142
    public Integer getValueEngineeringStationPlanet(){  // Distances.java, 144
        return disValueEngineering;  // Distances.java, 145
    }  // Distances.java, 146
    public Integer getValueAgricultureStationPlanet(){  // Distances.java, 148
        return disValueAgriculture;  // Distances.java, 149
    }  // Distances.java, 150
    public Integer getUsableToken() {  // Distances.java, 152
        return usableToken;  // Distances.java, 153
    }  // Distances.java, 154
    @Override  // Distances.java, 156
    public String toString() {  // Distances.java, 157
        return "Distances{\n" +  // Distances.java, 158
                "    station=" + station + "\n" +  // Distances.java, 159
                "    planet=" + planet + "\n" +  // Distances.java, 160
                "    distance Value=" + disValueStationPlanet +  // Distances.java, 161
                ", [" + disValueTerraforming +  // Distances.java, 162
                ", " + disValueAlien +  // Distances.java, 163
                ", " + disValueEngineering +  // Distances.java, 164
                ", " + disValueAgriculture + "]\n" +  // Distances.java, 165
                "    usableToken=" + usableToken +  // Distances.java, 166
                ", [" + usableTokenTerraforming +  // Distances.java, 167
                ", " + usableTokenAlien +  // Distances.java, 168
                ", " + usableTokenEngineering +  // Distances.java, 169
                ", " + usableTokenAgriculture +  // Distances.java, 170
                "]\n}";  // Distances.java, 171
    }  // Distances.java, 172
}  // Distances.java, 173

enum BonusType {  // BonusType.java, 5
    ENERGY_CORE("ENERGY_CORE"),  // BonusType.java, 6
    TECH_RESEARCH_2("TECH_RESEARCH_2"),  // BonusType.java, 7
    TECH_RESEARCH_3("TECH_RESEARCH_3"),  // BonusType.java, 8
    TECH_RESEARCH_4("TECH_RESEARCH_4"),  // BonusType.java, 9
    NEW_TECH("NEW_TECH"),  // BonusType.java, 10
    POINTS_1("POINTS_1"),  // BonusType.java, 11
    POINTS_2("POINTS_2"),  // BonusType.java, 12
    POINTS_3("POINTS_3"),  // BonusType.java, 13
    ALIEN_ARTIFACT("ALIEN_ARTIFACT");  // BonusType.java, 14
    private String bonusValue;  // BonusType.java, 16
    BonusType(String bonusValue) {  // BonusType.java, 18
        this.bonusValue = bonusValue;  // BonusType.java, 19
    }  // BonusType.java, 20
    @Override  // BonusType.java, 22
    public String toString() {  // BonusType.java, 23
        return  bonusValue ;  // BonusType.java, 24
    }  // BonusType.java, 25
    public String getBonusValue() {  // BonusType.java, 27
        return bonusValue;  // BonusType.java, 28
    }  // BonusType.java, 29
    public boolean isBonusAvailableInList(ArrayList<Bonus> myBonus) {  // BonusType.java, 31
        if (myBonus == null) {  // BonusType.java, 32
            return false;  // BonusType.java, 33
        }  // BonusType.java, 34
        for (Bonus bonus : myBonus) {  // BonusType.java, 35
            if (this.equals(bonus.getBonus())) {  // BonusType.java, 36
                return true;  // BonusType.java, 37
            }  // BonusType.java, 38
        }  // BonusType.java, 39
        return false;  // BonusType.java, 40
    }  // BonusType.java, 41
}  // BonusType.java, 42

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
    @Override  // StationObjective.java, 20
    public String toString() {  // StationObjective.java, 21
        return "StationObj{" +  // StationObjective.java, 22
                "Score=" + scoreIfReached +  // StationObjective.java, 23
                ", Level=[" + terraLevelObj +  // StationObjective.java, 24
                ", " + alienLevelObj +  // StationObjective.java, 25
                ", " + engineeringLevelObj +  // StationObjective.java, 26
                ", " + agricultureLevelObj +  // StationObjective.java, 27
                "]}";  // StationObjective.java, 28
    }  // StationObjective.java, 29
}  // StationObjective.java, 30

class Planet {  // Planet.java, 5
    int planetId;  // Planet.java, 6
    //left to complete  // Planet.java, 7
    int terraformingTaskLeftValue;  // Planet.java, 8
    int alienTaskLeftValue;  // Planet.java, 9
    int engineeringTaskLeftValue;  // Planet.java, 10
    int agricultureTaskLeftValue;  // Planet.java, 11
    int myContributionTotalTaks;  // Planet.java, 13
    int oppContributionTotalTasks;  // Planet.java, 14
    int colonizationScore;  // Planet.java, 16
    String bonus0;  // Planet.java, 18
    String bonus1;  // Planet.java, 19
    public Planet(int id, int tValue, int alValue, int eValue, int agValue, int myC, int oppC, int coloScore,String bonus0, String bonus1)  // Planet.java, 22
    {  // Planet.java, 23
        this.planetId=id;  // Planet.java, 24
        this.terraformingTaskLeftValue =tValue;  // Planet.java, 25
        this.alienTaskLeftValue =alValue;  // Planet.java, 26
        this.engineeringTaskLeftValue =eValue;  // Planet.java, 27
        this.agricultureTaskLeftValue =agValue;  // Planet.java, 28
        this.myContributionTotalTaks = myC;  // Planet.java, 29
        this.oppContributionTotalTasks=oppC;  // Planet.java, 30
        this.colonizationScore=coloScore;  // Planet.java, 31
        this.bonus0=bonus0;  // Planet.java, 32
        this.bonus1=bonus1;  // Planet.java, 33
    }  // Planet.java, 34
    public int getPlanetId() {  // Planet.java, 36
        return planetId;  // Planet.java, 37
    }  // Planet.java, 38
    public int getTerraformingTaskLeftValue() {  // Planet.java, 40
        return terraformingTaskLeftValue;  // Planet.java, 41
    }  // Planet.java, 42
    public int getAlienTaskLeftValue() {  // Planet.java, 44
        return alienTaskLeftValue;  // Planet.java, 45
    }  // Planet.java, 46
    public int getEngineeringTaskLeftValue() {  // Planet.java, 48
        return engineeringTaskLeftValue;  // Planet.java, 49
    }  // Planet.java, 50
    public int getAgricultureTaskLeftValue() {  // Planet.java, 52
        return agricultureTaskLeftValue;  // Planet.java, 53
    }  // Planet.java, 54
    public int getMyContributionTotalTaks() {  // Planet.java, 56
        return myContributionTotalTaks;  // Planet.java, 57
    }  // Planet.java, 58
    public int getOppContributionTotalTasks() {  // Planet.java, 60
        return oppContributionTotalTasks;  // Planet.java, 61
    }  // Planet.java, 62
    public int getColonizationScore() {  // Planet.java, 64
        return colonizationScore;  // Planet.java, 65
    }  // Planet.java, 66
    public String getBonus0() {  // Planet.java, 68
        return bonus0;  // Planet.java, 69
    }  // Planet.java, 70
    public String getBonus1() {  // Planet.java, 72
        return bonus1;  // Planet.java, 73
    }  // Planet.java, 74
    public String getBestBonus(ArrayList<Bonus> myBonus){  // Planet.java, 76
        //let's take the points first  // Planet.java, 77
        if (BonusType.POINTS_3.toString().equals(this.bonus0))  // Planet.java, 78
            return "0";  // Planet.java, 79
        if (BonusType.POINTS_3.toString().equals(this.bonus1))  // Planet.java, 80
            return "1";  // Planet.java, 81
        if (BonusType.POINTS_2.toString().equals(this.bonus0))  // Planet.java, 82
            return "0";  // Planet.java, 83
        if (BonusType.POINTS_2.toString().equals(this.bonus1))  // Planet.java, 84
            return "1";  // Planet.java, 85
        if (BonusType.POINTS_1.toString().equals(this.bonus0))  // Planet.java, 86
            return "0";  // Planet.java, 87
        if (BonusType.POINTS_1.toString().equals(this.bonus1))  // Planet.java, 88
            return "1";  // Planet.java, 89
        //then the energy  // Planet.java, 91
        if (BonusType.ENERGY_CORE.toString().equals(this.bonus0) && !BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus))  // Planet.java, 92
            return "0";  // Planet.java, 93
        if (BonusType.ENERGY_CORE.toString().equals(this.bonus1) && !BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus))  // Planet.java, 94
            return "1";  // Planet.java, 95
        //then the TECH TODO to be customized with station obj  // Planet.java, 97
        if (BonusType.TECH_RESEARCH_2.toString().equals(this.bonus0))  // Planet.java, 98
            return "0";  // Planet.java, 99
        if (BonusType.TECH_RESEARCH_2.toString().equals(this.bonus1))  // Planet.java, 100
            return "1";  // Planet.java, 101
        if (BonusType.TECH_RESEARCH_3.toString().equals(this.bonus0))  // Planet.java, 102
            return "0";  // Planet.java, 103
        if (BonusType.TECH_RESEARCH_3.toString().equals(this.bonus1))  // Planet.java, 104
            return "1";  // Planet.java, 105
            if (BonusType.TECH_RESEARCH_4.toString().equals(this.bonus0))  // Planet.java, 106
            return "0";  // Planet.java, 107
        if (BonusType.TECH_RESEARCH_4.toString().equals(this.bonus1))  // Planet.java, 108
            return "1";  // Planet.java, 109
        if (BonusType.ALIEN_ARTIFACT.toString().equals(this.bonus0))  // Planet.java, 111
            return "0";  // Planet.java, 112
        if (BonusType.ALIEN_ARTIFACT.toString().equals(this.bonus1))  // Planet.java, 113
            return "1";  // Planet.java, 114
        return "0";  // Planet.java, 116
    }  // Planet.java, 117
    @Override  // Planet.java, 119
    public String toString() {  // Planet.java, 120
        return "Planet{" + planetId +  // Planet.java, 121
                ", [" + terraformingTaskLeftValue +  // Planet.java, 122
                ", " + alienTaskLeftValue +  // Planet.java, 123
                ", " + engineeringTaskLeftValue +  // Planet.java, 124
                ", " + agricultureTaskLeftValue +  // Planet.java, 125
                "], myContributionTotalTaks=" + myContributionTotalTaks +  // Planet.java, 126
                ", oppContributionTotalTasks=" + oppContributionTotalTasks +  // Planet.java, 127
                ", colonizationScore=" + colonizationScore +  // Planet.java, 128
                ", bonus=[" + bonus0 +  // Planet.java, 129
                ", " + bonus1 + "]}";  // Planet.java, 130
    }  // Planet.java, 131
}  // Planet.java, 132

class Station {  // Station.java, 3
    int stationId;  // Station.java, 4
    int isMine;  // Station.java, 5
    int isAvailable;  // Station.java, 6
    //tech values  // Station.java, 8
    int terraformingSkill;  // Station.java, 9
    int alienSkill;  // Station.java, 10
    int engineeringSkill;  // Station.java, 11
    int agricultureSkill;  // Station.java, 12
    StationObjective myStationObj;  // Station.java, 14
    //constructor  // Station.java, 16
    public Station(int id,int isMine)  // Station.java, 17
    {  // Station.java, 18
        this.stationId=id;  // Station.java, 19
        this.isMine=isMine;  // Station.java, 20
    }  // Station.java, 22
    public void setTechLevel(int tValue,int alValue,int eValue,int agValue)  // Station.java, 23
    {  // Station.java, 24
        this.terraformingSkill =tValue;  // Station.java, 25
        this.alienSkill =alValue;  // Station.java, 26
        this.engineeringSkill =eValue;  // Station.java, 27
        this.agricultureSkill =agValue;  // Station.java, 28
    }  // Station.java, 29
    public void setAvailable(int available)  // Station.java, 31
    {  // Station.java, 32
        this.isAvailable=available;  // Station.java, 33
    }  // Station.java, 34
    public int isMine()  // Station.java, 36
    {  // Station.java, 37
        return isMine;  // Station.java, 38
    }  // Station.java, 39
    public boolean isAvailable()  // Station.java, 41
    {  // Station.java, 42
        return isAvailable==1;  // Station.java, 43
    }  // Station.java, 44
    public void setObjective(StationObjective stO)  // Station.java, 46
    {  // Station.java, 47
        this.myStationObj=stO;  // Station.java, 48
    }  // Station.java, 49
    public int getStationId() {  // Station.java, 51
        return stationId;  // Station.java, 52
    }  // Station.java, 53
    public int getIsMine() {  // Station.java, 55
        return isMine;  // Station.java, 56
    }  // Station.java, 57
    public int getIsAvailable() {  // Station.java, 59
        return isAvailable;  // Station.java, 60
    }  // Station.java, 61
    public int getTerraformingSkill() {  // Station.java, 63
        return terraformingSkill;  // Station.java, 64
    }  // Station.java, 65
    public int getAlienSkill() {  // Station.java, 67
        return alienSkill;  // Station.java, 68
    }  // Station.java, 69
    public int getEngineeringSkill() {  // Station.java, 71
        return engineeringSkill;  // Station.java, 72
    }  // Station.java, 73
    public int getAgricultureSkill() {  // Station.java, 75
        return agricultureSkill;  // Station.java, 76
    }  // Station.java, 77
    public StationObjective getMyStationObj() {  // Station.java, 79
        return myStationObj;  // Station.java, 80
    }  // Station.java, 81
    @Override  // Station.java, 83
    public String toString() {  // Station.java, 84
        return "Station{" +  // Station.java, 85
                "" + stationId +  // Station.java, 86
                ", mine=" + isMine +  // Station.java, 87
                ", avail=" + isAvailable +  // Station.java, 88
                ", skill=[" + terraformingSkill +  // Station.java, 89
                ", " + alienSkill +  // Station.java, 90
                ", " + engineeringSkill +  // Station.java, 91
                ", " + agricultureSkill +  // Station.java, 92
                "], " + myStationObj +  // Station.java, 93
                "}";  // Station.java, 94
    }  // Station.java, 95
}  // Station.java, 96

class Bonus {  // Bonus.java, 3
    private BonusType bonus;  // Bonus.java, 5
    public Bonus(String bonus) {  // Bonus.java, 7
        this.bonus = BonusType.valueOf(bonus);  // Bonus.java, 8
    }  // Bonus.java, 9
    public BonusType getBonus() {  // Bonus.java, 11
        return bonus;  // Bonus.java, 12
    }  // Bonus.java, 13
    @Override  // Bonus.java, 15
    public String toString() {  // Bonus.java, 16
        return "Bonus{" + bonus +  // Bonus.java, 17
                '}';  // Bonus.java, 18
    }  // Bonus.java, 19
}  // Bonus.java, 20

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
        ArrayList<Distances> distancesArrayList = new ArrayList<>();  // Strategy.java, 28
        Distances distance;  // Strategy.java, 29
        Distances disMin = null;  // Strategy.java, 30
        Distances disMinAvailable = null;  // Strategy.java, 31
        for(int i=0; i<myStations.length; i++){  // Strategy.java, 32
            for (Planet planet: planets){  // Strategy.java, 33
                distance = new Distances(myStations[i], planet);  // Strategy.java, 34
                if(distancesArrayList.size() == 0){  // Strategy.java, 35
                    distancesArrayList.add(distance);  // Strategy.java, 36
                    disMin = distance;  // Strategy.java, 37
                }else{  // Strategy.java, 38
                    if(distance.isSmallerDistanceThan(disMin)){  // Strategy.java, 39
                        distancesArrayList.clear();  // Strategy.java, 40
                        distancesArrayList.add(distance);  // Strategy.java, 41
                        disMin = distance;  // Strategy.java, 42
                    }else if(distance.isEqualDistanceThan(disMin)){  // Strategy.java, 43
                        distancesArrayList.add(distance);  // Strategy.java, 44
                    }  // Strategy.java, 45
                }  // Strategy.java, 46
                //System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());  // Strategy.java, 47
            }  // Strategy.java, 48
        }  // Strategy.java, 49
        Distances distanceToPlay = getBestTokenUsableFromList(distancesArrayList) ;  // Strategy.java, 52
        System.err.println("Number of min Dist="+distancesArrayList.size());  // Strategy.java, 53
        System.err.println("Distrance To play:"+distanceToPlay.toString());  // Strategy.java, 54
        if(distanceToPlay.getStation().isAvailable()) {  // Strategy.java, 56
                return preCommand+applyColonizeWithAllienAttempt(myBonus,distanceToPlay);  // Strategy.java, 57
        }else{  // Strategy.java, 58
            //do we have an avaialble station with the same distance ? if yes, let's colonize with it ....  // Strategy.java, 59
            disMinAvailable = getBestTokenUsableFromList(geAvailablesFromList(distancesArrayList));  // Strategy.java, 60
            if(disMinAvailable != null && disMinAvailable.getDisValueStationPlanet() <= distanceToPlay.getDisValueStationPlanet()){  // Strategy.java, 61
                System.err.println("Distrance To play (Min Available):"+disMinAvailable.toString());  // Strategy.java, 62
                return preCommand+applyColonizeWithAllienAttempt(myBonus,disMinAvailable) ;  // Strategy.java, 64
            }  // Strategy.java, 65
            //... else let's try to apply a bonus to the non available better one  // Strategy.java, 66
            //do dwe have a ENERGY BONUS to allow resupply and colonize in one shot  // Strategy.java, 67
            return preCommand+applyEnergyAndColonize_Or_Resupply(myBonus, applyColonizeWithAllienAttempt(myBonus,distanceToPlay));  // Strategy.java, 68
        }  // Strategy.java, 70
    }  // Strategy.java, 71
    public ArrayList<Distances> geAvailablesFromList(ArrayList<Distances> distancesArrayList){  // Strategy.java, 73
        ArrayList<Distances> list = new ArrayList<>();  // Strategy.java, 74
        if (distancesArrayList != null){  // Strategy.java, 75
            for(Distances distances: distancesArrayList){  // Strategy.java, 76
                if(distances.getStation().isAvailable()){  // Strategy.java, 77
                    list.add(distances);  // Strategy.java, 78
                }  // Strategy.java, 79
            }  // Strategy.java, 80
        }  // Strategy.java, 81
        return list;  // Strategy.java, 82
    }  // Strategy.java, 83
    public Distances getBestTokenUsableFromList(ArrayList<Distances> distancesArrayList){  // Strategy.java, 85
        if (distancesArrayList == null){  // Strategy.java, 86
            return null;  // Strategy.java, 87
        }  // Strategy.java, 88
        Distances prev = null;  // Strategy.java, 89
        Distances cur = null;  // Strategy.java, 90
        for(Distances distances: distancesArrayList){  // Strategy.java, 91
            if(prev == null){  // Strategy.java, 92
                prev = distances;  // Strategy.java, 93
                cur = distances;  // Strategy.java, 94
            }else{  // Strategy.java, 95
                if(cur.getUsableToken() > prev.getUsableToken()){  // Strategy.java, 96
                    prev = cur;  // Strategy.java, 97
                }  // Strategy.java, 98
            }  // Strategy.java, 99
        }  // Strategy.java, 100
        return prev;  // Strategy.java, 101
    }  // Strategy.java, 102
    public String applyTechPreCommand(){  // Strategy.java, 104
        String resultCommand = "";  // Strategy.java, 105
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station  // Strategy.java, 106
        for(Bonus bonus: myBonus){  // Strategy.java, 107
            System.err.println(bonus.toString());  // Strategy.java, 108
            int techREsearchBonusNum = -1;  // Strategy.java, 109
            String commandName = "";  // Strategy.java, 110
            if(BonusType.NEW_TECH.equals(bonus.getBonus())) {  // Strategy.java, 111
                techREsearchBonusNum = 0;  // Strategy.java, 112
                commandName = "NEW_TECH ";  // Strategy.java, 113
            }else if(BonusType.TECH_RESEARCH_2.equals(bonus.getBonus())) {  // Strategy.java, 114
                techREsearchBonusNum = 1;  // Strategy.java, 115
                commandName = "TECH_RESEARCH ";  // Strategy.java, 116
            }else if(BonusType.TECH_RESEARCH_3.equals(bonus.getBonus())) {  // Strategy.java, 117
                techREsearchBonusNum = 2;  // Strategy.java, 118
                commandName = "TECH_RESEARCH ";  // Strategy.java, 119
            }if(BonusType.TECH_RESEARCH_4.equals(bonus.getBonus())) {  // Strategy.java, 120
                techREsearchBonusNum = 3;  // Strategy.java, 121
                commandName = "TECH_RESEARCH ";  // Strategy.java, 122
            }  // Strategy.java, 123
            if (techREsearchBonusNum >= 0) {  // Strategy.java, 124
                for (int i = 0; i < myStations.length; i++) {  // Strategy.java, 125
                    Station station = myStations[i];  // Strategy.java, 126
                    if (station.getTerraformingSkill() == techREsearchBonusNum) {  // Strategy.java, 128
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);  // Strategy.java, 129
                        station.terraformingSkill += 1;  // Strategy.java, 130
                        System.err.println("Station impacted: "+station.toString());  // Strategy.java, 131
                        break;  // Strategy.java, 132
                    } else if (station.getAlienSkill() == techREsearchBonusNum) {  // Strategy.java, 133
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);  // Strategy.java, 134
                        station.alienSkill += 1;  // Strategy.java, 135
                        System.err.println("Station impacted: "+station.toString());  // Strategy.java, 136
                        break;  // Strategy.java, 137
                    } else if (station.getEngineeringSkill() == techREsearchBonusNum) {  // Strategy.java, 138
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);  // Strategy.java, 139
                        station.engineeringSkill += 1;  // Strategy.java, 140
                        System.err.println("Station impacted: "+station.toString());  // Strategy.java, 141
                        break;  // Strategy.java, 142
                    } else if (station.getAgricultureSkill() == techREsearchBonusNum) {  // Strategy.java, 143
                        resultCommand += commandName + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);  // Strategy.java, 144
                        station.agricultureSkill += 1;  // Strategy.java, 145
                        System.err.println("Station impacted: "+station.toString());  // Strategy.java, 146
                        break;  // Strategy.java, 147
                    }  // Strategy.java, 148
                }  // Strategy.java, 149
            }  // Strategy.java, 150
        }  // Strategy.java, 151
        if (!"".equals(resultCommand)){  // Strategy.java, 152
            resultCommand += " ";  // Strategy.java, 153
        }  // Strategy.java, 154
        System.err.println("PreCommand = "+resultCommand);  // Strategy.java, 155
        return resultCommand;  // Strategy.java, 156
    }  // Strategy.java, 157
    public String applyEnergyAndColonize_Or_Resupply (ArrayList<Bonus> myBonus, String colonizeAction)  // Strategy.java, 159
    {  // Strategy.java, 160
        if(BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus)){  // Strategy.java, 161
            return BonusType.ENERGY_CORE+" "+ colonizeAction;  // Strategy.java, 162
        }  // Strategy.java, 163
        else{  // Strategy.java, 164
            //no choice  // Strategy.java, 165
            return "RESUPPLY";  // Strategy.java, 166
        }  // Strategy.java, 167
    }  // Strategy.java, 168
    public String applyColonizeWithAllienAttempt(ArrayList<Bonus> myBonus, Distances distanceToPlay)  // Strategy.java, 170
    {  // Strategy.java, 171
        String prefixAllien = "";  // Strategy.java, 172
        if (distanceToPlay.getDisValueStationPlanet()>=2 && BonusType.ALIEN_ARTIFACT.isBonusAvailableInList(myBonus))  // Strategy.java, 173
        {  // Strategy.java, 174
            int allien0;  // Strategy.java, 175
            int allien1;  // Strategy.java, 176
            int bonusCounter = 2;  // Strategy.java, 177
            int[] tasks = new int[2];  // Strategy.java, 178
            int currentTerraValue = distanceToPlay.getValueTerraformingStationPlanet();  // Strategy.java, 179
            int currentAllienValue = distanceToPlay.getValueAlienStationPlanet();  // Strategy.java, 180
            int currentEngValue = distanceToPlay.getValueEngineeringStationPlanet();  // Strategy.java, 181
            int currentAgriValue = distanceToPlay.getValueAgricultureStationPlanet();  // Strategy.java, 182
            while (currentTerraValue>=1 && bonusCounter>0)  // Strategy.java, 184
             {     // Strategy.java, 185
                tasks[tasks.length-bonusCounter] = 0; //0 for terra  // Strategy.java, 186
                bonusCounter--;  // Strategy.java, 187
                currentTerraValue--;  // Strategy.java, 188
             }  // Strategy.java, 189
             while (currentAllienValue>=1 && bonusCounter>0)  // Strategy.java, 190
             {     // Strategy.java, 191
                tasks[tasks.length-bonusCounter] = 1; //0 for allien  // Strategy.java, 192
                bonusCounter--;  // Strategy.java, 193
                currentAllienValue--;  // Strategy.java, 194
             }  // Strategy.java, 195
             while (currentEngValue>=1 && bonusCounter>0)  // Strategy.java, 196
             {     // Strategy.java, 197
                tasks[tasks.length-bonusCounter] = 2; //0 for eng  // Strategy.java, 198
                bonusCounter--;  // Strategy.java, 199
                currentEngValue--;  // Strategy.java, 200
             }  // Strategy.java, 201
             while (currentAgriValue>=1 && bonusCounter>0)  // Strategy.java, 202
             {     // Strategy.java, 203
                tasks[tasks.length-bonusCounter] = 3; //0 for agri  // Strategy.java, 204
                bonusCounter--;  // Strategy.java, 205
                currentAgriValue--;  // Strategy.java, 206
             }  // Strategy.java, 207
            prefixAllien+= "ALLIEN_ARTIFACT " + tasks[0] + " "+ tasks[1] + " ";  // Strategy.java, 210
        }  // Strategy.java, 211
        String colonizeAction="COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus(myBonus);  // Strategy.java, 213
        return prefixAllien + colonizeAction;  // Strategy.java, 214
    }  // Strategy.java, 215
}  // Strategy.java, 216

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