package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelementryConnectionEventSimulatorImpl  implements  TelementryConnectionEventSimulator {

    private Random connectionEventsSimulator;

    public TelementryConnectionEventSimulatorImpl(Integer seed) {
      connectionEventsSimulator = new Random(seed);
    }

    public Random getConnectionEventsSimulator() {
        return connectionEventsSimulator;
    }

}
