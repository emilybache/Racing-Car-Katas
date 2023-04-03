package tddmicroexercises.telemetrysystem.TelemetryDiagnostics;

import tddmicroexercises.telemetrysystem.TelemetryClient.ITelemetryClient;
import tddmicroexercises.telemetrysystem.TelemetryClient.TelemetryClient;
import tddmicroexercises.telemetrysystem.TelemetryConnection.Connection;
import tddmicroexercises.telemetrysystem.TelemetryConnection.TelemetryConnection;

public class TelemetryDiagnosticControls {
    private final String DiagnosticChannelConnectionString = "*111#";

    private final ITelemetryClient telemetryClient;
    private final Connection telemetryConnection;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls() {
        telemetryClient = new TelemetryClient();
        telemetryConnection = new TelemetryConnection();
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryConnection.disconnect();

        int retryLeft = 3;
        while (telemetryConnection.getConnectionStatus() == false && retryLeft > 0) {
            telemetryConnection.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (telemetryConnection.getConnectionStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }
}