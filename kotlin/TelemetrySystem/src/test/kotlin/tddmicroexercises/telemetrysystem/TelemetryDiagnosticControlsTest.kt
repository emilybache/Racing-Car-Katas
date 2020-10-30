package tddmicroexercises.telemetrysystem

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class TelemetryDiagnosticControlsTest {

    @Test
    fun `Should send a diagnostic message`() {
        val telemetryDiagnosticControls = TelemetryDiagnosticControls()

        telemetryDiagnosticControls.checkTransmission()

        assertEquals(A_DIAGNOSTIC_MESSAGE, telemetryDiagnosticControls.diagnosticInfo)
    }

    @Test
    fun `Should send a diagnostic message and receive a status message response`() {
        val telemetryClientSpy = TelemetryClientSpy()
        val telemetryDiagnosticControls = TelemetryDiagnosticControls(telemetryClientSpy)

        telemetryDiagnosticControls.checkTransmission()

        assertEquals(1, telemetryClientSpy.sendCount)
        assertEquals(1, telemetryClientSpy.receiveCount)
    }

    @Test(expected = Exception::class)
    fun `Should after three connection attempt`() {
        val offlineClient = OfflineClient()
        val telemetryDiagnosticControls = TelemetryDiagnosticControls(offlineClient)

        telemetryDiagnosticControls.checkTransmission()

        assertEquals(3, offlineClient.connectAttempt)
    }

    inner class TelemetryClientSpy(
        private val streamData: StreamDataSpy = StreamDataSpy()
    ) : TelemetryClient(streamData = streamData) {
        val receiveCount
            get() = streamData.receiveCount
        val sendCount
            get() = streamData.sendCount
    }

    inner class StreamDataSpy(
        private val connectionEventsSimulator: Random = Random(42),
        private val streamData: StreamData = DefaultStreamData(connectionEventsSimulator)
    ) : StreamData by streamData {
        var sendCount = 0
        var receiveCount = 0

        override fun send(message: String?) {
            sendCount++
            streamData.send(message)
        }

        override fun receive(): String {
            receiveCount++
            return streamData.receive()
        }

    }

    inner class OfflineClient(
        private val connection: OfflineConnection = OfflineConnection()
    ) : TelemetryClient(connection = connection) {
        val connectAttempt: Int
            get() = connection.connectAttempt
    }

    inner class OfflineConnection : Connection {
        var connectAttempt: Int = 0

        override fun isOnline(): Boolean = false

        override fun connect(serverConnection: String?) {
            connectAttempt++
        }

        override fun disconnect() {}
    }

    companion object {
        private const val A_DIAGNOSTIC_MESSAGE = ("LAST TX rate................ 100 MBPS\r\n"
                + "HIGHEST TX rate............. 100 MBPS\r\n"
                + "LAST RX rate................ 100 MBPS\r\n"
                + "HIGHEST RX rate............. 100 MBPS\r\n"
                + "BIT RATE.................... 100000000\r\n"
                + "WORD LEN.................... 16\r\n"
                + "WORD/FRAME.................. 511\r\n"
                + "BITS/FRAME.................. 8192\r\n"
                + "MODULATION TYPE............. PCM/FM\r\n"
                + "TX Digital Los.............. 0.75\r\n"
                + "RX Digital Los.............. 0.10\r\n"
                + "BEP Test.................... -5\r\n"
                + "Local Rtrn Count............ 00\r\n"
                + "Remote Rtrn Count........... 00")
    }
}
