<?php

declare(strict_types=1);


namespace RacingCar\TirePressureMonitoring;

interface Sensor
{
    public function popNextPressurePsiValue(): float;
}