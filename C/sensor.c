
#include <stdlib.h>
#include <time.h>

float popNextPressurePsiValue()
{
    // placeholder implementation that simulates a real sensor 
    // in a real tire
    time_t t;
    srand((unsigned) time(&t));
    float pressure = 16 + (float)rand()/((float)RAND_MAX/(6));
    return pressure;
}

