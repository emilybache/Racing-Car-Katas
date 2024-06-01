import Foundation
import Leaderboard

class TestData {
    static let shared = TestData()

    let driver1: Driver
    let driver2: Driver
    let driver3: Driver
    let driver4: SelfDrivingCar

    let race1: Race
    let race2: Race
    let race3: Race
    let race4: Race
    let race5: Race
    let race6: Race

    let sampleLeaderboard1: Leaderboard
    let sampleLeaderboard2: Leaderboard

    private init() {
        driver1 = Driver(name: "Nico Rosberg", country: "DE")
        driver2 = Driver(name: "Lewis Hamilton", country: "UK")
        driver3 = Driver(name: "Sebastian Vettel", country: "DE")
        driver4 = SelfDrivingCar(algorithmVersion: "1.2", compagny: "Acme")

        race1 = Race(name: "Australian Grand Prix", drivers: [driver1, driver2, driver3])
        race2 = Race(name: "Malaysian Grand Prix", drivers: [driver3, driver2, driver1])
        race3 = Race(name: "Chinese Grand Prix", drivers: [driver2, driver1, driver3])
        race4 = Race(name: "Fictional Grand Prix 1", drivers: [driver1, driver2, driver4])
        race5 = Race(name: "Fictional Grand Prix 2", drivers: [driver4, driver2, driver1])
        driver4.algorithmVersion = "1.3"
        race6 = Race(name: "Fictional Grand Prix 3", drivers: [driver2, driver1, driver4])

        sampleLeaderboard1 = Leaderboard(races: [race1, race2, race3])
        sampleLeaderboard2 = Leaderboard(races: [race4, race5, race6])
    }
}
