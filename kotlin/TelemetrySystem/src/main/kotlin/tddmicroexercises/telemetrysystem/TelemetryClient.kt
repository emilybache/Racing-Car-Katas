package tddmicroexercises.telemetrysystem

import java.util.*

open class TelemetryClient(
    private val connectionEventsSimulator: Random = Random(42),
    private val connection: Connection = DefaultConnection(connectionEventsSimulator),
    private val streamData: StreamData = DefaultStreamData(connectionEventsSimulator)
) {

    val isOnline: Boolean
        get() = connection.isOnline()
    private val isOffline: Boolean
        get() = !isOnline

    fun connect(telemetryServerConnectionString: String?) {
        connection.connect(telemetryServerConnectionString)
    }

    fun disconnect() {
        connection.disconnect()
    }

    fun attemptConnectionToClient(channelConnection: String) {
        var retryLeft = 3
        while (isOffline && retryLeft > 0) {
            connect(channelConnection)
            retryLeft--
        }

        failIfClientIsStillOffline()
    }

    private fun failIfClientIsStillOffline() {
        if (isOffline) throw Exception("Unable to connect.")
    }

    fun send(message: String?) {
        streamData.send(message)
    }

    fun receive(): String = streamData.receive()
}
