#ifndef SENSOR_INCLUDED
#define SENSOR_INCLUDED

class Sensor
{
public:
    virtual double popNextPressurePsiValue() = 0;
};

#endif
