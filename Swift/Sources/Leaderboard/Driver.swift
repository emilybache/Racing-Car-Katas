import Foundation

public class Driver: Hashable {
    public let name: String
    public let country: String

    public init(name: String, country: String) {
        self.name = name
        self.country = country
    }

    public static func == (lhs: Driver, rhs: Driver) -> Bool {
        return lhs === rhs || (lhs.name == rhs.name && lhs.country == rhs.country)
    }

    public func hash(into hasher: inout Hasher) {
        hasher.combine(name)
        hasher.combine(country)
    }
}
