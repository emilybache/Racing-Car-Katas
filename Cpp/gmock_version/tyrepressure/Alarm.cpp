
#include "Alarm.hpp"
#include "Sensor.hpp"

Alarm::Alarm(Sensor *sensor) : m_sensor(sensor),
                               m_lowPressureTreshold(17),
                               m_highPressureTreshold(21),
                               m_alarmOn(false)
{}

void Alarm::check()
{
    double psiPressureValue = m_sensor->popNextPressurePsiValue();

    if (psiPressureValue < m_lowPressureTreshold || m_highPressureTreshold < psiPressureValue)
    {
        m_alarmOn = true;
    }
}

bool Alarm::isAlarmOn()
{
    return m_alarmOn;
}
