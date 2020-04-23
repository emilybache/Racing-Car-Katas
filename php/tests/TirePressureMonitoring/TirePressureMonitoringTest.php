<?php

use PHPUnit\Framework\TestCase;
use RacingCar\TirePressureMonitoring\Alarm;

class TirePressureMonitoringTest extends TestCase
{
    public function testAlaramIsOffByDefault()
    {
        $alarm = new Alarm();
        $this->assertFalse($alarm->isAlarmOn());
    }
}
