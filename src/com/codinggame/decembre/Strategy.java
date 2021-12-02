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
        Distances disMinAvailable = null;
        for(int i=0; i<myStations.length; i++){
            for (int p = 0; p < planets.length; p++){
                distance = new Distances(myStations[i], planets[p]);
                disMin = distance.getSmallerDistance(disMin);
                disMinAvailable = distance.getSmallerAvailableDistance(disMinAvailable);
            }
        }
        //System.err.println("Distance: ["+distance.getPlanet().getPlanetId()+"] ["+distance.getStation().getStationId()+"] dist= "+ distance.getValueStationPlanet());
        Distances distanceToPlay = disMin;

        String colonizeAction="COLONIZE " + distanceToPlay.getStation().getStationId() + " " + distanceToPlay.getPlanet().getPlanetId() + " " + distanceToPlay.getPlanet().getBestBonus();
        if(distanceToPlay.getStation().isAvailable()) {
                return colonizeAction;
        }else{
            //do dwe have a ENERGY BONUS to allow resupply and colonize in one shot
            if(disMinAvailable != null && disMinAvailable.getValueStationPlanet() <= disMin.getValueStationPlanet()){
                return "COLONIZE " + disMinAvailable.getStation().getStationId() + " " + disMinAvailable.getPlanet().getPlanetId() + " " + disMinAvailable.getPlanet().getBestBonus();
            }
            if(isBonusAvailable(myBonus, BonusType.ENERGY_CORE)){
                return BonusType.ENERGY_CORE+" "+colonizeAction;
            }
            else{
                //no choice
                return "RESUPPLY";
            }
            
        }
    }

    public  boolean isBonusAvailable(ArrayList<Bonus> myBonus, BonusType bonusType ){
        if(myBonus == null){
            return false;
        }
        for(Bonus bonus: myBonus){
            if(bonusType.equals(bonus.getBonus())){
                return true;
            }
        }
        return false;
    }
}
