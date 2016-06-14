#include <gmock/gmock.h>
#include "Sensor.hpp"

class StubSensor : public Sensor {
public:
    MOCK_METHOD0(popNextPressurePsiValue, double());
};

