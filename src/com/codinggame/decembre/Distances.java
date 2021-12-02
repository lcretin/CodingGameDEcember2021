package com.codinggame.decembre;

public class Distances {

    private Station station;
    private Planet planet;
    private Integer valueStationPlanet = null;


    private Integer disValueTerraforming = null;
    private Integer disValueAlien = null;
    private Integer disValueEngineering = null;
    private Integer disValueAgriculture = null;

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
            if(disValueTerraforming < 0){
                disValueTerraforming = 0;
            }
            if(result == null){
                result = disValueTerraforming;
            }else{
                result += disValueTerraforming;
            }
        }


        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getAlienTaskLeftValue() != 0 ) {
            disValueAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();
            if(disValueAlien < 0){
                disValueAlien = 0;
            }
            if(result == null){
                result = disValueAlien;
            }else{
                result += disValueAlien;
            }
        }



        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getEngineeringTaskLeftValue() != 0 ) {
            disValueEngineering = this.planet.getEngineeringTaskLeftValue() - this.station.getEngineeringSkill();
            if(disValueEngineering < 0){
                disValueEngineering = 0;
            }
            if(result == null){
                result = disValueEngineering;
            }else{
                result += disValueEngineering;
            }
        }


        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getAgricultureTaskLeftValue() != 0 ) {
            disValueAgriculture= this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();
            if(disValueAgriculture < 0){
                disValueAgriculture = 0;
            }
            if(result == null){
                result = disValueAgriculture;
            }else{
                result += disValueAgriculture;
            }
        }

       this.valueStationPlanet = result;
    }

    public boolean isSmallerThan(Distances distances){
        return distances == null || (distances.valueStationPlanet != null && this.valueStationPlanet < distances.valueStationPlanet);
    }

    public Distances getSmallerDistance(Distances distances){
           if(this.isSmallerThan(distances)){
               return this;
           }else{
               return distances;
           }
    }

    public Distances getSmallerAvailableDistance(Distances distances){
        if(this.isSmallerThan(distances) && this.getStation().isAvailable()){
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

    public int getValueStationPlanet() {
        return valueStationPlanet;
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
}
