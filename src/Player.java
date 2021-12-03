/*
This file has been generated Fri Dec 03 12:45:18 CET 2021
*/

import java.util.List;import java.util.Scanner;import java.util.ArrayList;
class Player {
//import java.util.ArrayList;  // Distances.java, 3
class Distances {  // Distances.java, 5
    private Logger logger = new Logger();  // Distances.java, 6
    private Station station;  // Distances.java, 8
    private Planet planet;  // Distances.java, 9
    private Integer disValueStationPlanet = null;  // Distances.java, 11
    private Integer disValueTerraforming = null;  // Distances.java, 12
    private Integer disValueAlien = null;  // Distances.java, 13
    private Integer disValueEngineering = null;  // Distances.java, 14
    private Integer disValueAgriculture = null;  // Distances.java, 15
    private Integer usableToken = null;  // Distances.java, 17
    private Integer usableTokenTerraforming = null;  // Distances.java, 18
    private Integer usableTokenAlien = null;  // Distances.java, 19
    private Integer usableTokenEngineering = null;  // Distances.java, 20
    private Integer usableTokenAgriculture = null;  // Distances.java, 21
    public Distances(Station station, Planet planet){  // Distances.java, 23
        this.station = station;  // Distances.java, 24
        this.planet = planet;   // Distances.java, 25
        this.compute();  // Distances.java, 26
    }  // Distances.java, 27
    public void compute(){  // Distances.java, 29
        Integer result = null;  // Distances.java, 30
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 31
        if(this.planet.getTerraformingTaskLeftValue() != 0 ) {  // Distances.java, 32
            disValueTerraforming = this.planet.getTerraformingTaskLeftValue() - this.station.getTerraformingSkill();  // Distances.java, 33
            usableTokenTerraforming = Math.min(this.planet.getTerraformingTaskLeftValue(), this.station.getTerraformingSkill());  // Distances.java, 34
            if(disValueTerraforming < 0){  // Distances.java, 35
                disValueTerraforming = 0;  // Distances.java, 36
            }  // Distances.java, 37
            if(result == null){  // Distances.java, 38
                result = disValueTerraforming;  // Distances.java, 39
                usableToken = usableTokenTerraforming;  // Distances.java, 40
            }  // Distances.java, 41
        }  // Distances.java, 42
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 45
        if(this.planet.getAlienTaskLeftValue() != 0 ) {  // Distances.java, 46
            disValueAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();  // Distances.java, 47
            usableTokenAlien = Math.min(this.planet.getAlienTaskLeftValue(), this.station.getAlienSkill());  // Distances.java, 48
            if(disValueAlien < 0){  // Distances.java, 49
                disValueAlien = 0;  // Distances.java, 50
            }  // Distances.java, 51
            if(result == null){  // Distances.java, 52
                result = disValueAlien;  // Distances.java, 53
                usableToken = usableTokenAlien;  // Distances.java, 54
            }else{  // Distances.java, 55
                result += disValueAlien;  // Distances.java, 56
                usableToken += usableTokenAlien;  // Distances.java, 57
            }  // Distances.java, 58
        }  // Distances.java, 59
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 63
        if(this.planet.getEngineeringTaskLeftValue() != 0 ) {  // Distances.java, 64
            disValueEngineering = this.planet.getEngineeringTaskLeftValue() - this.station.getEngineeringSkill();  // Distances.java, 65
            usableTokenEngineering = Math.min(this.planet.getEngineeringTaskLeftValue(), this.station.getEngineeringSkill());  // Distances.java, 66
            if(disValueEngineering < 0){  // Distances.java, 67
                disValueEngineering = 0;  // Distances.java, 68
            }  // Distances.java, 69
            if(result == null){  // Distances.java, 70
                result = disValueEngineering;  // Distances.java, 71
                usableToken = usableTokenEngineering;  // Distances.java, 72
            }else{  // Distances.java, 73
                result += disValueEngineering;  // Distances.java, 74
                usableToken += usableTokenEngineering;  // Distances.java, 75
            }  // Distances.java, 76
        }  // Distances.java, 77
        // If no task remaining and no skill on station, not considered in distance  // Distances.java, 80
        if(this.planet.getAgricultureTaskLeftValue() != 0 ) {  // Distances.java, 81
            disValueAgriculture= this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();  // Distances.java, 82
            usableTokenAgriculture = Math.min(this.planet.getAgricultureTaskLeftValue(), this.station.getAgricultureSkill());  // Distances.java, 83
            if(disValueAgriculture < 0){  // Distances.java, 84
                disValueAgriculture = 0;  // Distances.java, 85
            }  // Distances.java, 86
            if(result == null){  // Distances.java, 87
                result = disValueAgriculture;  // Distances.java, 88
                usableToken = usableTokenAgriculture;  // Distances.java, 89
            }else{  // Distances.java, 90
                result += disValueAgriculture;  // Distances.java, 91
                usableToken += usableTokenAgriculture;  // Distances.java, 92
            }  // Distances.java, 93
        }  // Distances.java, 94
       this.disValueStationPlanet = result;  // Distances.java, 96
    }  // Distances.java, 97
    public boolean isSmallerDistanceThan(Distances distances){  // Distances.java, 99
        return distances == null || (distances.disValueStationPlanet != null && this.disValueStationPlanet < distances.disValueStationPlanet);  // Distances.java, 100
    }  // Distances.java, 101
    public boolean isEqualDistanceThan(Distances distances){  // Distances.java, 103
        return distances != null && distances.disValueStationPlanet != null && this.disValueStationPlanet == distances.disValueStationPlanet;  // Distances.java, 104
    }  // Distances.java, 105
    public Distances getSmallerDistance(Distances distances){  // Distances.java, 107
           if(this.isSmallerDistanceThan(distances)){  // Distances.java, 108
               return this;  // Distances.java, 109
           }else{  // Distances.java, 110
               return distances;  // Distances.java, 111
           }  // Distances.java, 112
    }  // Distances.java, 113
    public Distances getSmallerAvailableDistance(Distances distances){  // Distances.java, 115
        if(this.isSmallerDistanceThan(distances) && this.getStation().isAvailable()){  // Distances.java, 116
            return this;  // Distances.java, 117
        }else{  // Distances.java, 118
            return distances;  // Distances.java, 119
        }  // Distances.java, 120
    }  // Distances.java, 121
    public Station getStation() {  // Distances.java, 123
        return station;  // Distances.java, 124
    }  // Distances.java, 125
    public Planet getPlanet() {  // Distances.java, 127
        return planet;  // Distances.java, 128
    }  // Distances.java, 129
    public int getDisValueStationPlanet() {  // Distances.java, 131
        return disValueStationPlanet;  // Distances.java, 132
    }  // Distances.java, 133
    public Integer getValueTerraformingStationPlanet(){  // Distances.java, 135
        return disValueTerraforming;  // Distances.java, 136
    }  // Distances.java, 137
    public Integer getValueAlienStationPlanet(){  // Distances.java, 139
        return disValueAlien;  // Distances.java, 140
    }  // Distances.java, 141
    public Integer getValueEngineeringStationPlanet(){  // Distances.java, 143
        return disValueEngineering;  // Distances.java, 144
    }  // Distances.java, 145
    public Integer getValueAgricultureStationPlanet(){  // Distances.java, 147
        return disValueAgriculture;  // Distances.java, 148
    }  // Distances.java, 149
    public Integer getUsableToken() {  // Distances.java, 151
        return usableToken;  // Distances.java, 152
    }  // Distances.java, 153
    /**  // Distances.java, 155
     * @return true if we will win against the opponant  // Distances.java, 156
     */  // Distances.java, 157
    public boolean willBeBetter (boolean withAlienBonus) {  // Distances.java, 158
        int extraToken = 0;  // Distances.java, 160
        if (withAlienBonus)  // Distances.java, 161
            extraToken=2;  // Distances.java, 162
        if (planet.myContributionTotalTaks < planet.oppContributionTotalTasks   // Distances.java, 163
            && (planet.myContributionTotalTaks + usableToken + extraToken >= planet.oppContributionTotalTasks))  // Distances.java, 164
            {  // Distances.java, 165
                logger.println("we will be better than opp on planet " + planet.planetId + " alien bonus =" + extraToken);  // Distances.java, 166
                return true;  // Distances.java, 167
            }  // Distances.java, 168
        return false;  // Distances.java, 169
    }  // Distances.java, 170
    /**  // Distances.java, 172
     * @return true if we will finish the colonization of this planet  // Distances.java, 173
     */  // Distances.java, 174
    public boolean willCompleteColonize (boolean withAlienBonus) {  // Distances.java, 175
        int extraToken = 0;  // Distances.java, 176
        if (withAlienBonus)  // Distances.java, 177
            extraToken=2;  // Distances.java, 178
        if (usableToken + extraToken >= disValueStationPlanet)  // Distances.java, 180
         {  // Distances.java, 181
            logger.println("we will be complete the colonization of planet " + planet.planetId + " alien bonus =" + extraToken);  // Distances.java, 182
            return true;  // Distances.java, 183
         }  // Distances.java, 184
        return false;  // Distances.java, 185
    }  // Distances.java, 186
    @Override  // Distances.java, 188
    public String toString() {  // Distances.java, 189
        return "Distances{\n" +  // Distances.java, 190
                "    station=" + station + "\n" +  // Distances.java, 191
                "    planet=" + planet + "\n" +  // Distances.java, 192
                "    distance Value=" + disValueStationPlanet +  // Distances.java, 193
                ", [" + disValueTerraforming +  // Distances.java, 194
                ", " + disValueAlien +  // Distances.java, 195
                ", " + disValueEngineering +  // Distances.java, 196
                ", " + disValueAgriculture + "]\n" +  // Distances.java, 197
                "    usableToken=" + usableToken +  // Distances.java, 198
                ", [" + usableTokenTerraforming +  // Distances.java, 199
                ", " + usableTokenAlien +  // Distances.java, 200
                ", " + usableTokenEngineering +  // Distances.java, 201
                ", " + usableTokenAgriculture +  // Distances.java, 202
                "]\n}";  // Distances.java, 203
    }  // Distances.java, 204
}  // Distances.java, 205

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
        if (BonusType.NEW_TECH.toString().equals(this.bonus0))  // Planet.java, 98
            return "0";  // Planet.java, 99
        if (BonusType.NEW_TECH.toString().equals(this.bonus1))  // Planet.java, 100
            return "1";  // Planet.java, 101
        if (BonusType.TECH_RESEARCH_2.toString().equals(this.bonus0))  // Planet.java, 102
            return "0";  // Planet.java, 103
        if (BonusType.TECH_RESEARCH_2.toString().equals(this.bonus1))  // Planet.java, 104
            return "1";  // Planet.java, 105
        if (BonusType.TECH_RESEARCH_3.toString().equals(this.bonus0))  // Planet.java, 106
            return "0";  // Planet.java, 107
        if (BonusType.TECH_RESEARCH_3.toString().equals(this.bonus1))  // Planet.java, 108
            return "1";  // Planet.java, 109
            if (BonusType.TECH_RESEARCH_4.toString().equals(this.bonus0))  // Planet.java, 110
            return "0";  // Planet.java, 111
        if (BonusType.TECH_RESEARCH_4.toString().equals(this.bonus1))  // Planet.java, 112
            return "1";  // Planet.java, 113
        if (BonusType.ALIEN_ARTIFACT.toString().equals(this.bonus0))  // Planet.java, 115
            return "0";  // Planet.java, 116
        if (BonusType.ALIEN_ARTIFACT.toString().equals(this.bonus1))  // Planet.java, 117
            return "1";  // Planet.java, 118
        return "0";  // Planet.java, 120
    }  // Planet.java, 121
    @Override  // Planet.java, 123
    public String toString() {  // Planet.java, 124
        return "Planet{" + planetId +  // Planet.java, 125
                ", [" + terraformingTaskLeftValue +  // Planet.java, 126
                ", " + alienTaskLeftValue +  // Planet.java, 127
                ", " + engineeringTaskLeftValue +  // Planet.java, 128
                ", " + agricultureTaskLeftValue +  // Planet.java, 129
                "], myContributionTotalTaks=" + myContributionTotalTaks +  // Planet.java, 130
                ", oppContributionTotalTasks=" + oppContributionTotalTasks +  // Planet.java, 131
                ", colonizationScore=" + colonizationScore +  // Planet.java, 132
                ", bonus=[" + bonus0 +  // Planet.java, 133
                ", " + bonus1 + "]}";  // Planet.java, 134
    }  // Planet.java, 135
}  // Planet.java, 136

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
    public boolean isTerraformingObjectiveReached() {  // Station.java, 84
        if (myStationObj != null && terraformingSkill >= myStationObj.terraLevelObj)  // Station.java, 85
            return true;  // Station.java, 86
        return false;  // Station.java, 87
    }  // Station.java, 88
    public boolean isAlienObjectiveReached() {  // Station.java, 90
        if (myStationObj != null && alienSkill >= myStationObj.alienLevelObj)  // Station.java, 91
            return true;  // Station.java, 92
        return false;  // Station.java, 93
    }  // Station.java, 94
    public boolean isEngineeringObjectiveReached() {  // Station.java, 96
        if (myStationObj != null && engineeringSkill >= myStationObj.engineeringLevelObj)  // Station.java, 97
            return true;  // Station.java, 98
        return false;  // Station.java, 99
    }  // Station.java, 100
    public boolean isAgricultureObjectiveReached() {  // Station.java, 102
    if (myStationObj != null && agricultureSkill >= myStationObj.agricultureLevelObj)  // Station.java, 103
        return true;  // Station.java, 104
    return false;  // Station.java, 105
    }  // Station.java, 106
    public String toString() {  // Station.java, 109
        return "Station{" +  // Station.java, 110
                "" + stationId +  // Station.java, 111
                ", mine=" + isMine +  // Station.java, 112
                ", avail=" + isAvailable +  // Station.java, 113
                ", skill=[" + terraformingSkill +  // Station.java, 114
                ", " + alienSkill +  // Station.java, 115
                ", " + engineeringSkill +  // Station.java, 116
                ", " + agricultureSkill +  // Station.java, 117
                "], " + myStationObj +  // Station.java, 118
                "}";  // Station.java, 119
    }  // Station.java, 120
}  // Station.java, 122

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

