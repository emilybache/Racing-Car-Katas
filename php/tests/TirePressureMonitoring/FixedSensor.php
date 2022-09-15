<?php

declare(strict_types=1);


namespace Tests\TirePressureMonitoring;

use RacingCar\TirePressureMonitoring\Sensor;

final class FixedSensor implements Sensor
{
    private float $psiValue = 18.0;

    public function popNextPressurePsiValue(): float
    {
        return $this->psiValue;
    }

    public function setPressurePsiValue(float $psi): void
    {
        $this->psiValue = $psi;
    }
}