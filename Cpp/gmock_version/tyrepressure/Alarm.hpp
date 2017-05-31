
#include "Sensor.hpp"

class Alarm
{
public:
    Alarm(Sensor *sensor);
    void check();
    bool isAlarmOn();

protected:
    Sensor *m_sensor;
    double m_lowPressureThreshold;
    double m_highPressureThreshold;
    bool m_alarmOn;
};
