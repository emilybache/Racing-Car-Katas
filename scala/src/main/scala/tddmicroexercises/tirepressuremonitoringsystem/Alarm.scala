package tddmicroexercises.tirepressuremonitoringsystem

class Alarm
{
    val  LowPressureTreshold : Double = 17
    val HighPressureTreshold : Double = 21

    val sensor = new Sensor()

    var alarmOn = false

    def check()
    {
        val psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue)
        {
            alarmOn = true
        }
    }

    def isAlarmOn() : Boolean = {
        return alarmOn
    }
}