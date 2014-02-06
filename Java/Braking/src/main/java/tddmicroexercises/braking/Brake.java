package tddmicroexercises.braking;

public class Brake {
    private BrakingStrategy strategy;
    private static double peakForce = 30;

    public Brake(BrakingStrategy strategy) {
        this.strategy = strategy;
    }

    public double getPeakForce() {
        return peakForce;
    }

    public void setPeakForce(double peakForce) {
        this.peakForce = peakForce;
    }

    public double powerDissipation(double velocity) {
        if (this.strategy == null) {
            if (velocity < 60) {
                this.strategy = new SteadyBrakingStrategy();
            } else if (velocity < 120) {
                this.strategy = new IntervalBrakingStrategy();
            } else {
                this.strategy = new FailingBrakingStrategy();
            }
        } 
        return strategy.powerDissipation(velocity, this);
    }

    public double forceAtBrakeLevel(double percentOfPeakForce) {
        return this.peakForce*percentOfPeakForce;
    }
}
