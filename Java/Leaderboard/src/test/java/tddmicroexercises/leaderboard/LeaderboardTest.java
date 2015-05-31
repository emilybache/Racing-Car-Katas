package tddmicroexercises.leaderboard;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;

public class LeaderboardTest {

    @Test
    public void itShouldSumThePoints() {
        Map<String, Integer> results = TestData.sampleLeaderboard1.driverResults();
        Assert.assertTrue("results " + results, results.containsKey("Lewis Hamilton"));
        Assert.assertEquals(18+18+25, (int)results.get("Lewis Hamilton"));
    }

    @Test
    public void isShouldFindTheWinner() {
        Assert.assertEquals("Lewis Hamilton", TestData.sampleLeaderboard1.driverRankings().get(0));
    }
}