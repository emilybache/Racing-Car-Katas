package tddmicroexercises.leaderboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class RaceTest {

    @Test
    fun isShouldCalculateDriverPoints() {
        // setup

        // act

        // verify
        assertEquals(25, TestData.race1.getPoints(TestData.driver1))
        assertEquals(18, TestData.race1.getPoints(TestData.driver2))
        assertEquals(15, TestData.race1.getPoints(TestData.driver3))
    }

}
