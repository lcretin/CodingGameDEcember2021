package com.codinggame.decembre;

//import java.util.ArrayList;

public class Distances {

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

    public Distances(Station station, Planet planet){
        this.station = station;
        this.planet = planet; 
        this.compute();
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
            }else{
                result += disValueTerraforming;
                usableToken += usableTokenTerraforming;
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
