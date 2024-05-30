import Foundation

public class TelemetryClient {
    enum Error: Swift.Error {
        case emptyChannel
        case emptyMessage
    }

    public static let diagnosticMessage = "AT#UD"

    private var _onlineStatus = false
    private var _diagnosticMessageResult = ""
    private let _connectionEventsSimulator: (ClosedRange) -> Int = { range in Int.random(in: range) }

    public var onlineStatus: Bool { _onlineStatus }

    public func connect(to channel: String) throws {
        guard !channel.isEmpty else {
            throw Error.emptyChannel
        }

        let success = _connectionEventsSimulator(1...10) <= 8

        _onlineStatus = success
    }

    public func disconnect() {
        _onlineStatus = false
    }

    public func send(_ message: String) throws {
        guard !message.isEmpty else {
            throw Error.emptyMessage
        }

        if message == Self.diagnosticMessage {
            _diagnosticMessageResult = """
            LAST TX rate................ 100 MBPS
            HIGHEST TX rate............. 100 MBPS
            LAST RX rate................ 100 MBPS
            HIGHEST RX rate............. 100 MBPS
            BIT RATE.................... 100000000
            WORD LEN.................... 16
            WORD/FRAME.................. 511
            BITS/FRAME.................. 8192
            MODULATION TYPE............. PCM/FM
            TX Digital Los.............. 0.75
            RX Digital Los.............. 0.10
            BEP Test.................... -5
            Local Rtrn Count............ 00
            Remote Rtrn Count........... 00
            """
            return
        }

        // here should go the real Send operation
    }

    public func receive() -> String {
        var message: String

        if !_diagnosticMessageResult.isEmpty {
            message = _diagnosticMessageResult
            _diagnosticMessageResult = ""
        } else {
            message = ""
            let messageLength = _connectionEventsSimulator(50...110)

            for _ in (0...messageLength) {
                message.unicodeScalars.append(Unicode.Scalar(_connectionEventsSimulator(40...126))!)
            }
        }

        return message
    }
}
