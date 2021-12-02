package com.codinggame.decembre;

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
