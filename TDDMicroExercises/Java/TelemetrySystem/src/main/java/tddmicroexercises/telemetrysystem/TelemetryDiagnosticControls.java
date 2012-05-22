package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private final TelemetryClient _telemetryClient;
    private String _diagnosticInfo = "";

        public TelemetryDiagnosticControls()
        {
            _telemetryClient = new TelemetryClient();
        }
        
        public String getDiagnosticInfo(){
        	return _diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
        	this._diagnosticInfo = diagnosticInfo;
        }
 
        public void CheckTransmission() throws Exception
        {
            _diagnosticInfo = "";

        _telemetryClient.Disconnect();

        int retryLeft = 3;
        while (_telemetryClient.getOnlineStatus() == false && retryLeft > 0)
        {
            _telemetryClient.Connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }
         
        if(_telemetryClient.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        _telemetryClient.Send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        _diagnosticInfo = _telemetryClient.Receive();
    }
}
