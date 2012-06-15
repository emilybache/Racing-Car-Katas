package tddmicroexercises.telemetrysystem;

public class TelemetryConnectionMock implements IConnection {

	private boolean onlineStatus;
	private int connectCallCount = 0;
	private int disconnectCallCount;
	private String connectString;

	public void disconnect() {
		disconnectCallCount++;
	}

	public boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void connect(String string) {
		connectString = string;
		connectCallCount++;
	}

	public void setOnlineStatus(boolean status) {
		this.onlineStatus = status;
	}

	public int getConnectCallCount() {
		return connectCallCount ;
	}

	public int getDisconnectCallCount() {
		return disconnectCallCount;
	}

	public String getConnectString() {
		return connectString;
	}
}
