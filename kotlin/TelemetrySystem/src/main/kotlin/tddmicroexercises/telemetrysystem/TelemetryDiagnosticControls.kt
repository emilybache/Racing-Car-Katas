package tddmicroexercises.telemetrysystem

import tddmicroexercises.telemetrysystem.DefaultStreamData.Companion.DIAGNOSTIC_MESSAGE

class TelemetryDiagnosticControls(
    private val telemetryClient: TelemetryClient = TelemetryClient()
) {
    var diagnosticInfo = ""

    @Throws(Exception::class)
    fun checkTransmission() {
        resetDiagnosticInfo()
        telemetryClient.disconnect()
        telemetryClient.attemptConnectionToClient(DIAGNOSTIC_CHANNEL_CONNECTION)
        telemetryClient.send(DIAGNOSTIC_MESSAGE)
        diagnosticInfo = telemetryClient.receive()
    }

    private fun resetDiagnosticInfo() {
        diagnosticInfo = ""
    }

    companion object {
        private const val DIAGNOSTIC_CHANNEL_CONNECTION = "*111#"
    }
}
