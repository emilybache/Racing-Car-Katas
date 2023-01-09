<?php

declare(strict_types=1);

namespace RacingCar\Leaderboard;

use Stringable;

class Driver implements Stringable
{
    public function __construct(
        public ?string $name,
        public string $country
    ) {
    }

    public function __toString(): string
    {
        return (string) "{$this->name} {$this->country}";
    }
}
