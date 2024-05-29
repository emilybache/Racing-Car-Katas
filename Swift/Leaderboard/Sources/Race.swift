import Foundation

public class Race {
    private static let points = [25, 18, 15]

    private var _driverNames: [Driver: String] = [:]
    private let _name: String
    public var results: [Driver]

    public var driverNames: [Driver: String] { _driverNames }

    public init(name: String, drivers: [Driver]) {
        self._name = name
        self.results = drivers

        for driver in results {
            var driverName = driver.name

            if let drivingCar = driver as? SelfDrivingCar {
                driverName = "Self Driving Car - " + drivingCar.country + " (" +
                drivingCar.algorithmVersion + ")"
            }

            _driverNames[driver] = driverName
        }
    }

    public func position(_ driver: Driver) -> Int {
        results.firstIndex(of: driver) ?? -1
    }

    public func getPoints(_ driver: Driver) -> Int {
        Self.points[position(driver)]
    }

    public func getDriverName(_ driver: Driver) -> String {
        driverNames[driver]!
    }

    public func toString() -> String {
        _name
    }
}
