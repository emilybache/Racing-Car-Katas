// swift-tools-version: 5.10
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "RacingCars",
    targets: [
        .target(name: "TelemetrySystem"),
        .testTarget(
            name: "TelemetrySystemTests",
            dependencies: ["TelemetrySystem"]
        ),
        .target(name: "Leaderboard"),
        .testTarget(
            name: "LeaderboardTests",
            dependencies: ["Leaderboard"]
        ),
        .target(name: "TirePressure"),
        .testTarget(
            name: "TirePressureTests",
            dependencies: ["TirePressure"]
        ),
        .target(name: "TurnTicket"),
        .testTarget(
            name: "TurnTicketTests",
            dependencies: ["TurnTicket"]
        )
    ]
)

