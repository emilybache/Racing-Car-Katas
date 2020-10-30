package tddmicroexercises.telemetrysystem

interface StreamData {
    fun getDiagnosticMessageResult(): String
    fun send(message: String?)
    fun receive(): String
}
