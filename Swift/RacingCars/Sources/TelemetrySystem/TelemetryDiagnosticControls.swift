import Foundation

public class TelemetryDiagnosticControls {
    enum Error: Swift.Error {
        case unableToConnect
    }

    private let diagnosticChannelConnectionString = "*111#"
    private let _telemetryClient: TelemetryClient
    private var _diagnosticInfo = ""

    public var diagnosticInfo: String {
        get { _diagnosticInfo }
        set { _diagnosticInfo = newValue }
    }

    public init() {
        _telemetryClient = TelemetryClient()
    }

    public func checkTransmission() throws {
        _diagnosticInfo = ""
        _telemetryClient.disconnect()

        var retryLeft = 3
        while _telemetryClient.onlineStatus == false && retryLeft > 0 {
            try _telemetryClient.connect(to: diagnosticChannelConnectionString)
            retryLeft -= 1
        }

        if _telemetryClient.onlineStatus == false {
            throw Error.unableToConnect
        }

        try _telemetryClient.send(TelemetryClient.diagnosticMessage)
        _diagnosticInfo = _telemetryClient.receive()
    }
}
