package tddmicroexercises.braking

import java.lang.Math


object BrakingCalculation {

    def calculateKineticEnergy(velocity: Double, mass: Double): Double = {
      return mass * velocity * velocity / 2
    }

    def calculateVelocity(energy: Double, mass: Double): Double = {
      return Math.sqrt(2 * energy / mass)
    }

    def calculateStoppingDistance(initialVelocity: Double, mass: Double, brake: Brake): Double = {
      var velocity = initialVelocity
      var distance: Double = 0
      while (velocity > 0) {
        var updatedVelocity: Double = BrakingCalculation.updatedVelocity(velocity, mass, brake)
        if (updatedVelocity < 0) {
          updatedVelocity = 0
        }
        distance += (velocity + updatedVelocity) / 2 * .1
        velocity = updatedVelocity
      }
      return distance
    }

    def updatedVelocity(velocity: Double, mass: Double, brake: Brake): Double = {
      val energyDissipated: Double = brake.powerDissipation(velocity)
      val currentKineticEnergy: Double = calculateKineticEnergy(velocity, mass) - energyDissipated
      if (currentKineticEnergy < 0) {
        return 0
      }
      else {
        return calculateVelocity(currentKineticEnergy, mass)
      }
    }


 }