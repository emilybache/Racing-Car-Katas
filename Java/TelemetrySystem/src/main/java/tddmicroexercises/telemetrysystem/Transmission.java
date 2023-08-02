package tddmicroexercises.telemetrysystem;

public interface Transmission {

    public void send(String message);
    public String receive();
    public void checkTransmission()throws Exception;
}
