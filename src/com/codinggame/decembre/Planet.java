package com.codinggame.decembre;

import java.util.ArrayList;

public class Planet {
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
