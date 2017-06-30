class Alarm {

    private let lowPressureThreshold = 17.0
    private let highPressureThreshold = 21.0

    let sensor = Sensor()

    var alarmOn = false

    func check() {
        let psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue) {
            alarmOn = true
        }
    }

    func isAlarmOn() -> Bool {
        return alarmOn
    }
}
