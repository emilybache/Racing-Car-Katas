package tddmicroexercises.telemetrysystem;

public interface TelementryClient {

    public void send(String message) throws TelementryException;

    public String receive();
}
