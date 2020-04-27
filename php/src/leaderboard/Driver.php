<?php

namespace RacingCar\Leaderboard;

class Driver
{
    public ?string $name;
    public string $country;

    /**
     * Driver constructor.
     *
     * @param string $name
     * @param string $country
     */
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
