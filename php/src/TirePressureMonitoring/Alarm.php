<?php

declare(strict_types=1);

namespace RacingCar\TirePressureMonitoring;

class Alarm
{
    private const LOW_PRESSURE_THRESHOLD = 17;

    private const HIGH_PRESSURE_THRESHOLD = 21;

    private $sensor;

    private $isAlarmOn = false;

    public function __construct()
    {
        $this->sensor = new Sensor();
    }

    public function check(): void
    {
        $psiPressureValue = $this->sensor->popNextPressurePsiValue();

        if ($psiPressureValue < self::LOW_PRESSURE_THRESHOLD || $psiPressureValue > self::HIGH_PRESSURE_THRESHOLD) {
            $this->isAlarmOn = true;
        }
    }

    public function isAlarmOn(): bool
    {
        return $this->isAlarmOn;
    }
}
