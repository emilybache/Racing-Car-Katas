package tddmicroexercises.braking;

public class Brake {
    private final AbstractBrakingStrategy strategy;
    private static double peakForce = 30;

    public Brake(AbstractBrakingStrategy strategy) {
        this.strategy = strategy;
    }

    public Brake() {
        this.strategy = new SteadyBrakingStrategy();
    }

    public double getPeakForce() {
        return peakForce;
    }

    public void setPeakForce(double peakForce) {
        this.peakForce = peakForce;
    }

    public double powerDissipation(double velocity) {
        return strategy.powerDissipation(velocity, this);
    }

    public double forceAtBrakeLevel(double percentOfPeakForce) {
        return this.peakForce*percentOfPeakForce;
    }
}
