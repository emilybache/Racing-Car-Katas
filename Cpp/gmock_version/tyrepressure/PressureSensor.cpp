
#include "PressureSensor.hpp"

#include <cstdlib>
#include <time.h>

PressureSensor::PressureSensor()
{
    srand((unsigned)time(0));
}

double PressureSensor::popNextPressurePsiValue()
{
    // placeholder implementation that simulates a real sensor
    // in a real tire
    double pressure = 16 + (float)rand()/((float)RAND_MAX/(6));
    return pressure;
}
