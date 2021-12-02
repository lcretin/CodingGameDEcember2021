package com.codinggame.decembre;

import java.util.ArrayList;

public class Strategy {


    private Station[] myStations = new Station[4];

    private Station[] oppStations = new Station[4];
    private Planet[] planets = new Planet[5];
    private ArrayList<Bonus> myBonus = new ArrayList<Bonus>();
    private ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();

    public Strategy(Station[] myStations , Station[] oppStations, Planet[] planets, ArrayList<Bonus> myBonus, ArrayList<Bonus> oppBonus){
        this.myStations = myStations;
        this.oppStations = oppStations;
        this.planets = planets;
        this.myBonus = myBonus;
        this.oppBonus = oppBonus;
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
                System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());
            }
        }

        if(disMin.getStation().isAvailable()) {

            return "COLONIZE " + disMin.getStation().getStationId() + " " + disMin.getPlanet().getPlanetId() + " " + disMin.getPlanet().getBestBonus();
        }else{
            return "RESUPPLY";
        }
    }

}
