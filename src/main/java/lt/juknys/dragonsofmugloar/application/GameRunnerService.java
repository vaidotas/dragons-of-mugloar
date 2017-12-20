package lt.juknys.dragonsofmugloar.application;

import lt.juknys.dragonsofmugloar.client.GameClientService;
import lt.juknys.dragonsofmugloar.client.WeatherClientService;
import lt.juknys.dragonsofmugloar.dragon.DragonCreator;
import lt.juknys.dragonsofmugloar.dragon.DragonCreatorFactory;
import lt.juknys.dragonsofmugloar.model.*;
import lt.juknys.dragonsofmugloar.statistic.StatisticBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameRunnerService {

    private static final Logger log = LoggerFactory.getLogger(GameRunnerService.class);

    private final GameClientService gameClientService;
    private final WeatherClientService weatherClientService;

    public GameRunnerService(GameClientService gameClientService, WeatherClientService weatherClientService) {
        this.gameClientService = gameClientService;
        this.weatherClientService = weatherClientService;
    }

    public Statistic runGame() {
        Game game = gameClientService.startGame();

        Weather weather = weatherClientService.getWeather(game.getGameId());

        DragonCreator dragonCreator = DragonCreatorFactory.getDragonCreator(weather.getCode());

        Dragon dragon = dragonCreator.createDragon(game.getKnight());

        log.info("Created dragon: " + (dragon != null ? dragon.toString() : "NO! Left in the pen."));

        Result result = gameClientService.fight(game.getGameId(), dragon);

        return StatisticBuilder.builder().setKnight(game.getKnight()).setDragon(dragon).setResult(result).setWeather(weather).build();
    }

}
