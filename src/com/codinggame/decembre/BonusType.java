package com.codinggame.decembre;

import java.util.ArrayList;

public enum BonusType {
    ENERGY_CORE("ENERGY_CORE"),
    TECH_RESEARCH_2("TECH_RESEARCH_2"),
    TECH_RESEARCH_3("TECH_RESEARCH_3"),
    TECH_RESEARCH_4("TECH_RESEARCH_4"),
    NEW_TECH("NEW_TECH"),
    POINTS_1("POINTS_1"),
    POINTS_2("POINTS_2"),
    POINTS_3("POINTS_3"),
    ALIEN_ARTIFACT("ALIEN_ARTIFACT");

    private String bonusValue;

    BonusType(String bonusValue) {
        this.bonusValue = bonusValue;
    }

    @Override
    public String toString() {
        return  bonusValue ;
    }

    public String getBonusValue() {
        return bonusValue;
    }

    public boolean isBonusAvailableInList(ArrayList<Bonus> myBonus) {
        if (myBonus == null) {
            return false;
        }
        for (Bonus bonus : myBonus) {
            if (this.equals(bonus.getBonus())) {
                return true;
            }
        }
        return false;
    }
}
