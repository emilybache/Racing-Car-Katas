package tddmicroexercises.tirepressuremonitoringsystem

class Alarm
{
    val  LowPressureThreshold : Double = 17
    val HighPressureThreshold : Double = 21

    val sensor = new Sensor()

    var alarmOn = false

    def check()
    {
        val psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true
        }
    }

    def isAlarmOn() : Boolean = {
        return alarmOn
    }
}