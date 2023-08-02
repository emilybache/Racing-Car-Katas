package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient
{
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private String diagnosticMessageResult = "";

    private boolean onlineStatus;

    private final Random connectionEventsSimulator = new Random(42);


    public String getDiagnosticMessageResult() {
        return diagnosticMessageResult;
    }

    public void setDiagnosticMessageResult(String diagnosticMessageResult) {
        this.diagnosticMessageResult = diagnosticMessageResult;
    }

    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Random getConnectionEventsSimulator() {
        return connectionEventsSimulator;
    }


}
