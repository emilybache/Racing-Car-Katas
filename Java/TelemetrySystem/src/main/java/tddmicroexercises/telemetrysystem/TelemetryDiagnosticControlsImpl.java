package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControlsImpl extends TelementryDiagnosticInfoImpl implements TelemetryDiagnosticControls {
        private final String DiagnosticChannelConnectionString = "*111#";
    
        private final TelemetryClientImpl telemetryClient;

        public TelemetryDiagnosticControlsImpl()
        {
            telemetryClient = new TelemetryClientImpl();
        }

 
        public void checkTransmission(Integer retry) throws Exception {
            this.setDiagnosticInfo("");

            telemetryClient.disconnect();
    
            int retryLeft = retry;
            while (!telemetryClient.getOnlineStatus() && retryLeft > 0)
            {
                telemetryClient.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(!telemetryClient.getOnlineStatus())
            {
                throw new Exception("Unable to connect.");
            }
    
            telemetryClient.send(TelemetryClientImpl.DIAGNOSTIC_MESSAGE);

            this.setDiagnosticInfo(telemetryClient.receive());
    }
}
