package tddmicroexercises.telemetrysystem.TelemetryDiagnostics;

public interface ITelemetryDiagnosticControls {
    String getDiagnosticInfo();
    void setDiagnosticInfo(String diagnosticInfo);
    void checkTransmission() throws Exception;
}