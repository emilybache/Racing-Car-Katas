package tddmicroexercises.leaderboard

import scala.collection.mutable

class Leaderboard(val races: List[Race]) {

  def country_results(): Map[String, Int] = {
    val results = mutable.Map[String, Int]().withDefaultValue(0)
    races.foreach((race: Race) => {
      race.results.filter(!_.isInstanceOf[SelfDrivingCar]).foreach((driver: Driver) => {
        results(driver.country) += race.points(driver)
      })
    })
    results.toMap
  }

  def driver_results(): Map[String, Int] = {
    val results = mutable.Map[String, Int]().withDefaultValue(0)
    races.foreach((race: Race) => {
      race.results.foreach((driver: Driver) => {
        val position = race.position(driver)
        val name = if (driver.isInstanceOf[SelfDrivingCar]) race.driverNames(position) else driver.name
        results(name) += race.points(driver)
      })
    })
    results.toMap
  }

  def country_rankings(): List[String] = {
    sortedRankings(country_results())
  }


  def driver_rankings(): List[String] = {
    sortedRankings(driver_results())
  }

  def sortedRankings(results: Map[String, Int]): List[String] = {
    results.toList.sortBy(_._2).reverseMap(_._1)
  }

}
