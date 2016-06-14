#include "Sensor.hpp"

class PressureSensor : public Sensor
{
public:
    PressureSensor();
    double popNextPressurePsiValue();
};