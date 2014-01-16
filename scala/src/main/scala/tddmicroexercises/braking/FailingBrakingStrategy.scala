package tddmicroexercises.braking

import java.util.Random


class FailingBrakingStrategy extends AbstractBrakingStrategy {

  def powerDissipation(velocity: Double, brake: Brake): Double = {
    val percent: Double = (50 + new Random(1234).nextInt(50))
    val force: Double = brake.forceAtBrakeLevel(percent) * velocity
    brake.setPeakForce(brake.getPeakForce * 0.99)
    return force
  }
}