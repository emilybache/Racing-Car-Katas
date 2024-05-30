import XCTest
@testable import TirePressure

final class AlarmTests: XCTestCase {
    func testAlarmIsOffByDefault() {
        let alarm = Alarm()

        XCTAssertFalse(alarm.alarmOn)
    }
}
