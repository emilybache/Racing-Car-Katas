package tddmicroexercises.telemetrysystem;

import java.net.ConnectException;

public class TelemetryDiagnosticControls
{
    public static final String CONNECTION_STRING = "*111#";
    
    private final IConnection connection;
    private final IDataChannel dataChannel;
    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls(){
            this(new TelemetryConnection(), new TelemetryDataChannel());
        }
        
        public TelemetryDiagnosticControls(IConnection connection, IDataChannel dataChannel) {
			this.connection = connection;
			this.dataChannel = dataChannel;
		}

		public String getDiagnosticInfo(){
        	return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
        	this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception{
            diagnosticInfo = "";

	        connection.disconnect();
	
	        int retryLeft = 3;
	        while (connection.getOnlineStatus() == false && retryLeft > 0){
	            connection.connect(CONNECTION_STRING);
	            retryLeft -= 1;
	        }
	         
	        if(connection.getOnlineStatus() == false){
	            throw new ConnectException("Unable to connect.");
	        }
	
	        dataChannel.send(IDataChannel.DIAGNOSTIC_MESSAGE);
	        diagnosticInfo = dataChannel.receive();
    }
}
