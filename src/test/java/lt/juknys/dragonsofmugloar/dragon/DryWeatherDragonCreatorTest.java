package lt.juknys.dragonsofmugloar.dragon;

import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Knight;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DryWeatherDragonCreatorTest {

    private DryWeatherDragonCreator dryWeatherDragonCreator;

    @Before
    public void setUp() throws Exception {
        dryWeatherDragonCreator = new DryWeatherDragonCreator();
    }

    @Test
    public void testCorrectDragonCreated() throws Exception {
        Dragon dragon = dryWeatherDragonCreator.createDragon(new Knight());
        Assert.assertEquals(dragon.getScaleThickness(), 5);
        Assert.assertEquals(dragon.getClawSharpness(), 5);
        Assert.assertEquals(dragon.getWingStrength(), 5);
        Assert.assertEquals(dragon.getFireBreath(), 5);
    }
}
