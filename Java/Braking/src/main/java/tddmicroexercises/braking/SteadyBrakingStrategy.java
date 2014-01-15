package tddmicroexercises.braking;

public class SteadyBrakingStrategy extends AbstractBrakingStrategy {
    public double powerDissipation(double velocity, Brake brake) {
            return brake.forceAtBrakeLevel(100.0)*velocity;
        }
}
