package lt.juknys.dragonsofmugloar.statistic;

import lt.juknys.dragonsofmugloar.model.*;

public class StatisticBuilder {

    private Knight knight;
    private Weather weather;
    private Dragon dragon;
    private Result result;

    public static StatisticBuilder builder() {
        return new StatisticBuilder();
    }

    public StatisticBuilder setKnight(Knight knight) {
        this.knight = knight;
        return this;
    }

    public StatisticBuilder setWeather(Weather weather) {
        this.weather = weather;
        return this;
    }

    public StatisticBuilder setDragon(Dragon dragon) {
        this.dragon = dragon;
        return this;
    }

    public StatisticBuilder setResult(Result result) {
        this.result = result;
        return this;
    }

    public Statistic build() {
        Statistic statistic = new Statistic();
        statistic.setKnight(knight);
        statistic.setWeather(weather);
        statistic.setDragon(dragon);
        statistic.setResult(result);
        return statistic;
    }
}
