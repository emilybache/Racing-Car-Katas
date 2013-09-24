require "test/unit"

require 'tire_pressure'

class TestAlarm < Test::Unit::TestCase
 
  def test_alarm_off_by_default
    assert(!Alarm.new().is_alarm_on)
  end
 
end