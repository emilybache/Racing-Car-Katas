package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysysteminterface.ITelemetryClientConnectionManager;

import java.util.Random;

public class TelemetryClientConnectionManager implements ITelemetryClientConnectionManager {

    private boolean onlineStatus;
    private final Random connectionEventsSimulator = new Random(42);

    public Random getConnectionEventsSimulator(){
        return connectionEventsSimulator;
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

    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }

}
