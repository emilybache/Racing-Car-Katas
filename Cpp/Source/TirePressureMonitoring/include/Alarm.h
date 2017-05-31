#pragma once

#include "Sensor.h"

class Alarm
{
public:
    Alarm();
    void check();
    bool isAlarmOn();

protected:
    Sensor m_sensor;
    double m_lowPressureThreshold;
    double m_highPressureThreshold;
    bool m_alarmOn;
};
