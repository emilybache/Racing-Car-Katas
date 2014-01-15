package tddmicroexercises.braking;

public class IntervalBrakingStrategy extends AbstractBrakingStrategy {
    @Override
    public double powerDissipation(double velocity, Brake brake) {
        return brake.forceAtBrakeLevel(100.0)*velocity/1.5;
    }
}
