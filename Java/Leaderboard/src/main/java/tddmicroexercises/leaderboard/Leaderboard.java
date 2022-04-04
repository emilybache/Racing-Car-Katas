package tddmicroexercises.leaderboard;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Leaderboard {

  private final List<Race> races;

  public Leaderboard(Race... races) {
    this.races = Arrays.asList(races);
  }

  public Map<String, Integer> driverResults() {
    Map<String, Integer> results = new HashMap<>();
    for (Race race : this.races) {
      for (Driver driver : race.getResults()) {
        String driverName = race.getDriverName(driver);
        results.put(driverName, results.getOrDefault(driverName, 0) + race.getPoints(driver));
      }
    }
    return results;
  }

  public List<String> driverRankings() {
    ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(driverResults().entrySet());
    entries.sort(comparingByValue(Comparator.reverseOrder()));
    return entries.stream().map(Map.Entry::getKey).collect(Collectors.toList());
  }
}
