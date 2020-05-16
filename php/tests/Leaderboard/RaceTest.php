<?php

declare(strict_types=1);

namespace Tests\Leaderboard;

use PHPUnit\Framework\TestCase;
use RacingCar\Leaderboard\Race;
use RacingCar\Leaderboard\Driver;

class RaceTest extends TestCase
{
    private $driver1;
    private $driver2;
    private $driver3;
    private $race1;

    public function setUp(): void
    {
        parent::setUp();

        $this->driver1 = new Driver('Nico Rosberg', 'DE');
        $this->driver2 = new Driver('Lewis Hamilton', 'UK');
        $this->driver3 = new Driver('Sebastian Vettel', 'DE');

        $this->race1 = new Race("Australian Grand Prix", [$this->driver1, $this->driver2, $this->driver3]);
    }

    public function testShouldCalculateDriverPoints()
    {
        $this->assertEquals(25, $this->race1->getPoints($this->driver1));
        $this->assertEquals(18, $this->race1->getPoints($this->driver2));
        $this->assertEquals(15, $this->race1->getPoints($this->driver3));
    }
}