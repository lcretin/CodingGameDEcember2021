package com.codinggame.decembre;

public class Bonus {

    private BonusType bonus;

    public Bonus(String bonus) {
        this.bonus = BonusType.valueOf(bonus);
    }

    public BonusType getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Bonus{" + bonus +
                '}';
    }
}