class TechCommand {  // TechCommand.java, 3
    private BonusType bonusType;  // TechCommand.java, 5
    private Station station;  // TechCommand.java, 6
    private TechEnum techApplying;  // TechCommand.java, 7
    // Contains the expected tech value for the tech enum. Meaning TECH_RESEARCH_2 -> newTechValue is 2  // TechCommand.java, 8
    // NEW_TECH value is 1  // TechCommand.java, 9
    private int newTechValue;  // TechCommand.java, 10
    private String commandName;  // TechCommand.java, 11
    public TechCommand(BonusType bonusType, Station station) {  // TechCommand.java, 13
        this.bonusType = bonusType;  // TechCommand.java, 14
        this.station = station;  // TechCommand.java, 15
        commandName = "";  // TechCommand.java, 16
        if (BonusType.NEW_TECH.equals(bonusType)) {  // TechCommand.java, 17
            this.newTechValue = 1;  // TechCommand.java, 18
            commandName = "NEW_TECH ";  // TechCommand.java, 19
        } else if (BonusType.TECH_RESEARCH_2.equals(bonusType)) {  // TechCommand.java, 20
            this.newTechValue = 2;  // TechCommand.java, 21
            commandName = "TECH_RESEARCH ";  // TechCommand.java, 22
        } else if (BonusType.TECH_RESEARCH_3.equals(bonusType)) {  // TechCommand.java, 23
            this.newTechValue = 3;  // TechCommand.java, 24
            commandName = "TECH_RESEARCH ";  // TechCommand.java, 25
        }  // TechCommand.java, 26
        if (BonusType.TECH_RESEARCH_4.equals(bonusType)) {  // TechCommand.java, 27
            this.newTechValue = 4;  // TechCommand.java, 28
            commandName = "TECH_RESEARCH ";  // TechCommand.java, 29
        }  // TechCommand.java, 30
    }  // TechCommand.java, 31
    public boolean canApplyTechEnum(TechEnum techApplying) {  // TechCommand.java, 33
        if (TechEnum.TERRAFORMING.equals(techApplying)) {  // TechCommand.java, 34
            if (station.getTerraformingSkill() == this.newTechValue - 1) {  // TechCommand.java, 35
                return true;  // TechCommand.java, 36
            }  // TechCommand.java, 37
        } else if (TechEnum.ALIEN.equals(techApplying)) {  // TechCommand.java, 38
            if (station.getAlienSkill() == this.newTechValue - 1) {  // TechCommand.java, 39
                return true;  // TechCommand.java, 40
            }  // TechCommand.java, 41
        } else if (TechEnum.ENGINEERING.equals(techApplying)) {  // TechCommand.java, 42
            if (station.getEngineeringSkill() == this.newTechValue - 1) {  // TechCommand.java, 43
                return true;  // TechCommand.java, 44
            }  // TechCommand.java, 45
        } else if (TechEnum.AGRICULTURE.equals(techApplying)) {  // TechCommand.java, 46
            if (station.getAgricultureSkill() == this.newTechValue - 1) {  // TechCommand.java, 47
                return true;  // TechCommand.java, 48
            }  // TechCommand.java, 49
        }  // TechCommand.java, 50
        return false;  // TechCommand.java, 51
    }  // TechCommand.java, 52
    public boolean canApplyBestObjectiveTechEnum(TechEnum techApplying) {  // TechCommand.java, 54
       // System.err.println(station.isTerraformingObjectiveReached());  // TechCommand.java, 55
        if (TechEnum.TERRAFORMING.equals(techApplying) && !station.isTerraformingObjectiveReached()) {  // TechCommand.java, 56
            if (station.getTerraformingSkill() == this.newTechValue - 1) {  // TechCommand.java, 57
                return true;  // TechCommand.java, 58
            }  // TechCommand.java, 59
        } else if (TechEnum.ALIEN.equals(techApplying) && !station.isAlienObjectiveReached()) {  // TechCommand.java, 60
            if (station.getAlienSkill() == this.newTechValue - 1) {  // TechCommand.java, 61
                return true;  // TechCommand.java, 62
            }  // TechCommand.java, 63
        } else if (TechEnum.ENGINEERING.equals(techApplying) && !station.isEngineeringObjectiveReached()) {  // TechCommand.java, 64
            if (station.getEngineeringSkill() == this.newTechValue - 1) {  // TechCommand.java, 65
                return true;  // TechCommand.java, 66
            }  // TechCommand.java, 67
        } else if (TechEnum.AGRICULTURE.equals(techApplying) && !station.isAgricultureObjectiveReached()) {  // TechCommand.java, 68
            if (station.getAgricultureSkill() == this.newTechValue - 1) {  // TechCommand.java, 69
                return true;  // TechCommand.java, 70
            }  // TechCommand.java, 71
        }  // TechCommand.java, 72
        return false;  // TechCommand.java, 73
    }  // TechCommand.java, 74
    public void setTechApplying(TechEnum techApplying) {  // TechCommand.java, 76
        this.techApplying = techApplying;  // TechCommand.java, 77
    }  // TechCommand.java, 78
    public TechCommand apply() {  // TechCommand.java, 80
        if(this.techApplying != null) {  // TechCommand.java, 81
            if (TechEnum.TERRAFORMING.equals(techApplying)) {  // TechCommand.java, 82
                station.terraformingSkill = this.newTechValue;  // TechCommand.java, 83
            } else if (TechEnum.ALIEN.equals(techApplying)) {  // TechCommand.java, 84
                station.alienSkill = this.newTechValue;  // TechCommand.java, 85
            } else if (TechEnum.ENGINEERING.equals(techApplying)) {  // TechCommand.java, 86
                station.engineeringSkill = this.newTechValue;  // TechCommand.java, 87
            } else if (TechEnum.AGRICULTURE.equals(techApplying)) {  // TechCommand.java, 88
                station.agricultureSkill = this.newTechValue;  // TechCommand.java, 89
            }  // TechCommand.java, 90
        }  // TechCommand.java, 91
        return this;  // TechCommand.java, 92
    }  // TechCommand.java, 93
    @Override  // TechCommand.java, 95
    public String toString() {  // TechCommand.java, 96
        return "TechCommand{" +  // TechCommand.java, 97
                "bonusType=" + bonusType +  // TechCommand.java, 98
                ", station=" + station +  // TechCommand.java, 99
                ", onTech=" + techApplying +  // TechCommand.java, 100
                ", newValue=" + newTechValue +  // TechCommand.java, 101
                '}';  // TechCommand.java, 102
    }  // TechCommand.java, 103
    // Execute the command and return it.  // TechCommand.java, 105
    public String executeCommand() {  // TechCommand.java, 106
        String command = commandName + station.getStationId() + " ";  // TechCommand.java, 107
        if (TechEnum.TERRAFORMING.equals(techApplying)) {  // TechCommand.java, 109
            command += TechEnum.getCode(TechEnum.TERRAFORMING);  // TechCommand.java, 110
        } else if (TechEnum.ALIEN.equals(techApplying)) {  // TechCommand.java, 111
            command += TechEnum.getCode(TechEnum.ALIEN);  // TechCommand.java, 112
        } else if (TechEnum.ENGINEERING.equals(techApplying)) {  // TechCommand.java, 113
            command += TechEnum.getCode(TechEnum.ENGINEERING);  // TechCommand.java, 114
        } else if (TechEnum.AGRICULTURE.equals(techApplying)) {  // TechCommand.java, 115
            command += TechEnum.getCode(TechEnum.AGRICULTURE);  // TechCommand.java, 116
        }  // TechCommand.java, 117
        return command;  // TechCommand.java, 118
    }  // TechCommand.java, 119
}  // TechCommand.java, 122

