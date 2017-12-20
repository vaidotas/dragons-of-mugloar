package lt.juknys.dragonsofmugloar.dragon;

import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Knight;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RainWeatherDragonCreatorTest {

    private RainWeatherDragonCreator rainWeatherDragonCreator;

    @Before
    public void setUp() throws Exception {
        rainWeatherDragonCreator = new RainWeatherDragonCreator();
    }

    @Test
    public void testCorrectDragonCreated() throws Exception {
        Dragon dragon = rainWeatherDragonCreator.createDragon(new Knight());
        Assert.assertEquals(dragon.getScaleThickness(), 0);
        Assert.assertEquals(dragon.getClawSharpness(), 10);
        Assert.assertEquals(dragon.getWingStrength(), 10);
        Assert.assertEquals(dragon.getFireBreath(), 0);
    }
}
