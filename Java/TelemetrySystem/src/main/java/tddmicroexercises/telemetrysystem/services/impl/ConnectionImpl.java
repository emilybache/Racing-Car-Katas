package tddmicroexercises.telemetrysystem.services.impl;


import java.util.Random;
import tddmicroexercises.telemetrysystem.services.Connection;

public class ConnectionImpl implements Connection {
    private boolean onlineStatus;
    private Random connectionEventsSimulator = new Random(42L);

    public ConnectionImpl() {
    }

    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString != null && !"".equals(telemetryServerConnectionString)) {
            boolean success = this.connectionEventsSimulator.nextInt(10) <= 8;
            this.onlineStatus = success;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void disconnect() {
        this.onlineStatus = false;
    }
}