class Strategy {  // Strategy.java, 6
    private Logger logger = new Logger();  // Strategy.java, 8
    private Station[] myStations = new Station[4];  // Strategy.java, 10
    private Station[] oppStations = new Station[4];  // Strategy.java, 12
    private ArrayList<Planet> planets = new ArrayList<Planet>();  // Strategy.java, 13
    private ArrayList<Bonus> myBonus = new ArrayList<Bonus>();  // Strategy.java, 14
    private ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();  // Strategy.java, 15
    public Strategy(Station[] myStations, Station[] oppStations, ArrayList<Planet> planets, ArrayList<Bonus> myBonus, ArrayList<Bonus> oppBonus) {  // Strategy.java, 17
        this.myStations = myStations;  // Strategy.java, 18
        this.oppStations = oppStations;  // Strategy.java, 19
        this.planets = planets;  // Strategy.java, 20
        this.myBonus = myBonus;  // Strategy.java, 21
        this.oppBonus = oppBonus;  // Strategy.java, 22
    }  // Strategy.java, 23
    public String execute() {  // Strategy.java, 25
        String techResearchBonusPreCommand = applyTechPreCommand();  // Strategy.java, 27
        String cmd;  // Strategy.java, 28
        Distances newDistanceToPlay = null;  // Strategy.java, 29
        ArrayList<Distances> distancesArrayList = computeAllDIstances();  // Strategy.java, 31
        Distances distanceToPlay = getBestTokenUsableFromList(distancesArrayList, myBonus);  // Strategy.java, 32
        logger.println("Distrance To play:" + distanceToPlay.toString());  // Strategy.java, 33
        //is the station to play from a distance point of view available?...  // Strategy.java, 35
        if (distanceToPlay.getStation().isAvailable()) {  // Strategy.java, 36
            //#######################################################################################  // Strategy.java, 37
            // ALLIEN + COLONIZE  // Strategy.java, 38
            cmd = techResearchBonusPreCommand + applyColonizeWithAllienAttempt(myBonus, distanceToPlay);  // Strategy.java, 39
            logger.println("COMMAND1 = " + cmd);  // Strategy.java, 40
            return cmd;  // Strategy.java, 41
        } else {  // Strategy.java, 42
            //... else do we have an avaialble station with the same distance ? if yes, let's colonize with it ....  // Strategy.java, 43
            newDistanceToPlay = getBestTokenUsableFromList(geAvailablesFromList(distancesArrayList), myBonus);  // Strategy.java, 44
            if (newDistanceToPlay != null && newDistanceToPlay.getDisValueStationPlanet() <= distanceToPlay.getDisValueStationPlanet()) {  // Strategy.java, 45
                logger.println("Distance To play (Min Available):" + newDistanceToPlay.toString());  // Strategy.java, 46
                //#######################################################################################  // Strategy.java, 47
                // ALLIEN + COLONIZE (NEXT AVAILABLE STATION IF FIRST IS DISABLED)  // Strategy.java, 48
                cmd = techResearchBonusPreCommand + applyColonizeWithAllienAttempt(myBonus, newDistanceToPlay);  // Strategy.java, 49
                logger.println("COMMAND2 = " + cmd);  // Strategy.java, 50
                return cmd;  // Strategy.java, 51
            }  // Strategy.java, 52
            //... else let's try to apply a bonus to the non available better one  // Strategy.java, 53
            //do we have a ENERGY BONUS to allow resupply and colonize in one shot  // Strategy.java, 54
            //#######################################################################################  // Strategy.java, 55
            // ENERGY +ALLIEN + COLONIZE or RESUPPLY  // Strategy.java, 56
            cmd = techResearchBonusPreCommand + applyEnergyAndColonize_Or_Resupply(myBonus, applyColonizeWithAllienAttempt(myBonus, distanceToPlay));  // Strategy.java, 57
            logger.println("COMMAND3 = " + cmd);  // Strategy.java, 58
            return cmd;  // Strategy.java, 59
        }  // Strategy.java, 61
    }  // Strategy.java, 62
    /**  // Strategy.java, 64
     * compute all needed distances and tokens  // Strategy.java, 65
     *  // Strategy.java, 66
     * @return  // Strategy.java, 67
     */  // Strategy.java, 68
    public ArrayList<Distances> computeAllDIstances() {  // Strategy.java, 69
        ArrayList<Distances> distancesArrayList = new ArrayList<>();  // Strategy.java, 70
        Distances distance;  // Strategy.java, 72
        Distances disMin = null;  // Strategy.java, 73
        for (int i = 0; i < myStations.length; i++) {  // Strategy.java, 75
            for (Planet planet : planets) {  // Strategy.java, 76
                distance = new Distances(myStations[i], planet);  // Strategy.java, 77
                if (distancesArrayList.size() == 0) {  // Strategy.java, 78
                    distancesArrayList.add(distance);  // Strategy.java, 79
                    disMin = distance;  // Strategy.java, 80
                } else {  // Strategy.java, 81
                    if (distance.isSmallerDistanceThan(disMin)) {  // Strategy.java, 82
                        distancesArrayList.clear();  // Strategy.java, 83
                        distancesArrayList.add(distance);  // Strategy.java, 84
                        disMin = distance;  // Strategy.java, 85
                    } else if (distance.isEqualDistanceThan(disMin)) {  // Strategy.java, 86
                        distancesArrayList.add(distance);  // Strategy.java, 87
                    }  // Strategy.java, 88
                }  // Strategy.java, 89
                //logger.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());  // Strategy.java, 90
            }  // Strategy.java, 91
        }  // Strategy.java, 92
        logger.println("Number of min Dist=" + distancesArrayList.size());  // Strategy.java, 94
        return distancesArrayList;  // Strategy.java, 96
    }  // Strategy.java, 97
    /**  // Strategy.java, 99
     * @param distancesArrayList  // Strategy.java, 100
     * @return a list whit only available stations in every distance  // Strategy.java, 101
     */  // Strategy.java, 102
    public ArrayList<Distances> geAvailablesFromList(ArrayList<Distances> distancesArrayList) {  // Strategy.java, 103
        ArrayList<Distances> list = new ArrayList<>();  // Strategy.java, 104
        if (distancesArrayList != null) {  // Strategy.java, 105
            for (Distances distances : distancesArrayList) {  // Strategy.java, 106
                if (distances.getStation().isAvailable()) {  // Strategy.java, 107
                    list.add(distances);  // Strategy.java, 108
                }  // Strategy.java, 109
            }  // Strategy.java, 110
        }  // Strategy.java, 111
        return list;  // Strategy.java, 112
    }  // Strategy.java, 113
    /**  // Strategy.java, 115
     * @param distancesArrayList  // Strategy.java, 116
     * @return the best Distances object (max usage of skills tokens when all distances are equal)  // Strategy.java, 117
     */  // Strategy.java, 118
    public Distances getBestTokenUsableFromList(ArrayList<Distances> distancesArrayList, ArrayList<Bonus> myBonus) {  // Strategy.java, 119
        if (distancesArrayList == null || distancesArrayList.size() == 0) {  // Strategy.java, 120
            return null;  // Strategy.java, 121
        }  // Strategy.java, 122
        Distances prev = null;  // Strategy.java, 123
        Distances cur = null;  // Strategy.java, 124
        for (Distances distances : distancesArrayList) {  // Strategy.java, 125
            if (prev == null) {  // Strategy.java, 126
                prev = distances;  // Strategy.java, 127
                cur = distances;  // Strategy.java, 128
            } else {  // Strategy.java, 129
                if (cur.getUsableToken() > prev.getUsableToken()) {  // Strategy.java, 130
                    prev = cur;  // Strategy.java, 131
                }  // Strategy.java, 132
            }  // Strategy.java, 133
        }  // Strategy.java, 134
        //if same nbr of tokens, chose the station/planet where we can win against the opp  // Strategy.java, 136
        //Build the list of Distances with the same nbr of token to be used  // Strategy.java, 137
        ArrayList<Distances> optimizedForTokenDistances = new ArrayList<Distances>();  // Strategy.java, 138
        for (Distances distances : distancesArrayList) {  // Strategy.java, 139
            if (distances.getUsableToken() == prev.getUsableToken())  // Strategy.java, 140
                optimizedForTokenDistances.add(distances);  // Strategy.java, 141
        }  // Strategy.java, 142
        boolean usedAlienBonus = isAlienTokenElligible(myBonus, optimizedForTokenDistances.get(0));  // Strategy.java, 144
        //if we can be better than the opp let's do it  // Strategy.java, 146
        for (Distances optimDis : optimizedForTokenDistances) {  // Strategy.java, 147
            if (optimDis.willBeBetter(usedAlienBonus))  // Strategy.java, 148
                return optimDis;  // Strategy.java, 149
        }  // Strategy.java, 150
        //if we can complete a colonization and win against the opp at teh same time, let's do it  // Strategy.java, 152
        for (Distances optimDis : optimizedForTokenDistances) {  // Strategy.java, 153
            if (optimDis.willCompleteColonize(usedAlienBonus))  // Strategy.java, 154
                return optimDis;  // Strategy.java, 155
        }  // Strategy.java, 156
        return optimizedForTokenDistances.get(0);  // Strategy.java, 158
    }  // Strategy.java, 159
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  // Strategy.java, 161
    //  // Strategy.java, 162
    //    *****          *****      *       *   *      *       ********  // Strategy.java, 163
    //    *    *        *     *     * *     *   *      *       *  // Strategy.java, 164
    //    *****         *     *     *   *   *   *      *       *  // Strategy.java, 165
    //    *    *        *     *     *     * *   *      *       ********  // Strategy.java, 166
    //    *    *        *     *     *      **   *      *              *  // Strategy.java, 167
    //    *****          *****      *       *   ********       ********  // Strategy.java, 168
    //  // Strategy.java, 169
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  // Strategy.java, 170
    /**  // Strategy.java, 172
     * Try to use the TECH_RESEARCH BONUS  // Strategy.java, 173
     *  // Strategy.java, 174
     * @return  // Strategy.java, 175
     */  // Strategy.java, 176
    public String applyTechPreCommand() {  // Strategy.java, 177
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station  // Strategy.java, 178
        ArrayList<TechCommand> techCommands = new ArrayList<TechCommand>();  // Strategy.java, 179
        List<TechEnum> techEnumList = TechEnum.getAllTechEnum();  // Strategy.java, 180
        for (Bonus bonus : myBonus) {  // Strategy.java, 181
            logger.println(bonus.toString());  // Strategy.java, 182
            // Check that the bonus is a Tech Command  // Strategy.java, 184
            if (BonusType.NEW_TECH.equals(bonus.getBonus()) ||  // Strategy.java, 185
                    BonusType.TECH_RESEARCH_2.equals(bonus.getBonus()) ||  // Strategy.java, 186
                    BonusType.TECH_RESEARCH_3.equals(bonus.getBonus()) ||  // Strategy.java, 187
                    BonusType.TECH_RESEARCH_4.equals(bonus.getBonus())) {  // Strategy.java, 188
                TechCommand bestForObjectiveCandidate = null;  // Strategy.java, 190
                TechCommand defaultCandidate = null;  // Strategy.java, 191
                for (int i = 0; i < myStations.length; i++) {  // Strategy.java, 193
                    Station station = myStations[i];  // Strategy.java, 194
                    TechCommand currentTechCommand = new TechCommand(bonus.getBonus(), station);  // Strategy.java, 195
                    for (TechEnum curTechEnum : techEnumList) {  // Strategy.java, 197
                        if (defaultCandidate == null && currentTechCommand.canApplyTechEnum(curTechEnum)) {  // Strategy.java, 198
                            currentTechCommand.setTechApplying(curTechEnum);  // Strategy.java, 199
                            defaultCandidate = currentTechCommand;  // Strategy.java, 200
                            System.err.println("***Defautl applying Techn Enum to --->" + defaultCandidate);  // Strategy.java, 201
                        }  // Strategy.java, 202
                        if (bestForObjectiveCandidate == null && currentTechCommand.canApplyBestObjectiveTechEnum(curTechEnum)) {  // Strategy.java, 203
                            currentTechCommand.setTechApplying(curTechEnum);  // Strategy.java, 204
                            bestForObjectiveCandidate = currentTechCommand;  // Strategy.java, 205
                            System.err.println("***Best applying Techn Enum to --->" + bestForObjectiveCandidate);  // Strategy.java, 206
                        }  // Strategy.java, 207
                    }  // Strategy.java, 208
                }  // Strategy.java, 209
                logger.println("--->Found best " + bestForObjectiveCandidate);  // Strategy.java, 211
                logger.println("--->Default " + defaultCandidate);  // Strategy.java, 212
                // Now I will add either the best to fulfill  // Strategy.java, 214
                if (bestForObjectiveCandidate != null) {  // Strategy.java, 215
                    bestForObjectiveCandidate.apply();  // Strategy.java, 216
                    techCommands.add(bestForObjectiveCandidate);  // Strategy.java, 217
                    logger.println("      BestObjectiveCandidate for Bonus " + bestForObjectiveCandidate.toString());  // Strategy.java, 218
                } else if (defaultCandidate != null) {  // Strategy.java, 219
                    defaultCandidate.apply();  // Strategy.java, 220
                    techCommands.add(defaultCandidate);  // Strategy.java, 221
                    logger.println("      Default Candidate for Bonus " + defaultCandidate.toString());  // Strategy.java, 222
                } else {  // Strategy.java, 223
                    logger.println("The Bonus is not applicable " + bonus.toString());  // Strategy.java, 224
                }  // Strategy.java, 225
            }  // Strategy.java, 226
        }  // Strategy.java, 227
        String command = "";  // Strategy.java, 229
        if (techCommands.isEmpty()) {  // Strategy.java, 230
            for (TechCommand techCommand : techCommands) {  // Strategy.java, 231
                command = techCommand.executeCommand();  // Strategy.java, 232
            }  // Strategy.java, 233
        }  // Strategy.java, 234
        logger.println("PreCommand = " + command);  // Strategy.java, 236
        return command;  // Strategy.java, 237
    }  // Strategy.java, 238
    /**  // Strategy.java, 240
     * ENERGY BONUS AND COLONIZE (BUILT FROM OUTSIDE AND PASSED)  // Strategy.java, 241
     *  // Strategy.java, 242
     * @param myBonus  // Strategy.java, 243
     * @param colonizeAction  // Strategy.java, 244
     * @return  // Strategy.java, 245
     */  // Strategy.java, 246
    public String applyEnergyAndColonize_Or_Resupply(ArrayList<Bonus> myBonus, String colonizeAction) {  // Strategy.java, 247
        if (BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus)) {  // Strategy.java, 248
            return BonusType.ENERGY_CORE + " " + colonizeAction;  // Strategy.java, 249
        } else {  // Strategy.java, 250
            //no choice  // Strategy.java, 251
            return "RESUPPLY";  // Strategy.java, 252
        }  // Strategy.java, 253
    }  // Strategy.java, 254
    /**  // Strategy.java, 256
     * ALIEN AND BUILD COLONIZE  // Strategy.java, 257
     *  // Strategy.java, 258
     * @param myBonus  // Strategy.java, 259
     * @param distanceToPlay  // Strategy.java, 260
     * @return  // Strategy.java, 261
     */  // Strategy.java, 262
    public String applyColonizeWithAllienAttempt(ArrayList<Bonus> myBonus, Distances distanceToPlay) {  // Strategy.java, 263
        String prefixAllien = "";  // Strategy.java, 264
        if (isAlienTokenElligible(myBonus, distanceToPlay)) {  // Strategy.java, 265
            int bonusCounter = 2;  // Strategy.java, 266
            int[] tasks = new int[2];  // Strategy.java, 267
            int currentTerraValue = 0;  // Strategy.java, 268
            if (distanceToPlay.getValueTerraformingStationPlanet() != null)  // Strategy.java, 269
                currentTerraValue = distanceToPlay.getValueTerraformingStationPlanet();  // Strategy.java, 270
            int currentAllienValue = 0;  // Strategy.java, 272
            if (distanceToPlay.getValueAlienStationPlanet() != null)  // Strategy.java, 273
                currentAllienValue = distanceToPlay.getValueAlienStationPlanet();  // Strategy.java, 274
            int currentEngValue = 0;  // Strategy.java, 276
            if (distanceToPlay.getValueEngineeringStationPlanet() != null)  // Strategy.java, 277
                currentEngValue = distanceToPlay.getValueEngineeringStationPlanet();  // Strategy.java, 278
            int currentAgriValue = 0;  // Strategy.java, 280
            if (distanceToPlay.getValueAgricultureStationPlanet() != null)  // Strategy.java, 281
                currentAgriValue = distanceToPlay.getValueAgricultureStationPlanet();  // Strategy.java, 282
            while (currentTerraValue >= 1 && bonusCounter > 0) {  // Strategy.java, 284
                tasks[tasks.length - bonusCounter] = 0; //0 for terra  // Strategy.java, 285
                bonusCounter--;  // Strategy.java, 286
                currentTerraValue--;  // Strategy.java, 287
            }  // Strategy.java, 288
            while (currentAllienValue >= 1 && bonusCounter > 0) {  // Strategy.java, 289
                tasks[tasks.length - bonusCounter] = 1; //0 for allien  // Strategy.java, 290
                bonusCounter--;  // Strategy.java, 291
                currentAllienValue--;  // Strategy.java, 292
            }  // Strategy.java, 293
            while (currentEngValue >= 1 && bonusCounter > 0) {  // Strategy.java, 294
                tasks[tasks.length - bonusCounter] = 2; //0 for eng  // Strategy.java, 295
                bonusCounter--;  // Strategy.java, 296
                currentEngValue--;  // Strategy.java, 297
            }  // Strategy.java, 298
            while (currentAgriValue >= 1 && bonusCounter > 0) {  // Strategy.java, 299
                tasks[tasks.length - bonusCounter] = 3; //0 for agri  // Strategy.java, 300
                bonusCounter--;  // Strategy.java, 301
                currentAgriValue--;  // Strategy.java, 302
            }  // Strategy.java, 303
            prefixAllien += BonusType.ALIEN_ARTIFACT + " " + tasks[0] + " " + tasks[1] + " ";  // Strategy.java, 306
        }  // Strategy.java, 307
        String colonizeAction = "COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus(myBonus);  // Strategy.java, 309
        return prefixAllien + colonizeAction;  // Strategy.java, 310
    }  // Strategy.java, 311
    //this method is called twice : applyColonizeWithAllienAttempt and execute to tune best token  // Strategy.java, 313
    public Boolean isAlienTokenElligible(ArrayList<Bonus> myBonus, Distances distanceToPlay) {  // Strategy.java, 314
        return distanceToPlay.getDisValueStationPlanet() >= 2 && BonusType.ALIEN_ARTIFACT.isBonusAvailableInList(myBonus);  // Strategy.java, 315
    }  // Strategy.java, 316
