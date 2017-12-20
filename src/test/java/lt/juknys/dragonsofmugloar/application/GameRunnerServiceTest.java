package lt.juknys.dragonsofmugloar.application;

import lt.juknys.dragonsofmugloar.client.GameClientService;
import lt.juknys.dragonsofmugloar.client.WeatherClientService;
import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Game;
import lt.juknys.dragonsofmugloar.model.Weather;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class GameRunnerServiceTest {

    @Mock
    private GameClientService gameClientService;

    @Mock
    private WeatherClientService weatherClientService;

    @InjectMocks
    private GameRunnerService gameRunnerService;

    private Game game;
    private Weather weather;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        game.setGameId(123L);
        weather = new Weather();
        weather.setCode("T E");
    }

    @Test
    public void testCorrectClientInvocationsCounter() throws Exception {
        Mockito.when(gameClientService.startGame()).thenReturn(game);
        Mockito.when(weatherClientService.getWeather(eq(game.getGameId()))).thenReturn(weather);
        gameRunnerService.runGame();

        Mockito.verify(gameClientService, Mockito.times(1)).startGame();
        Mockito.verify(weatherClientService, Mockito.times(1)).getWeather(game.getGameId());
        Mockito.verify(gameClientService, Mockito.times(1)).fight(anyLong(), any(Dragon.class));
    }

}
