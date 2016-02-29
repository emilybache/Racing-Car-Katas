#ifndef ALARM__H_
#define ALARM__H_

#include "sensor.h"

class Alarm
{
public:
    Alarm();
    void check();
    bool isAlarmOn();

protected:
    Sensor sensor;
    double lowPressureTreshold;
    double highPressureTreshold;
    bool alarmOn;
};

#endif // ALARM__H_
