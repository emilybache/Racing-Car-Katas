<?php

declare(strict_types=1);

namespace Tests\TirePressureMonitoring;

use PHPUnit\Framework\TestCase;
use RacingCar\TirePressureMonitoring\Alarm;

class AlarmTest extends TestCase
{
    public function testFoo(): void
    {
        $alarm = new Alarm();
        $this->assertFalse($alarm->isAlarmOn());
    }
}
