package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls implements DiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    private final ClientClass client;
    private final ConnectionClass connection;



    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls(ClientClass client, ConnectionClass connection)
        {
            this.client = client;
            this.connection = connection;
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
        @Override
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            connection.disconnect();
    
            int retryLeft = 3;
            while (client.getOnlineStatus() == false && retryLeft > 0)
            {
                connection.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(client.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }
            client.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = client.receive();
    }
}
