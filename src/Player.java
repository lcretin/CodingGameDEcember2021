/*
This file has been generated Fri Dec 03 13:36:30 CET 2021
*/

import java.util.List;import java.util.Scanner;import java.util.ArrayList;
class Player {
//import java.util.ArrayList;
class Distances {
    private Logger logger = new Logger();
    private Station station;
    private Planet planet;
    private Integer disValueStationPlanet = null;
    private Integer disValueTerraforming = null;
    private Integer disValueAlien = null;
    private Integer disValueEngineering = null;
    private Integer disValueAgriculture = null;
    private Integer usableToken = null;
    private Integer usableTokenTerraforming = null;
    private Integer usableTokenAlien = null;
    private Integer usableTokenEngineering = null;
    private Integer usableTokenAgriculture = null;
    private Integer disToStationObjective = null;
    public Distances(Station station, Planet planet){
        this.station = station;
        this.planet = planet; 
        this.compute();
        this.computeDisToObjective();
    }
    public void compute(){
        Integer result = null;
        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getTerraformingTaskLeftValue() != 0 ) {
            disValueTerraforming = this.planet.getTerraformingTaskLeftValue() - this.station.getTerraformingSkill();
            usableTokenTerraforming = Math.min(this.planet.getTerraformingTaskLeftValue(), this.station.getTerraformingSkill());
            if(disValueTerraforming < 0){
                disValueTerraforming = 0;
            }
            if(result == null){
                result = disValueTerraforming;
                usableToken = usableTokenTerraforming;
            }
        }
        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getAlienTaskLeftValue() != 0 ) {
            disValueAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();
            usableTokenAlien = Math.min(this.planet.getAlienTaskLeftValue(), this.station.getAlienSkill());
            if(disValueAlien < 0){
                disValueAlien = 0;
            }
            if(result == null){
                result = disValueAlien;
                usableToken = usableTokenAlien;
            }else{
                result += disValueAlien;
                usableToken += usableTokenAlien;
            }
        }
        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getEngineeringTaskLeftValue() != 0 ) {
            disValueEngineering = this.planet.getEngineeringTaskLeftValue() - this.station.getEngineeringSkill();
            usableTokenEngineering = Math.min(this.planet.getEngineeringTaskLeftValue(), this.station.getEngineeringSkill());
            if(disValueEngineering < 0){
                disValueEngineering = 0;
            }
            if(result == null){
                result = disValueEngineering;
                usableToken = usableTokenEngineering;
            }else{
                result += disValueEngineering;
                usableToken += usableTokenEngineering;
            }
        }
        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getAgricultureTaskLeftValue() != 0 ) {
            disValueAgriculture= this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();
            usableTokenAgriculture = Math.min(this.planet.getAgricultureTaskLeftValue(), this.station.getAgricultureSkill());
            if(disValueAgriculture < 0){
                disValueAgriculture = 0;
            }
            if(result == null){
                result = disValueAgriculture;
                usableToken = usableTokenAgriculture;
            }else{
                result += disValueAgriculture;
                usableToken += usableTokenAgriculture;
            }
        }
       this.disValueStationPlanet = result;
    }
    public void computeDisToObjective()
    {
        Integer curDistanceToObjective = 0;
        if (this.station.myStationObj.terraLevelObj > this.station.terraformingSkill)
            curDistanceToObjective+= this.station.myStationObj.terraLevelObj - this.station.terraformingSkill;
        if (this.station.myStationObj.alienLevelObj > this.station.alienSkill)
            curDistanceToObjective+= this.station.myStationObj.alienLevelObj - this.station.alienSkill;  
        if (this.station.myStationObj.engineeringLevelObj > this.station.engineeringSkill)
            curDistanceToObjective+= this.station.myStationObj.engineeringLevelObj - this.station.engineeringSkill;
        if (this.station.myStationObj.agricultureLevelObj > this.station.agricultureSkill)
            curDistanceToObjective+= this.station.myStationObj.agricultureLevelObj - this.station.agricultureSkill;  
        this.disToStationObjective = curDistanceToObjective;
    }
    public boolean isSmallerDistanceThan(Distances distances){
        return distances == null || (distances.disValueStationPlanet != null && this.disValueStationPlanet < distances.disValueStationPlanet);
    }
    public boolean isEqualDistanceThan(Distances distances){
        return distances != null && distances.disValueStationPlanet != null && this.disValueStationPlanet == distances.disValueStationPlanet;
    }
    public Distances getSmallerDistance(Distances distances){
           if(this.isSmallerDistanceThan(distances)){
               return this;
           }else{
               return distances;
           }
    }
    public Distances getSmallerAvailableDistance(Distances distances){
        if(this.isSmallerDistanceThan(distances) && this.getStation().isAvailable()){
            return this;
        }else{
            return distances;
        }
    }
    public Station getStation() {
        return station;
    }
    public Planet getPlanet() {
        return planet;
    }
    public int getDisValueStationPlanet() {
        return disValueStationPlanet;
    }
    public Integer getValueTerraformingStationPlanet(){
        return disValueTerraforming;
    }
    public Integer getValueAlienStationPlanet(){
        return disValueAlien;
    }
    public Integer getValueEngineeringStationPlanet(){
        return disValueEngineering;
    }
    public Integer getValueAgricultureStationPlanet(){
        return disValueAgriculture;
    }
    public Integer getUsableToken() {
        return usableToken;
    }
    public Integer getDistanceToObjective(){
        return disToStationObjective;
    }
    /**
     * @return true if we will win against the opponant
     */
    public boolean willBeBetter (boolean withAlienBonus) {
        int extraToken = 0;
        if (withAlienBonus)
            extraToken=2;
        if (planet.myContributionTotalTaks < planet.oppContributionTotalTasks 
            && (planet.myContributionTotalTaks + usableToken + extraToken >= planet.oppContributionTotalTasks))
            {
                logger.println("we will be better than opp on planet " + planet.planetId + " alien bonus =" + extraToken);
                return true;
            }
        return false;
    }
    /**
     * @return true if we will finish the colonization of this planet
     */
    public boolean willCompleteColonize (boolean withAlienBonus) {
        int extraToken = 0;
        if (withAlienBonus)
            extraToken=2;
        if (usableToken + extraToken >= disValueStationPlanet)
         {
            logger.println("we will be complete the colonization of planet " + planet.planetId + " alien bonus =" + extraToken);
            return true;
         }
        return false;
    }
    @Override
    public String toString() {
        return "Distances{\n" +
                "    station=" + station + "\n" +
                "    planet=" + planet + "\n" +
                "    distance Value=" + disValueStationPlanet +
                ", [" + disValueTerraforming +
                ", " + disValueAlien +
                ", " + disValueEngineering +
                ", " + disValueAgriculture + "]\n" +
                "    usableToken=" + usableToken +
                ", [" + usableTokenTerraforming +
                ", " + usableTokenAlien +
                ", " + usableTokenEngineering +
                ", " + usableTokenAgriculture +
                "]\n}";
    }
}

