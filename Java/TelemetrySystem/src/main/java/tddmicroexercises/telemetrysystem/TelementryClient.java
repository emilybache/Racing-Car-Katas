package tddmicroexercises.telemetrysystem;

public interface TelementryClient {

    public void send(String message);

    public String receive();
}
