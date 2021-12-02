package com.codinggame.decembre;

import java.util.ArrayList;

public class Bonus {

    public enum BonusType
    {
        ENERGY_CORE("ENERGY_CORE"),
        TECH_RESEARCH_2SIT("TECH_RESEARCH_2"),
        TECH_RESEARCH_3("TECH_RESEARCH_3"),
        TECH_RESEARCH_4("TECH_RESEARCH_4"),
        POINTS_1("POINTS_1"),
        POINTS_2("POINTS_2"),
        POINTS_3("POINTS_3"),
        ALIEN_ARTIFACT("ALIEN_ARTIFACT");

        private String bonusValue;

        BonusType(String bonusValue) {
            this.bonusValue = bonusValue;
        }

        public String getBonusValue() {
            return bonusValue;
        }
    }

    private BonusType bonus;

    public Bonus(String bonus){
        this.bonus = BonusType.valueOf(bonus);
    }

    public static boolean isBonusAvailable(ArrayList<Bonus> myBonus, BonusType bonusType ){
        if(myBonus == null){
            return false;
        }
        for(Bonus bonus: myBonus){
            if(bonusType.equals(bonus.bonus)){
                return true;
            }
        }
        return false;
    }

}
