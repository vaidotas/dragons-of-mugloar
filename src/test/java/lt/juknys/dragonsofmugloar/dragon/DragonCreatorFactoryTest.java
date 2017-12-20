package lt.juknys.dragonsofmugloar.dragon;

import org.junit.Assert;
import org.junit.Test;

public class DragonCreatorFactoryTest {

    @Test
    public void testShouldCreateNormalWeatherDragonCreator() throws Exception {
        Assert.assertTrue(DragonCreatorFactory.getDragonCreator("NMR") instanceof NormalWeatherDragonCreator);
    }

    @Test
    public void testShouldCreateDryWeatherDragonCreator() throws Exception {
        Assert.assertTrue(DragonCreatorFactory.getDragonCreator("T E") instanceof DryWeatherDragonCreator);
    }

    @Test
    public void testShouldCreateStormWeatherDragonCreator() throws Exception {
        Assert.assertTrue(DragonCreatorFactory.getDragonCreator("SRO") instanceof StormWeatherDragonCreator);
    }

    @Test
    public void testShouldCreateRainWeatherDragonCreator() throws Exception {
        Assert.assertTrue(DragonCreatorFactory.getDragonCreator("HVA") instanceof RainWeatherDragonCreator);
    }

    @Test
    public void testShouldCreateFogWeatherDragonCreator() throws Exception {
        Assert.assertTrue(DragonCreatorFactory.getDragonCreator("FUNDEFINEDG") instanceof FogWeatherDragonCreator);
    }
}