/*  // Strategy.java, 318
    public static void main(String[] args) {  // Strategy.java, 319
        Station myStation1 = new Station(1, 1);  // Strategy.java, 320
        myStation1.setTechLevel(2, 2, 0, 0);  // Strategy.java, 321
        myStation1.setAvailable(1);  // Strategy.java, 322
        Station myStation2 = new Station(2, 1);  // Strategy.java, 324
        myStation2.setTechLevel(2, 2, 0, 0);  // Strategy.java, 325
        myStation2.setAvailable(1);  // Strategy.java, 326
        Station oppStation = new Station(2, 0);  // Strategy.java, 328
        oppStation.setTechLevel(1, 1, 1, 1);  // Strategy.java, 329
        Planet myPlanet1 = new Planet(1, 3, 3, 0, 0, 1, 0, 2, "ENERGY_CORE", "POINTS_3");  // Strategy.java, 331
        Planet myPlanet2 = new Planet(2, 3, 3, 0, 0, 0, 1, 2, "ENERGY_CORE", "POINTS_3");  // Strategy.java, 332
        Planet myPlanet3 = new Planet(2, 3, 3, 0, 0, 0, 1, 2, "ENERGY_CORE", "POINTS_3");  // Strategy.java, 333
        Station[] myStations = new Station[2];  // Strategy.java, 335
        Station[] oppStations = new Station[1];  // Strategy.java, 336
        ArrayList<Planet> planets = new ArrayList<Planet>();  // Strategy.java, 337
        myStations[0] = myStation1;  // Strategy.java, 339
        myStations[1] = myStation2;  // Strategy.java, 340
        oppStations[0] = oppStation;  // Strategy.java, 341
        planets.add(myPlanet1);  // Strategy.java, 342
        planets.add(myPlanet2);  // Strategy.java, 343
        ArrayList<Bonus> myBonus = new ArrayList<Bonus>();  // Strategy.java, 345
        myBonus.add(new Bonus("NEW_TECH"));  // Strategy.java, 346
        Strategy strategy = new Strategy(myStations, oppStations, planets, myBonus, null);  // Strategy.java, 348
        strategy.applyTechPreCommand();  // Strategy.java, 349
    }*/  // Strategy.java, 350
}  // Strategy.java, 354

