package tddmicroexercises.telemetrysystem

interface Connection {
    fun isOnline(): Boolean
    fun connect(serverConnection: String?)
    fun disconnect()
}