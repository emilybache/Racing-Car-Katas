package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClientImplementation implements TelemetryClient {
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private boolean onlineStatus;
    private String diagnosticMessageResult = "";

    private final Random connectionEventsSimulator = new Random(42);

    @Override
    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    @Override
    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || telemetryServerConnectionString.isEmpty()) {
            throw new IllegalArgumentException("Telemetry server connection string is invalid.");
        }

        // Simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;
        onlineStatus = success;
    }

    @Override
    public void disconnect() {
        onlineStatus = false;
    }

    @Override
    public void send(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message to be sent is empty.");
        }

        if (message.equals(DIAGNOSTIC_MESSAGE)) {
            // Simulate a status report
            diagnosticMessageResult = "Diagnostic Information";
            return;
        }

        // Here goes the real send operation (not needed for this exercise)
    }

    @Override
    public String receive() {
        String message;

        if (diagnosticMessageResult == null || diagnosticMessageResult.isEmpty()) {
            // Simulate a received message (just for illustration - not needed for this exercise)
            message = "Received message";
        } else {
            message = diagnosticMessageResult;
            diagnosticMessageResult = "";
        }

        return message;
    }
}
