import Foundation

public class Leaderboard {
    private var _races: [Race] = []

    public init(_races: [Race]) {
        self._races = _races
    }

    public func driverResults() -> [String: Int] {
        var results: [String: Int] = [:]
        for race in _races {
            for driver in race.results {
                let driverName = race.getDriverName(driver)
                let points = race.getPoints(driver)

                if let driverPoints = results[driverName] {
                    results[driverName] = driverPoints + points
                } else {
                    results[driverName] = points
                }
            }
        }
        return results
    }

    public func driverRankings() -> [String] {
        let results = driverResults()
        let resultsList = results.keys

        return resultsList.sorted()
    }
}
