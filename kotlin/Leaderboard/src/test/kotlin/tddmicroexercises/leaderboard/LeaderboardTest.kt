package tddmicroexercises.leaderboard


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import tddmicroexercises.leaderboard.TestData.driver1
import tddmicroexercises.leaderboard.TestData.driver2
import tddmicroexercises.leaderboard.TestData.driver3

class LeaderboardTest {

    @Test
    fun itShouldSumThePoints() {
        // setup

        // act
        val results = TestData.sampleLeaderboard1.driverResults()

        // verify
        assertTrue(results.containsKey("Lewis Hamilton"), "results $results")
        assertEquals((18 + 18 + 25).toLong(), (results.get("Lewis Hamilton") as Int).toLong())
    }

    @Test
    fun isShouldFindTheWinner() {
        // setup

        // act
        val result = TestData.sampleLeaderboard1.driverRankings()

        // verify
        assertEquals("Lewis Hamilton", result.get(0))
    }

    @Test
    fun itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        val winDriver1 = Race("Australian Grand Prix", driver1, driver2, driver3)
        val winDriver2 = Race("Malaysian Grand Prix", driver2, driver1, driver3)
        val exEquoLeaderBoard = Leaderboard(winDriver1, winDriver2)

        // act
        val rankings = exEquoLeaderBoard.driverRankings()

        // verify
        assertEquals(arrayListOf(driver1.name, driver2.name, driver3.name), rankings)
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
