package lt.juknys.dragonsofmugloar.application;

import lt.juknys.dragonsofmugloar.model.Statistic;
import lt.juknys.dragonsofmugloar.statistic.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "lt.juknys.dragonsofmugloar")
public class DragonsOfMugloarApplication {

    private static final Logger log = LoggerFactory.getLogger(DragonsOfMugloarApplication.class);

    @Value("${defaultNumberOfRounds}")
    private Integer defaultNumberOfRounds;

    public static void main(String[] args) {
        SpringApplication.run(DragonsOfMugloarApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(GameRunnerService gameRunnerService, StatisticService statisticService) {
        return args -> {
            List<Statistic> statistics = new ArrayList<>();
            for (int i = 0; i < getTotalRounds(args); i++) {
                statistics.add(gameRunnerService.runGame());
            }
            statisticService.displayResults(statistics);
        };
    }

    private int getTotalRounds(String[] args) {
        if (args.length != 0) {
            try {
                return Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                log.error("Can not parse passed total number of rounds so default value of {} will be used", defaultNumberOfRounds);
            }
        }
        return defaultNumberOfRounds;
    }

}
