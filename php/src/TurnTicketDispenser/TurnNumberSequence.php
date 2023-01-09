<?php

declare(strict_types=1);

namespace RacingCar\TurnTicketDispenser;

class TurnNumberSequence
{
    private static int $turnNumber = 0;

    public static function nextTurn(): int
    {
        return self::$turnNumber++;
    }
}
