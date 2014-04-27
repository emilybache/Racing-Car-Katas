package tddmicroexercises.braking;

/**
 * This strategy prevents wheel-lock by not braking 1/3 of the time
 */
public class IntervalBrakingStrategy implements BrakingStrategy {
    @Override
    public double powerDissipation(double velocity, Brake brake) {
        return brake.forceAtBrakeLevel(100.0)*velocity/1.5;
    }
}