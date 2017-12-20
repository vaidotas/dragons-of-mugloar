package lt.juknys.dragonsofmugloar.dragon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DragonCreatorFactory {

    private static final Logger log = LoggerFactory.getLogger(DragonCreatorFactory.class);

    public static DragonCreator getDragonCreator(String weatherCode) {
        switch (weatherCode) {
            case "NMR":
                return new NormalWeatherDragonCreator();
            case "T E":
                return new DryWeatherDragonCreator();
            case "SRO":
                return new StormWeatherDragonCreator();
            case "HVA":
                return new RainWeatherDragonCreator();
            case "FUNDEFINEDG":
                return new FogWeatherDragonCreator();
        }
        String errorMessage = String.format("Can not get dragon creator for weather '%s'", weatherCode);
        log.error(errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }
}
