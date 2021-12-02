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

    /*public static void main(String[] args) {
        Bonus bonus = new Bonus("ENERGY_CORE");

    }*/
}
