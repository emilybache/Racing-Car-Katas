package tddmicroexercises.leaderboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tddmicroexercises.leaderboard.TestData.driver1;
import static tddmicroexercises.leaderboard.TestData.driver2;
import static tddmicroexercises.leaderboard.TestData.driver3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LeaderboardTest
{

    @Test
    public void itShouldSumThePoints()
    {
        Map<String, Integer> results = TestData.sampleLeaderboard1.driverResults();
        assertTrue("results " + results, results.containsKey("Lewis Hamilton"));
        assertEquals(18 + 18 + 25, (int) results.get("Lewis Hamilton"));
    }

    @Test
    public void isShouldFindTheWinner()
    {
        assertEquals("Lewis Hamilton", TestData.sampleLeaderboard1.driverRankings().get(0));
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints()
    {
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        List<String> rankings = exEquoLeaderBoard.driverRankings();
        assertEquals(Arrays.asList(driver1.getName(), driver2.getName(), driver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
