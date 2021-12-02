package com.codinggame.decembre;

public class StationObjective {
    int scoreIfReached;

    int terraLevelObj;
    int alienLevelObj;
    int engineeringLevelObj;
    int agricultureLevelObj;

    public StationObjective(int score,int obj0, int obj1, int obj2, int obj3)
    {
        this.scoreIfReached=score;
        this.terraLevelObj=obj0;
        this.alienLevelObj=obj1;
        this.engineeringLevelObj=obj2;
        this.agricultureLevelObj=obj3;
    }
}
