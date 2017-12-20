package lt.juknys.dragonsofmugloar.client;

import lt.juknys.dragonsofmugloar.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherClientService {

    private static final Logger log = LoggerFactory.getLogger(WeatherClientService.class);

    @Value("${weatherUrl}")
    private String weatherUrl;

    private final RestTemplate restTemplate;

    public WeatherClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Weather getWeather(Long gameId) {
        Weather weather = restTemplate.getForObject(weatherUrl + "/" + gameId, Weather.class);
        log.info("Received weather: " + weather.toString());
        return weather;
    }

}
