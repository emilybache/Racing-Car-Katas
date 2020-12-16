<?php

declare(strict_types=1);

namespace Tests\Leaderboard;

use PHPUnit\Framework\TestCase;
use RacingCar\Leaderboard\Driver;
use RacingCar\Leaderboard\Race;

class RaceTest extends TestCase
{
    private $driver1;

    private $driver2;

    private $driver3;

    private $race1;

    protected function setUp(): void
    {
        parent::setUp();

        $this->driver1 = new Driver('Nico Rosberg', 'DE');
        $this->driver2 = new Driver('Lewis Hamilton', 'UK');
        $this->driver3 = new Driver('Sebastian Vettel', 'DE');

        $this->race1 = new Race('Australian Grand Prix', [$this->driver1, $this->driver2, $this->driver3]);
    }

    public function testShouldCalculateDriverPoints(): void
    {
        $this->assertSame(25, $this->race1->getPoints($this->driver1));
        $this->assertSame(18, $this->race1->getPoints($this->driver2));
        $this->assertSame(15, $this->race1->getPoints($this->driver3));
    }
}
