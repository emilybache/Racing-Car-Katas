package tddmicroexercises.telemetrysystem;

public interface Connection {

    public void connect(String telemetryServerConnectionString);
     public void disconnect();
     public boolean getOnlineStatus();

}
