package com.codinggame.decembre;

public class Strategy {


    private Station[] myStations = new Station[4];

    private Station[] oppStations = new Station[4];
    private Planet[] planets = new Planet[5];

    public Strategy(Station[] myStations , Station[] oppStations, Planet[] planets){
        this.myStations = myStations;
        this.oppStations = oppStations;
        this.planets = planets;
    }

    public String execute(){
        // main actions: COLONIZE | RESUPPLY
        // bonus actions: ENERGY_CORE | ALIEN_ARTIFACT | TECH_RESEARCH | NEW_TECH
        // Append text after any command and that text will appear on screen.
        Distances distance;
        Distances disMin = null;
        for(int i=0; i<myStations.length; i++){
            for (int p = 0; p < planets.length; p++){
                distance = new Distances(myStations[i], planets[p]);
                disMin = distance.getSmallerDistance(disMin);
            }
        }

        if(disMin.getStation().isAvailable()) {
            
            String colonizeAction="COLONIZE " + disMin.getStation().getStationId() + " " + disMin.getPlanet().getPlanetId() + " " + disMin.getPlanet().getBestBonus();
            {
                return colonizeAction;
            }   
        }else{
            //do dwe have a ENERGY BONUS to allow resupply and colonize in one shot
            if (Bonus.isBonusAvailable(Bonus.bonusType.ENERGY)){ //TODO check enum anf statis method
                return Bonus.bonusType.ENERGY+" "+colonizeAction;
            }
            else{
                //no choice
                return "RESUPPLY";
            }
            
        }
    }

}
