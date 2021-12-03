package com.codinggame.decembre;

public class TechCommand {

    private BonusType bonusType;
    private Station station;
    private TechEnum techApplying;
    // Contains the expected tech value for the tech enum. Meaning TECH_RESEARCH_2 -> newTechValue is 2
    // NEW_TECH value is 1
    private int newTechValue;
    private String commandName;
    private String suffix = "";

    public TechCommand(BonusType bonusType, Station station) {
        this.bonusType = bonusType;
        this.station = station;
        commandName = "";
        if (BonusType.NEW_TECH.equals(bonusType)) {
            this.newTechValue = 1;
            commandName = "NEW_TECH ";
        } else if (BonusType.TECH_RESEARCH_2.equals(bonusType)) {
            this.newTechValue = 2;
            commandName = "TECH_RESEARCH ";
        } else if (BonusType.TECH_RESEARCH_3.equals(bonusType)) {
            this.newTechValue = 3;
            commandName = "TECH_RESEARCH ";
        }else if (BonusType.TECH_RESEARCH_4.equals(bonusType)) {
            this.newTechValue = 4;
            commandName = "TECH_RESEARCH ";
        }else{
            this.newTechValue = 1;
            commandName = "NEW_TECH ";
        }
    }

    public boolean canApplyTechEnum(TechEnum techApplying) {
        if (TechEnum.TERRAFORMING.equals(techApplying)) {
            if (station.getTerraformingSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ALIEN.equals(techApplying)) {
            if (station.getAlienSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ENGINEERING.equals(techApplying)) {
            if (station.getEngineeringSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.AGRICULTURE.equals(techApplying)) {
            if (station.getAgricultureSkill() == this.newTechValue - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canApplyBestObjectiveTechEnum(TechEnum techApplying) {
       // System.err.println(station.isTerraformingObjectiveReached());
        if (TechEnum.TERRAFORMING.equals(techApplying) && !station.isTerraformingObjectiveReached()) {
            if (station.getTerraformingSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ALIEN.equals(techApplying) && !station.isAlienObjectiveReached()) {
            if (station.getAlienSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.ENGINEERING.equals(techApplying) && !station.isEngineeringObjectiveReached()) {
            if (station.getEngineeringSkill() == this.newTechValue - 1) {
                return true;
            }
        } else if (TechEnum.AGRICULTURE.equals(techApplying) && !station.isAgricultureObjectiveReached()) {
            if (station.getAgricultureSkill() == this.newTechValue - 1) {
                return true;
            }
        }
        return false;
    }

    public void setTechApplying(TechEnum techApplying) {
        this.techApplying = techApplying;
    }

    public void setBonusType(BonusType bonusType) {
        if(BonusType.NEW_TECH.equals(this.bonusType) ||
                BonusType.ALIEN_ARTIFACT.equals(this.bonusType)||
                BonusType.POINTS_1.equals(this.bonusType)||
                BonusType.POINTS_2.equals(this.bonusType)||
                BonusType.POINTS_3.equals(this.bonusType)){
            suffix = " " + bonusType.getBonusValue();
        }
        this.bonusType = bonusType;

    }

    public TechCommand apply() {
        if(this.techApplying != null) {
            if (TechEnum.TERRAFORMING.equals(techApplying)) {
                station.terraformingSkill = this.newTechValue;
            } else if (TechEnum.ALIEN.equals(techApplying)) {
                station.alienSkill = this.newTechValue;
            } else if (TechEnum.ENGINEERING.equals(techApplying)) {
                station.engineeringSkill = this.newTechValue;
            } else if (TechEnum.AGRICULTURE.equals(techApplying)) {
                station.agricultureSkill = this.newTechValue;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "TechCommand{" +
                "bonusType=" + bonusType +
                ", station=" + station +
                ", onTech=" + techApplying +
                ", newValue=" + newTechValue +
                '}';
    }

    // Execute the command and return it.
    public String executeCommand() {
        String command = commandName + station.getStationId() + " ";

        if (TechEnum.TERRAFORMING.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.TERRAFORMING);
        } else if (TechEnum.ALIEN.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.ALIEN);
        } else if (TechEnum.ENGINEERING.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.ENGINEERING);
        } else if (TechEnum.AGRICULTURE.equals(techApplying)) {
            command += TechEnum.getCode(TechEnum.AGRICULTURE);
        }
        command += suffix;
        return command;
    }


}
