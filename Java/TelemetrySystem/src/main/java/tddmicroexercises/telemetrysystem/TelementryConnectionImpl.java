package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelementryConnectionImpl implements TelementryConnection {

    private boolean onlineStatus;

    private final TelementryConnectionEventSimulator telementryConnectionEventSimulator;

    private final Random connectionEventsSimulator;

    public TelementryConnectionImpl() {
        this.telementryConnectionEventSimulator = new TelementryConnectionEventSimulatorImpl(42);

        this.connectionEventsSimulator = telementryConnectionEventSimulator.getConnectionEventsSimulator();
    }

    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }

    public void connect(String telemetryServerConnectionString) throws TelementryException {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new TelementryException("Argument can not be empty or null");
        }

        onlineStatus = connectionEventsSimulator.nextInt(10) <= 8;;
    }

    public void disconnect()
    {
        onlineStatus = false;
    }
}
