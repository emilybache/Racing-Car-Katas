import Foundation

class Sensor {

    static let offset = 16.0

    func popNextPressurePsiValue() -> Double {
        let pressureTelemetryValue = Sensor.samplePressure()
        return Sensor.offset + pressureTelemetryValue
    }

    private static func samplePressure() -> Double {
        arc4random()
        // placeholder implementation that simulate a real sensor in a real tire
        return 6 * nextDouble() * nextDouble()
    }

    private static func nextDouble() -> Double {
        return Double(arc4random())/Double(UInt32.max)
    }
}
