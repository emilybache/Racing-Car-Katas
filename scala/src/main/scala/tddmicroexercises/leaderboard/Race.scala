package tddmicroexercises.leaderboard

class Race(val name: String, val results: List[Driver]) {

  val selfDrivingCar = classOf[SelfDrivingCar]

  val driverNames = results.map( (driver: Driver ) => {
    if (driver.isInstanceOf[SelfDrivingCar]) {
      s"Self Driving Car - ${driver.country} (${driver.asInstanceOf[SelfDrivingCar].algorithmVersion})"
    } else {
      driver.name
    }
  })

  def position(driver: Driver): Int = {
    results.indexOf(driver)
  }

}

object Race {
  val points: List[Int] = List(25, 18, 15)
}

