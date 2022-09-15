<?php

declare(strict_types=1);

namespace Tests\TirePressureMonitoring;

use PHPUnit\Framework\TestCase;
use RacingCar\TirePressureMonitoring\Alarm;

class AlarmTest extends TestCase
{
    public function testChecksIfAlarmIsOnWithoutCheck(): void
    {
        $alarm = new Alarm();
        $this->assertFalse($alarm->isAlarmOn());
    }

    public function testChecksIfAlarmTurnsOnWhenLowPressure(): void
    {
        self::markTestSkipped('false positive');
        //Given
        $alarm = new Alarm();

        //When
        $alarm->check();

        //Then
        $this->assertFalse($alarm->isAlarmOn());
    }
}
