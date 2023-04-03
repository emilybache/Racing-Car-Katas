package tddmicroexercises.telemetrysystem.TelemetryConnection;

public interface Connection {
    boolean getConnectionStatus();

    void connect(String connectionString);

    void disconnect();
}