<?php

declare(strict_types=1);

namespace RacingCar\TirePressureMonitoring;

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

class Sensor
{
    private const OFFSET = 16;

    public function popNextPressurePsiValue()
    {
        $pressureTelemetryValue = self::getSamplePressure();

        return self::OFFSET + $pressureTelemetryValue;
    }

    private static function getSamplePressure()
    {
        // placeholder implementation that simulate a real sensor in a real tire
        return 6 * mt_rand() / mt_getrandmax() * mt_rand() / mt_getrandmax();
    }
}
