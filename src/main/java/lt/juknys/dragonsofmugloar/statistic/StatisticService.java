package lt.juknys.dragonsofmugloar.statistic;

import lt.juknys.dragonsofmugloar.model.Statistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    private static final Logger log = LoggerFactory.getLogger(StatisticService.class);

    public void displayResults(List<Statistic> statistics) {
        int won = 0;
        int lost = 0;
        for (Statistic statistic : statistics) {
            if ("Victory".equals(statistic.getResult().getStatus())) {
                won++;
            } else {
                lost++;
            }
        }
        log.info("\nTotals:\n\tWon: " + won + "\n\tLost: " + lost);
    }
}
