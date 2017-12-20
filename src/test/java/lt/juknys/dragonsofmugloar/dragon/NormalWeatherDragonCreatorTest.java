package lt.juknys.dragonsofmugloar.dragon;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Knight;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class NormalWeatherDragonCreatorTest {

    private NormalWeatherDragonCreator normalWeatherDragonCreator;

    @Before
    public void setUp() throws Exception {
        normalWeatherDragonCreator = new NormalWeatherDragonCreator();
    }

    @Test
    @UseDataProvider("dataProviderKnightAndDragonAttributes")
    public void testCorrectDragonCreated(int attack, int armor, int agility, int endurance, int scaleThickness, int clawSharpness, int wingStrength, int fireBreath) throws Exception {
        Dragon dragon = normalWeatherDragonCreator.createDragon(createKnight(attack, armor, agility, endurance));
        Assert.assertEquals(dragon.getScaleThickness(), scaleThickness);
        Assert.assertEquals(dragon.getClawSharpness(), clawSharpness);
        Assert.assertEquals(dragon.getWingStrength(), wingStrength);
        Assert.assertEquals(dragon.getFireBreath(), fireBreath);
    }

    @DataProvider
    public static Object[][] dataProviderKnightAndDragonAttributes() {
        return new Object[][]{
                {3, 2, 8, 7, 2, 2, 10, 6},
                {5, 2, 5, 8, 4, 2, 4, 10},
                {4, 8, 3, 5, 3, 10, 3, 4},
                {7, 1, 5, 7, 9, 1, 4, 6},
        };
    }

    private Knight createKnight(int attack, int armor, int agility, int endurance) {
        Knight knight = new Knight();
        knight.setAttack(attack);
        knight.setArmor(armor);
        knight.setAgility(agility);
        knight.setEndurance(endurance);
        return knight;
    }
}
