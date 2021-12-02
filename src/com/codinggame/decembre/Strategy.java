package com.codinggame.decembre;

import java.util.ArrayList;

public class Strategy {


    private Station[] myStations = new Station[4];

    private Station[] oppStations = new Station[4];
    private ArrayList<Planet>  planets = new ArrayList<Planet> ();
    private ArrayList<Bonus> myBonus = new ArrayList<Bonus>();
    private ArrayList<Bonus> oppBonus = new ArrayList<Bonus>();

    public Strategy(Station[] myStations , Station[] oppStations, ArrayList<Planet>  planets, ArrayList<Bonus> myBonus, ArrayList<Bonus> oppBonus){
        this.myStations = myStations;
        this.oppStations = oppStations;
        this.planets = planets;
        this.myBonus = myBonus;
        this.oppBonus = oppBonus;
    }

    public String execute(){
        String preCommand = "";
        // Apply BONUS Pre Command: Apply Tech Reasearch on the first tech on the first station
        for(Bonus bonus: myBonus){
            int techREsearchBonusNum = 0;
            if(BonusType.TECH_RESEARCH_2.equals(bonus)) {
                techREsearchBonusNum = 1;
            }else if(BonusType.TECH_RESEARCH_3.equals(bonus)) {
                techREsearchBonusNum = 2;
            }if(BonusType.TECH_RESEARCH_4.equals(bonus)) {
                techREsearchBonusNum = 3;
            }
            if (techREsearchBonusNum != 0) {
                for (int i = 0; i < myStations.length; i++) {
                    Station station = myStations[i];
                    if (station.getTerraformingSkill() == techREsearchBonusNum) {
                        preCommand = "TECH_RESEARCH " + station.getStationId() + " " + TechEnum.getCode(TechEnum.TERRAFORMING);
                        station.terraformingSkill += techREsearchBonusNum;
                        break;
                    } else if (station.getAlienSkill() == techREsearchBonusNum) {
                        preCommand = "TECH_RESEARCH " + station.getStationId() + " " + TechEnum.getCode(TechEnum.ALIEN);
                        station.alienSkill += techREsearchBonusNum;
                        break;
                    } else if (station.getEngineeringSkill() == techREsearchBonusNum) {
                        preCommand = "TECH_RESEARCH " + station.getStationId() + " " + TechEnum.getCode(TechEnum.ENGINEERING);
                        station.engineeringSkill += techREsearchBonusNum;
                        break;
                    } else if (station.getAgricultureSkill() == techREsearchBonusNum) {
                        preCommand = "TECH_RESEARCH " + station.getStationId() + " " + TechEnum.getCode(TechEnum.AGRICULTURE);
                        station.agricultureSkill += techREsearchBonusNum;
                        break;
                    }
                }
            }
        }
        System.err.println("PreCommand-> ["+preCommand+"]");

        // main actions: COLONIZE | RESUPPLY
        // bonus actions: ENERGY_CORE | ALIEN_ARTIFACT | TECH_RESEARCH | NEW_TECH
        // Append text after any command and that text will appear on screen.
        Distances distance;
        Distances disMin = null;
        Distances disMinAvailable = null;
        for(int i=0; i<myStations.length; i++){
            for (Planet planet: planets){
                distance = new Distances(myStations[i], planet);
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
