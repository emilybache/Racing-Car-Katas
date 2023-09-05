package tddmicroexercises.telemetrysysteminterface;

public interface ITelemetryClient {
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    public void send(String message);

    public String receive();

}
