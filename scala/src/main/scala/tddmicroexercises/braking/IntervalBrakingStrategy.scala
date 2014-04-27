package tddmicroexercises.braking


class IntervalBrakingStrategy extends AbstractBrakingStrategy{

  def powerDissipation(velocity: Double, brake: Brake): Double = {
    return brake.forceAtBrakeLevel(100.0) * velocity / 1.5
  }

}