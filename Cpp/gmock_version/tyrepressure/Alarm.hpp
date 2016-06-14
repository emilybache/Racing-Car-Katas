
#include "Sensor.hpp"

class Alarm
{
public:
    Alarm(Sensor *sensor);
    void check();
    bool isAlarmOn();

protected:
    Sensor *m_sensor;
    double m_lowPressureTreshold;
    double m_highPressureTreshold;
    bool m_alarmOn;
};
