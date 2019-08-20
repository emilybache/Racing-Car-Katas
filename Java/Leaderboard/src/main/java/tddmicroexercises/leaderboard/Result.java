package tddmicroexercises.leaderboard;

public class Result {
    private final Driver driver;
    private final Integer position;
    private final Integer points;

    Result(Driver driver, Integer position, Integer points) {
        this.driver = driver;
        this.position = position;
        this.points = points;
    }

    Driver getDriver() {
        return driver;
    }

    public Integer getPosition() {
        return position;
    }

    Integer getPoints() {
        return points;
    }
}
