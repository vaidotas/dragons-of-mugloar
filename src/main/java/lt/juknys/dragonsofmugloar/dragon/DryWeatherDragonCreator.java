package lt.juknys.dragonsofmugloar.dragon;

import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Knight;

public class DryWeatherDragonCreator implements DragonCreator {

    @Override
    public Dragon createDragon(Knight knight) {
        return DragonBuilder.builder().setScaleThickness(5).setClawSharpness(5).setWingStrength(5).setFireBreath(5).build();
    }

}