enum BonusType {
    ENERGY_CORE("ENERGY_CORE"),
    TECH_RESEARCH_2("TECH_RESEARCH_2"),
    TECH_RESEARCH_3("TECH_RESEARCH_3"),
    TECH_RESEARCH_4("TECH_RESEARCH_4"),
    NEW_TECH("NEW_TECH"),
    POINTS_1("POINTS_1"),
    POINTS_2("POINTS_2"),
    POINTS_3("POINTS_3"),
    ALIEN_ARTIFACT("ALIEN_ARTIFACT");
    private String bonusValue;
    BonusType(String bonusValue) {
        this.bonusValue = bonusValue;
    }
    @Override
    public String toString() {
        return  bonusValue ;
    }
    public String getBonusValue() {
        return bonusValue;
    }
    public boolean isBonusAvailableInList(ArrayList<Bonus> myBonus) {
        if (myBonus == null) {
            return false;
        }
        for (Bonus bonus : myBonus) {
            if (this.equals(bonus.getBonus())) {
                return true;
            }
        }
        return false;
    }
}

class StationObjective {
    int scoreIfReached;
    int terraLevelObj;
    int alienLevelObj;
    int engineeringLevelObj;
    int agricultureLevelObj;
    public StationObjective(int score,int obj0, int obj1, int obj2, int obj3)
    {
        this.scoreIfReached=score;
        this.terraLevelObj=obj0;
        this.alienLevelObj=obj1;
        this.engineeringLevelObj=obj2;
        this.agricultureLevelObj=obj3;
    }
    @Override
    public String toString() {
        return "StationObj{" +
                "Score=" + scoreIfReached +
                ", Level=[" + terraLevelObj +
                ", " + alienLevelObj +
                ", " + engineeringLevelObj +
                ", " + agricultureLevelObj +
                "]}";
    }
}

