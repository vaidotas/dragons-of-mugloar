package lt.juknys.dragonsofmugloar.dragon;

import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Knight;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StormWeatherDragonCreatorTest {

    private StormWeatherDragonCreator stormWeatherDragonCreator;

    @Before
    public void setUp() throws Exception {
        stormWeatherDragonCreator = new StormWeatherDragonCreator();
    }

    @Test
    public void testCorrectDragonCreated() throws Exception {
        Dragon dragon = stormWeatherDragonCreator.createDragon(new Knight());
        Assert.assertNull(dragon);
    }
}
