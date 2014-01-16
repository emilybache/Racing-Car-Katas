package tddmicroexercises.braking


class Brake(var strategy: AbstractBrakingStrategy) {
  def this() = { this(new SteadyBrakingStrategy()) }

  def getPeakForce: Double = {
    return Brake.peakForce
  }

  def setPeakForce(peakForce: Double) {
    Brake.peakForce = peakForce
  }

  def powerDissipation(velocity: Double): Double = {
    return strategy.powerDissipation(velocity, this)
  }

  def forceAtBrakeLevel(percentOfPeakForce: Double): Double = {
    return Brake.peakForce * percentOfPeakForce
  }
}

object Brake {
  private var peakForce: Double = 30
}