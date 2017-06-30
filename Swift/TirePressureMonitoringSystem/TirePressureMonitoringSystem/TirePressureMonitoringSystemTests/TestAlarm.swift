import XCTest

class TestAlarm: XCTestCase {
    
    func testFoo() {
        let alarm = Alarm()        
        XCTAssertEqual(false, alarm.isAlarmOn())
    }
}
