package tddmicroexercises.telemetrysystem;

import java.util.Stack;

public class TelemetryConnectionMock implements IConnection {

	private Stack<Boolean> onlineStatuses = new Stack<Boolean>();
	private int connectCallCount = 0;
	private int disconnectCallCount;
	private String connectString;

	public void disconnect() {
		disconnectCallCount++;
	}

	public boolean getOnlineStatus() {
		return onlineStatuses.peek();
	}

	public void connect(String string) {
		connectString = string;
		connectCallCount++;
		onlineStatuses.pop();
	}

	//vararg syntax
	public void setOnlineStatus(Boolean ... statuses) {
		for (Boolean status : statuses )
		onlineStatuses.push(status) ;
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
