package tddmicroexercises.leaderboard

import scala.collection.mutable

class Leaderboard(val races: List[Race]) {

  def country_rankings(): List[String] = {
    val results = mutable.Map[String, Int]().withDefaultValue(0)
    races.foreach((race: Race) => {
      race.results.filter(!_.isInstanceOf[SelfDrivingCar]).foreach((driver: Driver) => {
        val position = race.position(driver)
        val points: Int = Race.points(position)
        results(driver.country) += points
      })
    })

    sortedRankings(results)
  }

  def driver_rankings(): List[String] = {
    val results = mutable.Map[String, Int]().withDefaultValue(0)
    races.foreach((race: Race) => {
      race.results.foreach((driver: Driver) => {
        val position = race.position(driver)
        val name = if (driver.isInstanceOf[SelfDrivingCar]) race.driverNames(position) else driver.name
        val points: Int = Race.points(position)
        results(name) += points
      })
    })

    sortedRankings(results)
  }

  private def sortedRankings(results: mutable.Map[String, Int]): List[String] = {
    val resultsAsList = results.toList
    resultsAsList.sortBy(_._2)
    resultsAsList.reverse
    resultsAsList.map(_._1)
  }
}

object Leaderboard {

  val driver1 = new Driver(name="Nico Rosberg", country="DE")
  val driver2 = new Driver(name="Lewis Hamilton", country="UK")
  val driver3 = new Driver(name="Sebastian Vettel", country="DE")
  val driver4 = new SelfDrivingCar(algorithmVersion = "1.2", company="Acme")

  val race1 = new Race("Australian Grand Prix", List(driver1, driver2, driver3))
  val race2 = new Race("Malaysian Grand Prix", List(driver3, driver2, driver1))
  val race3 = new Race("Chinese Grand Prix", List(driver2, driver1, driver3))
  val race4 = new Race("Fictional Grand Prix 1", List(driver2, driver1, driver4))
  val race5 = new Race("Fictional Grand Prix 2", List(driver4, driver1, driver2))
  driver4.algorithmVersion = "1.3"
  val race6 = new Race("Fictional Grand Prix 3", List(driver1, driver2, driver4))

  val sampleLeaderboard1 = new Leaderboard(List(race1, race2, race3))
  val sampleLeaderboard2 = new Leaderboard(List(race4, race5, race6))

}
