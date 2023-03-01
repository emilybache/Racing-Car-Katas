package tddmicroexercises.telemetrysystem;

public interface Connection {

    public boolean getOnlineStatus();

    public void connect(String telemetryServerConnectionString);

    public void disconnect();
}
