package com.codinggame.decembre;

public class Distances {

    private Station station;
    private Planet planet;
    private Integer valueStationPlanet = null;

    public Distances(Station station, Planet planet){
        this.station = station;
        this.planet = planet;
        this.compute();
    }

    public void compute(){
        Integer result = null;
        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getTerraformingTaskLeftValue() != 0 && this.station.getTerraformingSkill() != 0) {
            int disTerra = this.planet.getTerraformingTaskLeftValue() - this.station.getTerraformingSkill();
            if(disTerra < 0){
                if(result == null){
                    result = 0;
                }
            }else{
                if(result == null){
                    result = disTerra;
                }else{
                    result += disTerra;
                }
            }
        }


        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getAlienTaskLeftValue() != 0 && this.station.getAlienSkill() != 0) {
            int disAlien = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();
            if(disAlien < 0){
                if(result == null){
                    result = 0;
                }
            }else{
                if(result == null){
                    result = disAlien;
                }else{
                    result += disAlien;
                }
            }
        }



        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getAlienTaskLeftValue() != 0 && this.station.getAlienSkill() != 0) {
            int disEng = this.planet.getAlienTaskLeftValue() - this.station.getAlienSkill();
            if(disEng < 0){
                if(result == null){
                    result = 0;
                }
            }else{
                if(result == null){
                    result = disEng;
                }else{
                    result += disEng;
                }
            }
        }


        // If no task remaining and no skill on station, not considered in distance
        if(this.planet.getAgricultureTaskLeftValue() != 0 && this.station.getAgricultureSkill() != 0) {
            int disAgri = this.planet.getAgricultureTaskLeftValue() - this.station.getAgricultureSkill();
            if(disAgri < 0){
                if(result == null){
                    result = 0;
                }
            }else{
                if(result == null){
                    result = disAgri;
                }else{
                    result += disAgri;
                }
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

    public Station getStation() {
        return station;
    }

    public Planet getPlanet() {
        return planet;
    }

    public int getValueStationPlanet() {
        return valueStationPlanet;
    }
}
