package lt.juknys.dragonsofmugloar.dragon;

import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Knight;

public class RainWeatherDragonCreator implements DragonCreator {

    @Override
    public Dragon createDragon(Knight knight) {
        return DragonBuilder.builder().setScaleThickness(0).setClawSharpness(10).setWingStrength(10).setFireBreath(0).build();
    }

}
