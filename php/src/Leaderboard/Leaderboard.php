<?php

declare(strict_types=1);

namespace RacingCar\Leaderboard;

class Leaderboard
{
    /**
     * @param Race[] $races
     */
    public function __construct(
        private array $races
    ) {
    }

    /**
     * @return array<string, int>
     */
    public function getDriverResults(): array
    {
        $driverPoints = [];
        foreach ($this->races as $race) {
            foreach ($race->getResults() as $driver) {
                $name = $race->getDriverName($driver);
                if (! isset($driverPoints[$name])) {
                    $driverPoints[$name] = 0;
                }
                $driverPoints[$name] += $race->getPoints($driver);
            }
        }
        return $driverPoints;
    }

    /**
     * @return int[]|string[]
     */
    public function getDriverRankings(): array
    {
        $points = $this->getDriverResults();
        arsort($points);
        return array_keys($points);
    }
}
