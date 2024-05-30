import Foundation

public class SelfDrivingCar: Driver {
    public var algorithmVersion: String

    public init(algorithmVersion: String, compagny: String) {
        self.algorithmVersion = algorithmVersion

        super.init(name: algorithmVersion, country: compagny)
    }
}
