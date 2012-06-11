package tddmicroexercises.telemetrysystem;

public interface IConnection {
	
	void disconnect();

	boolean getOnlineStatus();

	void connect(String diagnosticChannelConnectionString);
}
