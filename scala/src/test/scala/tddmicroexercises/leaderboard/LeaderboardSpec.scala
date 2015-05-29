package tddmicroexercises.leaderboard

import org.scalatest.{Matchers, FlatSpec}

class LeaderboardSpec extends FlatSpec with Matchers {

  it should "sum the points" in {
    TestData.sampleLeaderboard1.driver_results()("Lewis Hamilton") should equal(18+18+25)
  }

  it should "calculate the winner" in {
    TestData.sampleLeaderboard1.driver_rankings()(0) should equal ("Lewis Hamilton")
  }
}

class RaceSpec extends FlatSpec with Matchers {
  it should "calculate driver points" in {
    TestData.race1.points(TestData.driver1) should equal(25)
    TestData.race1.points(TestData.driver2) should equal(18)
    TestData.race1.points(TestData.driver3) should equal(15)
  }
}

/**
 * Test Data found via http://en.wikipedia.org/wiki/2015_Formula_One_season
 */
object TestData {

  val driver1 = new Driver(name="Nico Rosberg", country="DE")
  val driver2 = new Driver(name="Lewis Hamilton", country="UK")
  val driver3 = new Driver(name="Sebastian Vettel", country="DE")
  val driver4 = new SelfDrivingCar(algorithmVersion = "1.2", company="Acme")

  val race1 = new Race("Australian Grand Prix", List(driver1, driver2, driver3))
  val race2 = new Race("Malaysian Grand Prix", List(driver3, driver2, driver1))
  val race3 = new Race("Chinese Grand Prix", List(driver2, driver1, driver3))
  val race4 = new Race("Fictional Grand Prix 1", List(driver1, driver2, driver4))
  val race5 = new Race("Fictional Grand Prix 2", List(driver4, driver2, driver1))
  driver4.algorithmVersion = "1.3"
  val race6 = new Race("Fictional Grand Prix 3", List(driver2, driver1, driver4))

  val sampleLeaderboard1 = new Leaderboard(List(race1, race2, race3))
  val sampleLeaderboard2 = new Leaderboard(List(race4, race5, race6))
}
