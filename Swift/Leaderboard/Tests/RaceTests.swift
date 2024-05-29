import XCTest
import Leaderboard

final class RaceTests: XCTestCase {
    func test_shouldCalculateDriverPoints() {
        XCTAssertEqual(25, TestData.shared.race1.getPoints(TestData.shared.driver1))
        XCTAssertEqual(18, TestData.shared.race1.getPoints(TestData.shared.driver2))
        XCTAssertEqual(15, TestData.shared.race1.getPoints(TestData.shared.driver3))
    }
}
