
#include "Sensor.hpp"

#include <cstdlib>
#include <time.h>

Sensor::Sensor()
{
    srand((unsigned)time(0));
}

double Sensor::popNextPressurePsiValue()
{
    // placeholder implementation that simulates a real sensor 
    // in a real tire
    double pressure = 16 + (float)rand()/((float)RAND_MAX/(6));
    return pressure;
}
