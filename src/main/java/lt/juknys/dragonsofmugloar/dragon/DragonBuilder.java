package lt.juknys.dragonsofmugloar.dragon;

import lt.juknys.dragonsofmugloar.model.AttributeType;
import lt.juknys.dragonsofmugloar.model.Dragon;

public class DragonBuilder {

    private int scaleThickness;
    private int clawSharpness;
    private int wingStrength;
    private int fireBreath;

    public static DragonBuilder builder() {
        return new DragonBuilder();
    }

    public DragonBuilder setScaleThickness(int scaleThickness) {
        this.scaleThickness = scaleThickness;
        return this;
    }

    public DragonBuilder setClawSharpness(int clawSharpness) {
        this.clawSharpness = clawSharpness;
        return this;
    }

    public DragonBuilder setWingStrength(int wingStrength) {
        this.wingStrength = wingStrength;
        return this;
    }

    public DragonBuilder setFireBreath(int fireBreath) {
        this.fireBreath = fireBreath;
        return this;
    }

    public DragonBuilder setAttributeByKnightAttribute(int value, AttributeType attributeType) {
        switch (attributeType) {
            case ATTACK:
                return setScaleThickness(value);
            case ARMOR:
                return setClawSharpness(value);
            case AGILITY:
                return setWingStrength(value);
            case ENDURANCE:
                return setFireBreath(value);
        }
        throw new IllegalArgumentException(String.format("Illegal attributeType passed '%s'", attributeType));
    }

    public Dragon build() {
        Dragon dragon = new Dragon();
        dragon.setScaleThickness(scaleThickness);
        dragon.setClawSharpness(clawSharpness);
        dragon.setWingStrength(wingStrength);
        dragon.setFireBreath(fireBreath);
        return dragon;
    }
}
