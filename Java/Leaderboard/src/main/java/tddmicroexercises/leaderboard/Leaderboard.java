package tddmicroexercises.leaderboard;

import java.util.*;

public class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        Map<String, Integer> results = new HashMap<String, Integer>();
        for (Race race: this.races) {
            for (Driver driver: race.getResults()) {
                String driverName = race.getDriverName(driver);
                int points = race.getPoints(driver);
                if (results.containsKey(driverName)) {
                    results.put(driverName, results.get(driverName) + points);
                } else {
                    results.put(driverName, race.getPoints(driver));
                }
            }
        }
        return results;
    }

    public List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        TreeMap<Integer,String> sortedResults = new TreeMap<Integer,String>();
        for (String driverName: results.keySet()) {
            sortedResults.put(results.get(driverName), driverName);
        }
        List<String> resultsList = new ArrayList<String>(sortedResults.values());
        Collections.reverse(resultsList);
        return resultsList;
    }
}