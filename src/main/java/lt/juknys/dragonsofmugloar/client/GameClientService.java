package lt.juknys.dragonsofmugloar.client;

import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Game;
import lt.juknys.dragonsofmugloar.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameClientService {

    private static final Logger log = LoggerFactory.getLogger(GameClientService.class);

    private final RestTemplate restTemplate;

    @Value("${gameUrl}")
    private String gameUrl;

    public GameClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Game startGame() {
        Game game = restTemplate.getForObject(gameUrl, Game.class);
        log.info("Received game: " + game.toString());
        return game;
    }

    public Result fight(Long gameId, Dragon dragon) {
        ResponseEntity<Result> exchange = restTemplate.exchange(gameUrl + "/" + gameId + "/solution", HttpMethod.PUT, new HttpEntity<>(dragon), Result.class);
        log.info("Fight result: " + exchange.getBody().toString());
        return exchange.getBody();
    }

}