enum TechEnum {  // TechEnum.java, 6
    TERRAFORMING,  // TechEnum.java, 7
    ALIEN,  // TechEnum.java, 8
    ENGINEERING,  // TechEnum.java, 9
    AGRICULTURE;  // TechEnum.java, 10
    public static int getCode(TechEnum techEnum){  // TechEnum.java, 13
        if(TERRAFORMING.equals(techEnum)){  // TechEnum.java, 14
            return 0;  // TechEnum.java, 15
        }else if(ALIEN.equals(techEnum)){  // TechEnum.java, 16
            return 1;  // TechEnum.java, 17
        }else if (ENGINEERING.equals(techEnum)){  // TechEnum.java, 18
            return 2;  // TechEnum.java, 19
        }else{  // TechEnum.java, 20
            return 3;  // TechEnum.java, 21
        }  // TechEnum.java, 22
    }  // TechEnum.java, 23
    public static List<TechEnum> getAllTechEnum(){  // TechEnum.java, 25
        List<TechEnum> list = new ArrayList<TechEnum>();  // TechEnum.java, 26
        list.add(TERRAFORMING);  // TechEnum.java, 27
        list.add(ALIEN);  // TechEnum.java, 28
        list.add(ENGINEERING);  // TechEnum.java, 29
        list.add(AGRICULTURE);  // TechEnum.java, 30
        return list;  // TechEnum.java, 31
    }  // TechEnum.java, 32
}  // TechEnum.java, 33

