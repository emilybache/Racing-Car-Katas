<?php

declare(strict_types=1);

namespace RacingCar\Leaderboard;

class SelfDrivingCar extends Driver
{
    public $algorithmVersion;

    public function __construct(string $algorithmVersion, string $company)
    {
        parent::__construct(null, $company);
        $this->algorithmVersion = $algorithmVersion;
    }
}
