package tddmicroexercises.telemetrysystem

class TelemetryDiagnosticControls {
    private val DiagnosticChannelConnectionString = "*111#"

    private val telemetryClient: TelemetryClient
    var diagnosticInfo = ""

    init {
        telemetryClient = TelemetryClient()
    }

    @Throws(Exception::class)
    fun checkTransmission() {
        diagnosticInfo = ""

        telemetryClient.disconnect()

        var retryLeft = 3
        while (telemetryClient.onlineStatus == false && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString)
            retryLeft -= 1
        }

        if (telemetryClient.onlineStatus == false) {
            throw Exception("Unable to connect.")
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE)
        diagnosticInfo = telemetryClient.receive()
    }
}