class Planet {
    int planetId;
    //left to complete
    int terraformingTaskLeftValue;
    int alienTaskLeftValue;
    int engineeringTaskLeftValue;
    int agricultureTaskLeftValue;
    int myContributionTotalTaks;
    int oppContributionTotalTasks;
    int colonizationScore;
    String bonus0;
    String bonus1;
    public Planet(int id, int tValue, int alValue, int eValue, int agValue, int myC, int oppC, int coloScore,String bonus0, String bonus1)
    {
        this.planetId=id;
        this.terraformingTaskLeftValue =tValue;
        this.alienTaskLeftValue =alValue;
        this.engineeringTaskLeftValue =eValue;
        this.agricultureTaskLeftValue =agValue;
        this.myContributionTotalTaks = myC;
        this.oppContributionTotalTasks=oppC;
        this.colonizationScore=coloScore;
        this.bonus0=bonus0;
        this.bonus1=bonus1;
    }
    public int getPlanetId() {
        return planetId;
    }
    public int getTerraformingTaskLeftValue() {
        return terraformingTaskLeftValue;
    }
    public int getAlienTaskLeftValue() {
        return alienTaskLeftValue;
    }
    public int getEngineeringTaskLeftValue() {
        return engineeringTaskLeftValue;
    }
    public int getAgricultureTaskLeftValue() {
        return agricultureTaskLeftValue;
    }
    public int getMyContributionTotalTaks() {
        return myContributionTotalTaks;
    }
    public int getOppContributionTotalTasks() {
        return oppContributionTotalTasks;
    }
    public int getColonizationScore() {
        return colonizationScore;
    }
    public String getBonus0() {
        return bonus0;
    }
    public String getBonus1() {
        return bonus1;
    }
    public String getBestBonus(ArrayList<Bonus> myBonus){
        //let's take the points first
        if (BonusType.POINTS_3.toString().equals(this.bonus0))
            return "0";
        if (BonusType.POINTS_3.toString().equals(this.bonus1))
            return "1";
        if (BonusType.POINTS_2.toString().equals(this.bonus0))
            return "0";
        if (BonusType.POINTS_2.toString().equals(this.bonus1))
            return "1";
        if (BonusType.POINTS_1.toString().equals(this.bonus0))
            return "0";
        if (BonusType.POINTS_1.toString().equals(this.bonus1))
            return "1";
        //then the energy
        if (BonusType.ENERGY_CORE.toString().equals(this.bonus0) && !BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus))
            return "0";
        if (BonusType.ENERGY_CORE.toString().equals(this.bonus1) && !BonusType.ENERGY_CORE.isBonusAvailableInList(myBonus))
            return "1";
        //then the TECH TODO to be customized with station obj
        if (BonusType.NEW_TECH.toString().equals(this.bonus0))
            return "0";
        if (BonusType.NEW_TECH.toString().equals(this.bonus1))
            return "1";
        if (BonusType.TECH_RESEARCH_2.toString().equals(this.bonus0))
            return "0";
        if (BonusType.TECH_RESEARCH_2.toString().equals(this.bonus1))
            return "1";
        if (BonusType.TECH_RESEARCH_3.toString().equals(this.bonus0))
            return "0";
        if (BonusType.TECH_RESEARCH_3.toString().equals(this.bonus1))
            return "1";
            if (BonusType.TECH_RESEARCH_4.toString().equals(this.bonus0))
            return "0";
        if (BonusType.TECH_RESEARCH_4.toString().equals(this.bonus1))
            return "1";
        if (BonusType.ALIEN_ARTIFACT.toString().equals(this.bonus0))
            return "0";
        if (BonusType.ALIEN_ARTIFACT.toString().equals(this.bonus1))
            return "1";
        return "0";
    }
    @Override
    public String toString() {
        return "Planet{" + planetId +
                ", [" + terraformingTaskLeftValue +
                ", " + alienTaskLeftValue +
                ", " + engineeringTaskLeftValue +
                ", " + agricultureTaskLeftValue +
                "], myContributionTotalTaks=" + myContributionTotalTaks +
                ", oppContributionTotalTasks=" + oppContributionTotalTasks +
                ", colonizationScore=" + colonizationScore +
                ", bonus=[" + bonus0 +
                ", " + bonus1 + "]}";
    }
}

