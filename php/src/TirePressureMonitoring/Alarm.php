<?php

namespace RacingCar\TirePressureMonitoring;

class Alarm
{
    private const LOW_PRESSURE_THRESHOLD = 17;
    private const HIGH_PRESSURE_THRESHOLD = 21;
    private bool $isAlarmOn = false;
    private Sensor $sensor;

    public function __construct()
    {
        $this->sensor = new Sensor();
    }

    public function check()
    {
        $psiPressureValue = $this->sensor->popNextPressurePsiValue();
        if ($psiPressureValue < self::LOW_PRESSURE_THRESHOLD || self::HIGH_PRESSURE_THRESHOLD < $psiPressureValue)
        {
            $this->isAlarmOn = true;
        }
    }

    public function isAlarmOn(): bool
    {
        return $this->isAlarmOn;
    }
}
