package tddmicroexercises.braking

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class BrakingCalculationTest extends FlatSpec with Matchers  {
  it should "calculate kinetic energy" in {
    BrakingCalculation.calculateKineticEnergy(110.0, 700.0) should be (4235000.0  +- 0.1)
  }

  it should "calculate speed" in {
    BrakingCalculation.calculateVelocity(4235000.0, 700.0) should be (110.0  +- 0.1)
  }

  it should "calculate stoping_distance_with_zero_speed" in  {
    BrakingCalculation.calculateStoppingDistance(0.0, 700.0, new Brake()) shouldEqual  0.0
  }

  it should  "update_velocity" in  {
    BrakingCalculation.updatedVelocity(110.0, 700.0, new Brake()) should be (105.6 +- 0.1)
  }

  ignore should "calculate stoping_distance_with_high_speed_failing_braking_strategy"  in {
    BrakingCalculation.calculateStoppingDistance(125.0, 700.0, new Brake(new FailingBrakingStrategy)) should be (261.6 +- 0.1)
  }

  it should  "calculate stoping_distance_with_high_speed_abs" in {
    BrakingCalculation.calculateStoppingDistance(125.0, 700.0, new Brake(new IntervalBrakingStrategy())) should be (267.3 +- 0.1)
  }

  it should "update_velocity_low_speed" in {
    BrakingCalculation.updatedVelocity(15.0, 700.0, new Brake) should be (9.81 +- 0.1)
  }

  it should "update_velocity_from_low_speed" in {
    BrakingCalculation.updatedVelocity(25.0, 700.0, new Brake) should be (20.2 +- 0.1)
  }

  it should "calculate stoping_distance_with_high_speed" in {
    BrakingCalculation.calculateStoppingDistance(125.0, 700.0, new Brake) should be (176.1 +- 0.1)
  }
}