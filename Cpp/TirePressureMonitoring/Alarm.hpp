#include "sensor.hpp"

using namespace std;

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

