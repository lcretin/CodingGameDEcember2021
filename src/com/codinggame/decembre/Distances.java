package com.codinggame.decembre;

public class Distances {

    private Station station;
    private Planet planet;
    private int valueStationPlanet =0;

    public Distances(Station station, Planet planet){
        this.station = station;
        this.planet = planet;
    }

    public void compute(){
        int disTerra = this.planet.getTerraformingTaskLeftValue() - this.station.getTerraformingSkill();
        int disAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();
        int disEng = this.planet.getEngineeringTaskLeftValue() - this.station.getEngineeringSkill();
        int disAgri = this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();

        this.valueStationPlanet = disAgri + disTerra + disEng + disAlien;
    }

    public boolean isSmallerThan(Distances distances){
        return distances == null || this.valueStationPlanet < distances.valueStationPlanet;
    }

    public Distances getSmallerDistance(Distances distances){
           if(this.isSmallerThan(distances)){
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
}
