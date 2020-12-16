<?php

declare(strict_types=1);

namespace RacingCar\Leaderboard;

class Driver
{
    public $name;

    public $country;

    public function __construct(?string $name, string $country)
    {
        $this->name = $name;
        $this->country = $country;
    }

    public function __toString()
    {
        return "{$this->name} {$this->country}";
    }
}
