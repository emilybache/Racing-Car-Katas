package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelementryConnectionImpl implements TelementryConnection {

    private boolean onlineStatus;

    TelementryConnectionEventSimulatorImpl telementryConnectionEventSimulator  = new TelementryConnectionEventSimulatorImpl(42);

    private final Random connectionEventsSimulator = telementryConnectionEventSimulator.getConnectionEventsSimulator();

    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }

    public void connect(String telemetryServerConnectionString)
    {
        CustomException.checkException(telemetryServerConnectionString);

        onlineStatus = connectionEventsSimulator.nextInt(10) <= 8;;
    }

    public void disconnect()
    {
        onlineStatus = false;
    }
}
