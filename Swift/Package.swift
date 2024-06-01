// swift-tools-version: 5.10
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "RacingCars",
    targets: [
        kata("TelemetrySystem"),
        kata("Leaderboard"),
        kata("TirePressure"),
        kata("TurnTicket"),
        kata("HtmlConverter")
    ].flatMap { $0 }
)

func kata(_ name: String) -> [Target] {
    [
        .target(name: name),
        .testTarget(
            name: name + "Tests",
            dependencies: [.target(name: name)]
        )
    ]
}
