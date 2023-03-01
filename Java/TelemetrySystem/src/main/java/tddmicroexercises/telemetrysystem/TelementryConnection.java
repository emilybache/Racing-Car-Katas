package tddmicroexercises.telemetrysystem;

public interface TelementryConnection {

    public void connect(String telemetryServerConnectionString);

    public void disconnect();
}
