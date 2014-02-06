package tddmicroexercises.braking;

/**
 * This strategy simply puts the brakes on at full power. This 
 * strategy is only appropriate at low speed.
 */
public class SteadyBrakingStrategy implements BrakingStrategy {
    public double powerDissipation(double velocity, Brake brake) {
            return brake.forceAtBrakeLevel(100.0)*velocity;
        }
}
