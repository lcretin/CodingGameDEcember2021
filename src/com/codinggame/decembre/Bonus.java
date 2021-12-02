package com.codinggame.decembre;

import java.util.ArrayList;

public class Bonus {

    private BonusType bonus;

    public Bonus(String bonus){
        this.bonus = BonusType.valueOf(bonus);
    }

    public BonusType getBonus() {
        return bonus;
    }
}
