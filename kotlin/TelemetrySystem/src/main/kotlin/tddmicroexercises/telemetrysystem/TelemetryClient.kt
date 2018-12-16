package tddmicroexercises.telemetrysystem

import java.util.*

class TelemetryClient {

    var onlineStatus: Boolean = false
        private set
    private var diagnosticMessageResult: String = ""

    private val connectionEventsSimulator = Random(42)

    fun connect(telemetryServerConnectionString: String?) {
        if (telemetryServerConnectionString == null || "" == telemetryServerConnectionString) {
            throw IllegalArgumentException()
        }

        // simulate the operation on a real modem
        val success = connectionEventsSimulator.nextInt(10) <= 8

        onlineStatus = success
    }

    fun disconnect() {
        onlineStatus = false
    }

    fun send(message: String?) {
        if (message == null || "" == message) {
            throw IllegalArgumentException()
        }

        if (message === DIAGNOSTIC_MESSAGE) {
            // simulate a status report
            diagnosticMessageResult = ("LAST TX rate................ 100 MBPS\r\n"
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

            return
        }

        // here should go the real Send operation (not needed for this exercise)
    }

    fun receive(): String {
        var message: String

        if (diagnosticMessageResult == null || "" == diagnosticMessageResult) {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = ""
            val messageLength = connectionEventsSimulator.nextInt(50) + 60
            for (i in messageLength downTo 0) {
                message += connectionEventsSimulator.nextInt(40).toChar().toInt() + 86
            }

        } else {
            message = diagnosticMessageResult
            diagnosticMessageResult = ""
        }

        return message
    }

    companion object {
        val DIAGNOSTIC_MESSAGE = "AT#UD"
    }
}
