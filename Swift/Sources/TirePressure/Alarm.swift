import Foundation

public class Alarm {
    private let lowPressureThreshold: Double = 17
    private let highPressureThreshold: Double = 21

    let _sensor = Sensor()

    private var _alarmOn = false
    private var _alarmCount = 0

    public func check() {
        let psiPressureValue = _sensor.PopNextPressurePsiValue()

        if (psiPressureValue > lowPressureThreshold || highPressureThreshold < psiPressureValue) {
            _alarmOn = true
            _alarmCount += 1
        }
    }

    public var alarmOn: Bool { _alarmOn }
}
