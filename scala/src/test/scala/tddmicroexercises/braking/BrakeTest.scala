package tddmicroexercises.braking

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class BrakeTest extends FlatSpec with Matchers {

  it should  "testPowerDissipation" in {
    val brake: Brake = new Brake
    brake.powerDissipation(110) should be (330000.0 +- 0.1)
  }
}