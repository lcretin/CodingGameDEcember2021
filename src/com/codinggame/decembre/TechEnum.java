package com.codinggame.decembre;

import java.util.ArrayList;
import java.util.List;

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

    public static List<TechEnum> getAllTechEnum(){
        List<TechEnum> list = new ArrayList<TechEnum>();
        list.add(TERRAFORMING);
        list.add(ALIEN);
        list.add(ENGINEERING);
        list.add(AGRICULTURE);
        return list;
    }
}
