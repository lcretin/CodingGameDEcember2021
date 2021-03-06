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


    public int getTechToCompleteOjbective()
    {
        if (myStationObj == null)
            return -1;
        
        //terra
        if (myStationObj.terraLevelObj==1 && terraformingSkill==0
        && isAlienObjectiveReached() && isEngineeringObjectiveReached() && isAgricultureObjectiveReached())
            return 0;
        
        //alien
        if(myStationObj.alienLevelObj==1 && alienSkill==0
            && isTerraformingObjectiveReached() && isEngineeringObjectiveReached() && isAgricultureObjectiveReached())
                return 1;

        //engin
        if(myStationObj.engineeringLevelObj==1 && engineeringSkill==0
            && isAlienObjectiveReached() && isTerraformingObjectiveReached() && isAgricultureObjectiveReached())
                return 2;

        //agri            
        if(myStationObj.agricultureLevelObj==1 && agricultureSkill==0
            && isAlienObjectiveReached() && isEngineeringObjectiveReached() && isTerraformingObjectiveReached())
              return 3;
        
        return -1;
    }

    public boolean isTerraformingObjectiveReached() {
        if (myStationObj != null && terraformingSkill >= myStationObj.terraLevelObj)
            return true;
        return false;
    }

    public boolean isAlienObjectiveReached() {
        if (myStationObj != null && alienSkill >= myStationObj.alienLevelObj)
            return true;
        return false;
    }

    public boolean isEngineeringObjectiveReached() {
        if (myStationObj != null && engineeringSkill >= myStationObj.engineeringLevelObj)
            return true;
        return false;
    }

    public boolean isAgricultureObjectiveReached() {
    if (myStationObj != null && agricultureSkill >= myStationObj.agricultureLevelObj)
        return true;
    return false;
    }


    public String toString() {
        return "Station{" +
                "" + stationId +
                ", mine=" + isMine +
                ", avail=" + isAvailable +
                ", skill=[" + terraformingSkill +
                ", " + alienSkill +
                ", " + engineeringSkill +
                ", " + agricultureSkill +
                "], " + myStationObj +
                "}";
    }

}
