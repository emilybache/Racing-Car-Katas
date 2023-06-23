package tddmicroexercises.telemetrysystem.services;

public interface Client {
    boolean getOnlineStatus();

    void send(String var1);

    String receive();
}