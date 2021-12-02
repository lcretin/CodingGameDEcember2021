package com.codinggame.decembre;

public enum TechEnum {
    TERRAFORMING,
    ALIEN,
    ENGINEERING,
    AGRICULTURE;


    public static int getCode(TechEnum techEnum){
        if(TERRAFORMING.equals(techEnum)){
            return 0;
        }else if(ALIEN.equals(techEnum)){
            return 1;
        }else if (ENGINEERING.equals(techEnum)){
            return 2;
        }else{
            return 3;
        }
    }
}
