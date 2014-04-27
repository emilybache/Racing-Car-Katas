package tddmicroexercises.braking


trait AbstractBrakingStrategy {
  def powerDissipation(velocity: Double, brake: Brake): Double
}