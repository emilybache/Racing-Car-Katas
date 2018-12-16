package tddmicroexercises.leaderboard

object TestData {

    var driver1: Driver
    var driver2: Driver
    var driver3: Driver
    var driver4: SelfDrivingCar

    var race1: Race
    var race2: Race
    var race3: Race
    var race4: Race
    var race5: Race
    var race6: Race

    var sampleLeaderboard1: Leaderboard
    var sampleLeaderboard2: Leaderboard

    init {
        driver1 = Driver("Nico Rosberg", "DE")
        driver2 = Driver("Lewis Hamilton", "UK")
        driver3 = Driver("Sebastian Vettel", "DE")
        driver4 = SelfDrivingCar("1.2", "Acme")

        race1 = Race("Australian Grand Prix", driver1, driver2, driver3)
        race2 = Race("Malaysian Grand Prix", driver3, driver2, driver1)
        race3 = Race("Chinese Grand Prix", driver2, driver1, driver3)
        race4 = Race("Fictional Grand Prix 1", driver1, driver2, driver4)
        race5 = Race("Fictional Grand Prix 2", driver4, driver2, driver1)
        driver4.algorithmVersion = "1.3"
        race6 = Race("Fictional Grand Prix 3", driver2, driver1, driver4)

        sampleLeaderboard1 = Leaderboard(race1, race2, race3)
        sampleLeaderboard2 = Leaderboard(race4, race5, race6)
    }
}
