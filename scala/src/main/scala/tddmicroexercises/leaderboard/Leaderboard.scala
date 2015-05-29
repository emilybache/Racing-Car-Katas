package tddmicroexercises.leaderboard

import scala.collection.mutable

class Leaderboard(val races: List[Race]) {

  def driver_results(): Map[String, Int] = {
    val results = mutable.Map[String, Int]().withDefaultValue(0)
    races.foreach((race: Race) => {
      race.results.foreach((driver: Driver) => {
        val position = race.position(driver)
        val name = race.driverNames(position)
        results(name) += race.points(driver)
      })
    })
    results.toMap
  }

  def driver_rankings(): List[String] = {
    sortedRankings(driver_results())
  }

  private def sortedRankings(results: Map[String, Int]): List[String] = {
    results.toList.sortBy(_._2).reverseMap(_._1)
  }

}
