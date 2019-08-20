package tddmicroexercises.leaderboard;

import java.util.*;
import java.util.stream.Collectors;

class Leaderboard {

    private final List<Race> races;

    Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    Map<String, Integer> driverResults() {
        return this.races.stream()
                .flatMap(race -> race.getResults().stream())
                .collect(Collectors.groupingBy(result -> result.getDriver().getName(),
                        Collectors.summingInt(Result::getPoints)));
    }

    List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        resultsList.sort(Comparator.comparing(results::get).reversed());
        return resultsList;
    }

}
