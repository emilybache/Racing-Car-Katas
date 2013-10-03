#include "alarm.hpp"
#include "sensor.hpp"

Alarm::Alarm()
{
    sensor = Sensor();
    lowPressureTreshold = 17;
    highPressureTreshold = 21;
    alarmOn = false;
}

void Alarm::check()
{
    double psiPressureValue = sensor.popNextPressurePsiValue();

    if (psiPressureValue < lowPressureTreshold || highPressureTreshold < psiPressureValue)
    {
        alarmOn = true;
    }
}

bool Alarm::isAlarmOn()
{
    return alarmOn;
}


