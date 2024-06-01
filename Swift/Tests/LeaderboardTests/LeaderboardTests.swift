import XCTest
import Leaderboard

final class LeaderboardTests: XCTestCase {
    func test_shouldSumThePoints() {
        let results = TestData.shared.sampleLeaderboard1.driverResults()

        XCTAssertTrue(results.keys.contains("Lewis Hamilton"))
        XCTAssertEqual(18 + 18 + 25, results["Lewis Hamilton"])
    }

    func test_shouldFindTheWinner() {
        XCTAssertEqual(
            "Lewis Hamilton",
            TestData.shared.sampleLeaderboard1.driverRankings()[0]
        )
    }

    func test_shouldKeepAllDriversWhenSamePoints() {
        let winDriver1 = Race(name: "Australian Grand Prix", drivers: [
            TestData.shared.driver1,
            TestData.shared.driver2,
            TestData.shared.driver3
        ])
        let winDriver2 = Race(name: "Malaysian Grand Prix", drivers: [
            TestData.shared.driver2,
            TestData.shared.driver1,
            TestData.shared.driver3
        ])
        let exEquoLeaderboard = Leaderboard(races: [winDriver1, winDriver2])

        let rankings = exEquoLeaderboard.driverRankings()

        XCTAssertEqual(
            [
                TestData.shared.driver2.name,
                TestData.shared.driver1.name,
                TestData.shared.driver3.name
            ],
            rankings
        )
    }
}
