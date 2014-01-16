package tddmicroexercises.braking

class SteadyBrakingStrategy extends AbstractBrakingStrategy {
  def powerDissipation(velocity: Double, brake: Brake): Double = {
    return brake.forceAtBrakeLevel(100.0) * velocity
  }
}