class Station {
    int stationId;
    int isMine;
    int isAvailable;
    //tech values
    int terraformingSkill;
    int alienSkill;
    int engineeringSkill;
    int agricultureSkill;
    StationObjective myStationObj;
    //constructor
    public Station(int id,int isMine)
    {
        this.stationId=id;
        this.isMine=isMine;
    }
    public void setTechLevel(int tValue,int alValue,int eValue,int agValue)
    {
        this.terraformingSkill =tValue;
        this.alienSkill =alValue;
        this.engineeringSkill =eValue;
        this.agricultureSkill =agValue;
    }
    public void setAvailable(int available)
    {
        this.isAvailable=available;
    }
    public int isMine()
    {
        return isMine;
    }
    public boolean isAvailable()
    {
        return isAvailable==1;
    }
    public void setObjective(StationObjective stO)
    {
        this.myStationObj=stO;
    }
    public int getStationId() {
        return stationId;
    }
    public int getIsMine() {
        return isMine;
    }
    public int getIsAvailable() {
        return isAvailable;
    }
    public int getTerraformingSkill() {
        return terraformingSkill;
    }
    public int getAlienSkill() {
        return alienSkill;
    }
    public int getEngineeringSkill() {
        return engineeringSkill;
    }
    public int getAgricultureSkill() {
        return agricultureSkill;
    }
    public StationObjective getMyStationObj() {
        return myStationObj;
    }
    public boolean isTerraformingObjectiveReached() {
        if (myStationObj != null && terraformingSkill >= myStationObj.terraLevelObj)
            return true;
        return false;
    }
    public boolean isAlienObjectiveReached() {
        if (myStationObj != null && alienSkill >= myStationObj.alienLevelObj)
            return true;
        return false;
    }
    public boolean isEngineeringObjectiveReached() {
        if (myStationObj != null && engineeringSkill >= myStationObj.engineeringLevelObj)
            return true;
        return false;
    }
    public boolean isAgricultureObjectiveReached() {
    if (myStationObj != null && agricultureSkill >= myStationObj.agricultureLevelObj)
        return true;
    return false;
    }
    public String toString() {
        return "Station{" +
                "" + stationId +
                ", mine=" + isMine +
                ", avail=" + isAvailable +
                ", skill=[" + terraformingSkill +
                ", " + alienSkill +
                ", " + engineeringSkill +
                ", " + agricultureSkill +
                "], " + myStationObj +
                "}";
    }
}

class Bonus {
    private BonusType bonus;
    public Bonus(String bonus) {
        this.bonus = BonusType.valueOf(bonus);
    }
    public BonusType getBonus() {
        return bonus;
    }
    @Override
    public String toString() {
        return "Bonus{" + bonus +
                '}';
    }
}

