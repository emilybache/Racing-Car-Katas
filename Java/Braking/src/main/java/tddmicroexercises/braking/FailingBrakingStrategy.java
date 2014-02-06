package tddmicroexercises.braking;

import java.util.Random;

/**
 * This strategy has high power even at high speed, but brakes gradually fail
 */
public class FailingBrakingStrategy implements BrakingStrategy {
    @Override
    public double powerDissipation(double velocity, Brake brake) {
        double percent = (50 + new Random(1234).nextInt(50));
        double force = brake.forceAtBrakeLevel(percent)*velocity;
        brake.setPeakForce(brake.getPeakForce()*0.99); 
        return force;
    }
}
