package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryConnection implements IConnection
{
	private final Random connectionEventsSimulator = new Random(42);

	private boolean onlineStatus;

	public boolean getOnlineStatus()
	{
		return onlineStatus; 
	}

	public void connect(String telemetryServerConnectionString)
	{
		if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
		{
			throw new IllegalArgumentException();
		}

		// simulate the operation on a real modem
		boolean success = connectionEventsSimulator.nextInt(10) <= 8;

		onlineStatus = success;
	}

	public void disconnect()
	{
		onlineStatus = false;
	}
}

