package com.codinggame.decembre;

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

    public String getBestBonus(){
        return "0";
    }
}
