package tddmicroexercises.braking;

public class BrakingCalculation {

    public static double calculateKineticEnergy(double velocity, double mass) {
        return mass*velocity*velocity/2;
    }

    public static double calculateVelocity(double energy, double mass) {
        return Math.sqrt(2*energy/mass);
    }

    public static double calculateStoppingDistance(double velocity, double mass, Brake brake) {
        double distance = 0;
        while (velocity > 0) {

            double updatedVelocity = updatedVelocity(velocity, mass, brake);
            if (updatedVelocity < 0) {
                updatedVelocity = 0;
            }
            distance += (velocity + updatedVelocity)/2*.1;  // one tenth of a second
            velocity = updatedVelocity;
        }
        return distance;
    }


    public static double updatedVelocity(double velocity, double mass, Brake brake) {
        double energyDissipated = brake.powerDissipation(velocity);

        double currentKineticEnergy =  calculateKineticEnergy(velocity, mass) - energyDissipated;
        if (currentKineticEnergy < 0) {
            return 0;
        } else {
            return calculateVelocity(currentKineticEnergy, mass);
        }
    }
}
