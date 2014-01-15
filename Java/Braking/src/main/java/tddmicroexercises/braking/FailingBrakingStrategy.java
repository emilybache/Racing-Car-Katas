package tddmicroexercises.braking;

import java.util.Random;

public class FailingBrakingStrategy extends AbstractBrakingStrategy {
    @Override
    public double powerDissipation(double velocity, Brake brake) {
         double percent = (50 + new Random(1234).nextInt(50));
        double force = brake.forceAtBrakeLevel(percent)*velocity;
        brake.setPeakForce(brake.getPeakForce()*0.99); // brakes gradually fail with this strategy
        return force;
    }
}
