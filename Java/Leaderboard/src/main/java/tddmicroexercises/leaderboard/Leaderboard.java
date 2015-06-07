package tddmicroexercises.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Leaderboard
{

    private final List<Race> races;

    public Leaderboard(Race... races)
    {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults()
    {
        Map<String, Integer> results = new HashMap<>();
        for (Race race : this.races)
        {
            for (Driver driver : race.getResults())
            {
                String driverName = race.getDriverName(driver);
                int points = race.getPoints(driver);
                if (results.containsKey(driverName))
                {
                    results.put(driverName, results.get(driverName) + points);
                } 
                else
                {
                    results.put(driverName, race.getPoints(driver));
                }
            }
        }
        return results;
    }

    public List<String> driverRankings()
    {
        Map<String, Integer> results = driverResults();
        Map<Integer, String> sortedResults = new TreeMap<>();
        for (String driverName : results.keySet())
        {
            sortedResults.put(results.get(driverName), driverName);
        }
        List<String> resultsList = new ArrayList<>(sortedResults.values());
        Collections.reverse(resultsList);
        return resultsList;
    }
}
