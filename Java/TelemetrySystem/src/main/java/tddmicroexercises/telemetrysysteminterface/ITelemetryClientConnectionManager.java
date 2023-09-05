package tddmicroexercises.telemetrysysteminterface;

public interface ITelemetryClientConnectionManager {
    public void connect(String telemetryServerConnectionString);

    public void disconnect();

    public boolean getOnlineStatus();

}
