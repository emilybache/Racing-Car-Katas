package tddmicroexercises.telemetrysystem

import java.util.*

class DefaultConnection(
    private val connectionEventsSimulator: Random
) : Connection {
    private var onlineStatus: Boolean = false

    override fun isOnline(): Boolean = onlineStatus

    override fun connect(serverConnection: String?) {
        if (serverConnection == null || "" == serverConnection) {
            throw IllegalArgumentException()
        }

        // simulate the operation on a real modem
        val success = connectionEventsSimulator.nextInt(10) <= 8

        onlineStatus = success
    }

    override fun disconnect() {
        onlineStatus = false
    }
}