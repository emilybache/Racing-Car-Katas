<?php

declare(strict_types=1);

namespace RacingCar\Leaderboard;

class SelfDrivingCar extends Driver
{
    public function __construct(
        public string $algorithmVersion,
        string $company
    ) {
        parent::__construct(null, $company);
    }
}
