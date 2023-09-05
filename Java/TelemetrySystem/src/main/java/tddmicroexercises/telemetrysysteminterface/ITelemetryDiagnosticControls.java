package tddmicroexercises.telemetrysysteminterface;

public interface ITelemetryDiagnosticControls {
    final String DiagnosticChannelConnectionString = "*111#";

    public String getDiagnosticInfo();

    public void setDiagnosticInfo(String diagnosticInfo);

    public void checkTransmission() throws Exception;
}
