package tddmicroexercises.telemetrysystem;


public class TelemetryDataChannelMock implements IDataChannel {

	private String diagnosticMessage;
	private String sentMessage = "";

	public void send(String diagnosticMessage) {
		sentMessage  = diagnosticMessage;
	}

	public String receive() {
		return diagnosticMessage;
	}

	public void setDiagnosticMessage(String diagnosticMessage) {
		this.diagnosticMessage = diagnosticMessage;
	}

	public boolean hasSentMessage(String message) {
		return sentMessage.equals(message);
	}
}
