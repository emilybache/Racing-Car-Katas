<?php

declare(strict_types=1);

namespace RacingCar\TurnTicketDispenser;

class TurnNumberSequence
{
    private static $turnNumber = 0;

    public static function nextTurn()
    {
        return self::$turnNumber++;
    }
}
