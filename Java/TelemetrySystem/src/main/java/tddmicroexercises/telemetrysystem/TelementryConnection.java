package tddmicroexercises.telemetrysystem;

public interface TelementryConnection {

    public boolean getOnlineStatus();

    public void connect(String telemetryServerConnectionString) throws TelementryException;

    public void disconnect();
}