class Logger {  // Logger.java, 3
    private boolean logActivasted = true;  // Logger.java, 5
    public void println(String log){  // Logger.java, 7
        if(logActivasted){  // Logger.java, 8
            System.err.println(log);  // Logger.java, 9
        }  // Logger.java, 10
    }  // Logger.java, 11
    public void print(String log){  // Logger.java, 13
        if(logActivasted){  // Logger.java, 14
            System.err.print(log);  // Logger.java, 15
        }  // Logger.java, 16
    }  // Logger.java, 17
}  // Logger.java, 18

class Main {  // Main.java, 6
    Logger logger = new Logger();  // Main.java, 8
    Station[] myStations = new Station[4];  // Main.java, 9
    Station[] oppStations = new Station[4];  // Main.java, 10
    ArrayList<Planet> planets = new ArrayList<Planet>();  // Main.java, 11
    ArrayList<Bonus> myBonus = new ArrayList<Bonus>();  // Main.java, 12
    ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();  // Main.java, 13
    Strategy strategy = new Strategy(myStations,oppStations,planets, myBonus, oppBonus);  // Main.java, 15
    public Main(String[] args) {  // Main.java, 17
        Scanner in = new Scanner(System.in);  // Main.java, 18
        int myCounter = 0;  // Main.java, 20
        int oppCounter = 0;  // Main.java, 21
        for (int i = 0; i < 8; i++) {  // Main.java, 22
            int stationId = in.nextInt();  // Main.java, 23
            int mine = in.nextInt();  // Main.java, 24
            int objectiveScore = in.nextInt(); // receive these points if tech level objectives are met  // Main.java, 25
            int obj0 = in.nextInt();  // Main.java, 26
            int obj1 = in.nextInt();  // Main.java, 27
            int obj2 = in.nextInt();  // Main.java, 28
            int obj3 = in.nextInt();  // Main.java, 29
            StationObjective sto = new StationObjective(objectiveScore, obj0, obj1, obj2, obj3);  // Main.java, 31
            Station st = new Station(stationId, mine);  // Main.java, 32
            st.myStationObj = sto;  // Main.java, 33
            if (st.isMine() == 1) {  // Main.java, 35
                myStations[myCounter] = st;  // Main.java, 36
                myCounter++;  // Main.java, 37
            } else {  // Main.java, 38
                oppStations[oppCounter] = st;  // Main.java, 39
                oppCounter++;  // Main.java, 40
            }  // Main.java, 41
        }  // Main.java, 43
        // game loop  // Main.java, 45
        while (true) {  // Main.java, 46
            int sectorIndex = in.nextInt();  // Main.java, 47
            for (int i = 0; i < 8; i++) {  // Main.java, 48
                int stationId = in.nextInt();  // Main.java, 49
                int mine = in.nextInt();  // Main.java, 50
                int available = in.nextInt();  // Main.java, 51
                int tech0 = in.nextInt();  // Main.java, 52
                int tech1 = in.nextInt();  // Main.java, 53
                int tech2 = in.nextInt();  // Main.java, 54
                int tech3 = in.nextInt();  // Main.java, 55
                Station currentSt = getStationById(myStations,oppStations, stationId);  // Main.java, 57
                currentSt.setTechLevel(tech0, tech1, tech2, tech3);  // Main.java, 58
                currentSt.setAvailable(available);  // Main.java, 59
            }  // Main.java, 60
            // re-init planet  // Main.java, 62
            planets.clear();  // Main.java, 63
            int planetCount = in.nextInt();  // Main.java, 65
            for (int i = 0; i < planetCount; i++) {  // Main.java, 66
                int planetId = in.nextInt();  // Main.java, 67
                int tasks0 = in.nextInt();  // Main.java, 68
                int tasks1 = in.nextInt();  // Main.java, 69
                int tasks2 = in.nextInt();  // Main.java, 70
                int tasks3 = in.nextInt();  // Main.java, 71
                int myContribution = in.nextInt(); // the amount of tasks you have already completed  // Main.java, 72
                int oppContribution = in.nextInt();  // Main.java, 73
                int colonizationScore = in.nextInt(); // points awarded to the colonizer having completed the most tasks  // Main.java, 74
                String bonus0 = in.next();  // Main.java, 75
                String bonus1 = in.next();  // Main.java, 76
                Planet p = new Planet(planetId, tasks0, tasks1, tasks2, tasks3, myContribution, oppContribution, colonizationScore, bonus0, bonus1);  // Main.java, 78
                planets.add(p);  // Main.java, 79
            }  // Main.java, 81
            // Reinit  // Main.java, 83
            oppBonus.clear();  // Main.java, 84
            myBonus.clear();  // Main.java, 85
            int bonusCount = in.nextInt(); // bonuses in both you and your opponent's inventories  // Main.java, 86
            for (int i = 0; i < bonusCount; i++) {  // Main.java, 87
                int mine = in.nextInt();  // Main.java, 88
                String bonus = in.next();  // Main.java, 89
                Bonus bon = new Bonus(bonus);  // Main.java, 90
                logger.println("mine=" + mine+ ", Bonus="+bonus);  // Main.java, 91
                if(mine == 1){  // Main.java, 92
                    myBonus.add(bon);  // Main.java, 93
                }else{  // Main.java, 94
                    oppBonus.add(bon);  // Main.java, 95
                }  // Main.java, 96
            }  // Main.java, 97
            int myColonizationScore = in.nextInt(); // points from planet colonization, does not include bonus points  // Main.java, 98
            int oppColonizationScore = in.nextInt();  // Main.java, 99
            // Write an action using System.out.println()  // Main.java, 101
            // To debug: logger.println("Debug messages...");  // Main.java, 102
            //printMyStations(myStations);  // Main.java, 104
            //printOppStations(oppStations);  // Main.java, 105
            //printPlanets(planets);  // Main.java, 106
            String execute =  strategy.execute();  // Main.java, 107
            logger.println("Command = "+ execute);  // Main.java, 108
            System.out.println(execute);  // Main.java, 109
        }  // Main.java, 110
    }  // Main.java, 111
    public Station getStationById(Station[] myStations, Station[] oppStations, int id)  // Main.java, 113
    {  // Main.java, 114
        for (int i=0;i<=3;i++)  // Main.java, 115
        {  // Main.java, 116
            if (id==myStations[i].stationId)  // Main.java, 117
                return myStations[i];  // Main.java, 118
        }  // Main.java, 119
        for (int i=0;i<=3;i++)  // Main.java, 120
        {  // Main.java, 121
            if (id==oppStations[i].stationId)  // Main.java, 122
                return oppStations[i];  // Main.java, 123
        }  // Main.java, 124
        return null;  // Main.java, 126
    }  // Main.java, 127
    public void printMyStations(Station[] myStations)  // Main.java, 129
    {  // Main.java, 130
        for (int i=0;i<4;i++)  // Main.java, 131
        {  // Main.java, 132
            logger.println(myStations[i].toString());  // Main.java, 133
            //logger.println("my Station " + myStations[i].stationId + " available=" + myStations[i].isAvailable + " tech1" + myStations[i].terraformingSkill + " tech2" + myStations[i].alienSkill + " tech3" + myStations[i].engineeringSkill + " tech4" + myStations[i].agricultureSkill);  // Main.java, 134
            //logger.println("  obj score = " + myStations[i].myStationObj.scoreIfReached + " obj terra=" + myStations[i].myStationObj.terraLevelObj +   " obj alien=" + myStations[i].myStationObj.alienLevelObj);  // Main.java, 135
        }  // Main.java, 136
    }  // Main.java, 137
    public void printOppStations(Station[] oppStations)  // Main.java, 139
    {  // Main.java, 140
        for (int i=0;i<4;i++)  // Main.java, 141
        {  // Main.java, 142
            logger.println(oppStations[i].toString());  // Main.java, 143
            //logger.println("opp Station " + oppStations[i].stationId + " available=" + oppStations[i].isAvailable + " tech1" + oppStations[i].terraformingSkill + " tech2" + oppStations[i].alienSkill + " tech3" + oppStations[i].engineeringSkill + " tech4" + oppStations[i].agricultureSkill);  // Main.java, 144
        }  // Main.java, 145
    }  // Main.java, 146
    public void printPlanets(Planet[] planets)  // Main.java, 148
    {  // Main.java, 149
        for (int i=0;i<5;i++)  // Main.java, 150
        {  // Main.java, 151
            logger.println(planets[i].toString());  // Main.java, 152
            //logger.println("Planet "  + planets[i].planetId + " task1" + planets[i].terraformingTaskLeftValue + " task2" + planets[i].alienTaskLeftValue + " task3" + planets[i].engineeringTaskLeftValue + " task4" + planets[i].agricultureTaskLeftValue);  // Main.java, 153
            //logger.println("     myContribution=" + planets[i].myContributionTotalTaks + " oppContribution=" + planets[i].oppContributionTotalTasks + " score=" + planets[i].colonizationScore + " bonus0="+ planets[i].bonus0 + " bonus1=" + planets[i].bonus1);  // Main.java, 154
        }  // Main.java, 155
    }  // Main.java, 156
}  // Main.java, 157

public static void main(String[] args) { (new Player()).new Main(args); }
}