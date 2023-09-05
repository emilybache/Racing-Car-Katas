package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysysteminterface.ITelemetryDiagnosticControls;

public class TelemetryDiagnosticControls implements ITelemetryDiagnosticControls
{
    private final TelemetryClient telemetryClient;
    private final TelemetryClientConnectionManager telemetryClientConnectionManager;

    private String diagnosticInfo = "";

        TelemetryDiagnosticControls(TelemetryClientConnectionManager telemetryClientConnectionManager, TelemetryClient telemetryClient){
            this.telemetryClientConnectionManager = telemetryClientConnectionManager;
            this.telemetryClient = telemetryClient;
        }

        public TelemetryDiagnosticControls()
        {

            telemetryClient = new TelemetryClient();
            telemetryClientConnectionManager = new TelemetryClientConnectionManager();
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

        telemetryClientConnectionManager.disconnect();

        int retryLeft = 3;
        while (telemetryClientConnectionManager.getOnlineStatus() == false && retryLeft > 0)
        {
            telemetryClientConnectionManager.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(telemetryClientConnectionManager.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }

}
