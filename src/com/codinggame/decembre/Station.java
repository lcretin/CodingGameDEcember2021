package com.codinggame.decembre;

public class Station {
    int stationId;
    int isMine;
    int isAvailable;

    //tech values
    int terraformingSkill;
    int alienSkill;
    int engineeringSkill;
    int agricultureSkill;

    //
    StationObjective myStationObj;

    //constructor
    public Station(int id,int isMine)
    {
        this.stationId=id;
        this.isMine=isMine;

    }
    public void setTechLevel(int tValue,int alValue,int eValue,int agValue)
    {
        this.terraformingSkill =tValue;
        this.alienSkill =alValue;
        this.engineeringSkill =eValue;
        this.agricultureSkill =agValue;
    }

    public void setAvailable(int available)
    {
        this.isAvailable=available;
    }

    public int isMine()
    {
        return isMine;
    }

    public boolean isAvailable()
    {
        return isAvailable==1;
    }

    public void setObjective(StationObjective stO)
    {
        this.myStationObj=stO;
    }

    public int getStationId() {
        return stationId;
    }

    public int getIsMine() {
        return isMine;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public int getTerraformingSkill() {
        return terraformingSkill;
    }

    public int getAlienSkill() {
        return alienSkill;
    }

    public int getEngineeringSkill() {
        return engineeringSkill;
    }

    public int getAgricultureSkill() {
        return agricultureSkill;
    }

    public StationObjective getMyStationObj() {
        return myStationObj;
    }
}
