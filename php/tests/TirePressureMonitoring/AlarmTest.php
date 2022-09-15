<?php

declare(strict_types=1);

namespace Tests\TirePressureMonitoring;

use PHPUnit\Framework\TestCase;
use RacingCar\TirePressureMonitoring\Alarm;
use RacingCar\TirePressureMonitoring\RealSensor;

class AlarmTest extends TestCase
{
    public function testChecksIfAlarmIsOnWithoutCheck(): void
    {
        //Given
        $alarm = new Alarm(new RealSensor());

        //Then
        $this->assertFalse($alarm->isAlarmOn());
    }

    public function testChecksIfAlarmTurnsOnWhenLowPressure(): void
    {
        //Given
        $fixedSensor = new FixedSensor();
        $fixedSensor->setPressurePsiValue(18.0);

        $alarm = new Alarm($fixedSensor);

        //When
        $alarm->check();

        //Then
        $this->assertFalse($alarm->isAlarmOn());
    }
}
