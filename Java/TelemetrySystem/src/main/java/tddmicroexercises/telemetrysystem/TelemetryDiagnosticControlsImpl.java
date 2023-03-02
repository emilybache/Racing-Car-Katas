package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControlsImpl implements TelemetryDiagnosticControls {
        private final String DiagnosticChannelConnectionString = "*111#";

        private final TelementryClient telemetryClient;

        private final TelementryConnection telemetryConnection;

        public TelementryDiagnosticInfoImpl telementryDiagnosticInfo;

        public TelemetryDiagnosticControlsImpl()
        {
            telemetryClient = new TelemetryClientImpl();
            telemetryConnection = new TelementryConnectionImpl();
            telementryDiagnosticInfo = new TelementryDiagnosticInfoImpl();
        }

 
        public void checkTransmission(Integer retry) throws Exception {
            telementryDiagnosticInfo.setDiagnosticInfo("");

            telemetryConnection.disconnect();
    
            int retryLeft = retry;
            while (!telemetryConnection.getOnlineStatus() && retryLeft > 0)
            {
                telemetryConnection.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(!telemetryConnection.getOnlineStatus())
            {
                throw new Exception("Unable to connect.");
            }

            telemetryClient.send(TelemetryClientImpl.DIAGNOSTIC_MESSAGE);

            telementryDiagnosticInfo.setDiagnosticInfo(telemetryClient.receive());
    }
}
