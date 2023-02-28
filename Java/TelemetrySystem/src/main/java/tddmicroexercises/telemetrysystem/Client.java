package tddmicroexercises.telemetrysystem;

public interface Client {
    public boolean getOnlineStatus();
    public void send(String message);
    public String receive();
}
