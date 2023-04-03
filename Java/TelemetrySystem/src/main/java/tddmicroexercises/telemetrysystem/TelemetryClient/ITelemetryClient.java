package tddmicroexercises.telemetrysystem.TelemetryClient;

public interface ITelemetryClient {

    void send(String message);
    String receive();
}