class TechCommand {
    private BonusType bonusType;
    private Station station;
    private TechEnum techApplying;
    // Contains the expected tech value for the tech enum. Meaning TECH_RESEARCH_2 -> newTechValue is 2
    // NEW_TECH value is 1
    private int newTechValue;
    private String commandName;
    private String suffix = "";
    public TechCommand(BonusType bonusType, Station station) {
        this.bonusType = bonusType;
        this.station = station;
        commandName = "";
        if (BonusType.NEW_TECH.equals(bonusType)) {
            this.newTechValue = 1;
            commandName = "NEW_TECH ";
        } else if (BonusType.TECH_RESEARCH_2.equals(bonusType)) {
            this.newTechValue = 2;
            commandName = "TECH_RESEARCH ";
        } else if (BonusType.TECH_RESEARCH_3.equals(bonusType)) {
            this.newTechValue = 3;
            commandName = "TECH_RESEARCH ";
        }
        if (BonusType.TECH_RESEARCH_4.equals(bonusType)) {
            this.newTechValue = 4;
            commandName = "TECH_RESEARCH ";
        }
    }
    public boolean canApplyTechEnum(TechEnum techApplying) {
        if (TechEnum.TERRAFORMING.equals(techApplying)) {
            if (station.getTerraformingSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ALIEN.equals(techApplying)) {
            if (station.getAlienSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ENGINEERING.equals(techApplying)) {
            if (station.getEngineeringSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.AGRICULTURE.equals(techApplying)) {
            if (station.getAgricultureSkill() == this.newTechValue - 1) {
                return true;
            }
        }
        return false;
    }
    public boolean canApplyBestObjectiveTechEnum(TechEnum techApplying) {
       // System.err.println(station.isTerraformingObjectiveReached());
        if (TechEnum.TERRAFORMING.equals(techApplying) && !station.isTerraformingObjectiveReached()) {
            if (station.getTerraformingSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ALIEN.equals(techApplying) && !station.isAlienObjectiveReached()) {
            if (station.getAlienSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ENGINEERING.equals(techApplying) && !station.isEngineeringObjectiveReached()) {
            if (station.getEngineeringSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.AGRICULTURE.equals(techApplying) && !station.isAgricultureObjectiveReached()) {
            if (station.getAgricultureSkill() == this.newTechValue - 1) {
                return true;
            }
        }
        return false;
    }
    public void setTechApplying(TechEnum techApplying) {
        this.techApplying = techApplying;
    }
    public void setBonusType(BonusType bonusType) {
        if(BonusType.NEW_TECH.equals(this.bonusType)){
            suffix = " " + bonusType.getBonusValue();
        }
        this.bonusType = bonusType;
    }
    public TechCommand apply() {
        if(this.techApplying != null) {
            if (TechEnum.TERRAFORMING.equals(techApplying)) {
                station.terraformingSkill = this.newTechValue;
            } else if (TechEnum.ALIEN.equals(techApplying)) {
                station.alienSkill = this.newTechValue;
            } else if (TechEnum.ENGINEERING.equals(techApplying)) {
                station.engineeringSkill = this.newTechValue;
            } else if (TechEnum.AGRICULTURE.equals(techApplying)) {
                station.agricultureSkill = this.newTechValue;
            }
        }
        return this;
    }
    @Override
    public String toString() {
        return "TechCommand{" +
                "bonusType=" + bonusType +
                ", station=" + station +
                ", onTech=" + techApplying +
                ", newValue=" + newTechValue +
                '}';
    }
    // Execute the command and return it.
    public String executeCommand() {
        String command = commandName + station.getStationId() + " ";
        if (TechEnum.TERRAFORMING.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.TERRAFORMING);
        } else if (TechEnum.ALIEN.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.ALIEN);
        } else if (TechEnum.ENGINEERING.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.ENGINEERING);
        } else if (TechEnum.AGRICULTURE.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.AGRICULTURE);
        }
        command += suffix;
        return command;
    }
}

class Strategy {
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
        Distances prev = null;
        Distances cur = null;
        for (Distances distances : distancesArrayList) {
            if (prev == null) {
                prev = distances;
                cur = distances;
            } else {
                if (cur.getUsableToken() > prev.getUsableToken()) {
                    prev = cur;
                }
            }
        }
        //if same nbr of tokens, chose the station/planet where we can win against the opp
        //Build the list of Distances with the same nbr of token to be used
        ArrayList<Distances> optimizedForTokenDistances = new ArrayList<Distances>();
        for (Distances distances : distancesArrayList) {
            if (distances.getUsableToken() == prev.getUsableToken())
                optimizedForTokenDistances.add(distances);
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

enum TechEnum {
    TERRAFORMING,
    ALIEN,
    ENGINEERING,
    AGRICULTURE;
    public static int getCode(TechEnum techEnum){
        if(TERRAFORMING.equals(techEnum)){
            return 0;
        }else if(ALIEN.equals(techEnum)){
            return 1;
        }else if (ENGINEERING.equals(techEnum)){
            return 2;
        }else{
            return 3;
        }
    }
    public static List<TechEnum> getAllTechEnum(){
        List<TechEnum> list = new ArrayList<TechEnum>();
        list.add(TERRAFORMING);
        list.add(ALIEN);
        list.add(ENGINEERING);
        list.add(AGRICULTURE);
        return list;
    }
}

class Logger {
    private boolean logActivasted = true;
    public void println(String log){
        if(logActivasted){
            System.err.println(log);
        }
    }
    public void print(String log){
        if(logActivasted){
            System.err.print(log);
        }
    }
}

class Main {
    Logger logger = new Logger();
    Station[] myStations = new Station[4];
    Station[] oppStations = new Station[4];
    ArrayList<Planet> planets = new ArrayList<Planet>();
    ArrayList<Bonus> myBonus = new ArrayList<Bonus>();
    ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();
    Strategy strategy = new Strategy(myStations,oppStations,planets, myBonus, oppBonus);
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
            // re-init planet
            planets.clear();
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
                planets.add(p);
            }
            // Reinit
            oppBonus.clear();
            myBonus.clear();
            int bonusCount = in.nextInt(); // bonuses in both you and your opponent's inventories
            for (int i = 0; i < bonusCount; i++) {
                int mine = in.nextInt();
                String bonus = in.next();
                Bonus bon = new Bonus(bonus);
                logger.println("mine=" + mine+ ", Bonus="+bonus);
                if(mine == 1){
                    myBonus.add(bon);
                }else{
                    oppBonus.add(bon);
                }
            }
            int myColonizationScore = in.nextInt(); // points from planet colonization, does not include bonus points
            int oppColonizationScore = in.nextInt();
            // Write an action using System.out.println()
            // To debug: logger.println("Debug messages...");
            //printMyStations(myStations);
            //printOppStations(oppStations);
            //printPlanets(planets);
            String execute =  strategy.execute();
            logger.println("Command = "+ execute);
            System.out.println(execute);
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
            logger.println(myStations[i].toString());
            //logger.println("my Station " + myStations[i].stationId + " available=" + myStations[i].isAvailable + " tech1" + myStations[i].terraformingSkill + " tech2" + myStations[i].alienSkill + " tech3" + myStations[i].engineeringSkill + " tech4" + myStations[i].agricultureSkill);
            //logger.println("  obj score = " + myStations[i].myStationObj.scoreIfReached + " obj terra=" + myStations[i].myStationObj.terraLevelObj +   " obj alien=" + myStations[i].myStationObj.alienLevelObj);
        }
    }
    public void printOppStations(Station[] oppStations)
    {
        for (int i=0;i<4;i++)
        {
            logger.println(oppStations[i].toString());
            //logger.println("opp Station " + oppStations[i].stationId + " available=" + oppStations[i].isAvailable + " tech1" + oppStations[i].terraformingSkill + " tech2" + oppStations[i].alienSkill + " tech3" + oppStations[i].engineeringSkill + " tech4" + oppStations[i].agricultureSkill);
        }
    }
    public void printPlanets(Planet[] planets)
    {
        for (int i=0;i<5;i++)
        {
            logger.println(planets[i].toString());
            //logger.println("Planet "  + planets[i].planetId + " task1" + planets[i].terraformingTaskLeftValue + " task2" + planets[i].alienTaskLeftValue + " task3" + planets[i].engineeringTaskLeftValue + " task4" + planets[i].agricultureTaskLeftValue);
            //logger.println("     myContribution=" + planets[i].myContributionTotalTaks + " oppContribution=" + planets[i].oppContributionTotalTasks + " score=" + planets[i].colonizationScore + " bonus0="+ planets[i].bonus0 + " bonus1=" + planets[i].bonus1);
        }
    }
}

public static void main(String[] args) { (new Player()).new Main(args); }
}