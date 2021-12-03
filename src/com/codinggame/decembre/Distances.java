package com.codinggame.decembre;

//import java.util.ArrayList;

public class Distances {
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
