package tddmicroexercises.tirepressuremonitoringsystem

import org.scalatest._

class TestAlarm extends FlatSpec with Matchers {

  it should "foo" in {
       val alarm = new Alarm()
       alarm.isAlarmOn() shouldBe false
    }
}