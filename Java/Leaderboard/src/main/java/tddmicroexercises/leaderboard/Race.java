package tddmicroexercises.leaderboard;

import java.util.*;

public class Race {

    private static final Integer[] POINTS = new Integer[]{25, 18, 15};

    private final String name;
    private final List<Result> results;
    private final Map<Driver, String> driverNames;
    private List<Driver> driverList;

    Race(String name, Driver... drivers) {
        driverList = Arrays.asList(drivers);
        this.name = name;
        List<Result> list = new ArrayList<>();
        for (Driver driver : drivers) {
            Result result1 = new Result(driver, driverList.indexOf(driver), getPoints(driver));
            list.add(result1);
        }
        this.results = list;
        this.driverNames = new HashMap<>();
        for (Result result : results) {
            this.driverNames.put(result.getDriver(), result.getDriver().getName());
        }
    }

    private int position(Driver driver) {
        return this.driverList.indexOf(driver);
//        return this.results.stream()
//                .filter(Predicate.isEqual(driver))
//                .findFirst()
//                .map(Result::getPosition)
//                .orElse(0);
    }

    int getPoints(Driver driver) {
        return Race.POINTS[position(driver)];
    }

    List<Result> getResults() {
        return results;
    }

    String getDriverName(Driver driver) {
        return this.driverNames.get(driver);
    }

    @Override
    public String toString() {
        return name;
    }
}
