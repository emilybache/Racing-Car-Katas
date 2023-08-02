package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    private Transmission telemetryTransmissionService;
    private Connection telemetryConnectionService;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(Transmission telemetryTransmissionService, Connection telemetryConnectionService)
    {
        this.telemetryTransmissionService = telemetryTransmissionService;
        this.telemetryConnectionService = telemetryConnectionService;
    }

    public String getDiagnosticInfo(){
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo){
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception
    {
        diagnosticInfo = "";

        telemetryConnectionService.disconnect();

        int retryLeft = 3;
        while (telemetryConnectionService.getOnlineStatus() == false && retryLeft > 0)
        {
            telemetryConnectionService.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(telemetryConnectionService.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        telemetryTransmissionService.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryTransmissionService.receive();
    }
}