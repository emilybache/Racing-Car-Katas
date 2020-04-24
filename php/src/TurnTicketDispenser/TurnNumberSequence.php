<?php

namespace RacingCar\TurnTicketDispenser;

class TurnNumberSequence
{
    private static int $turnNumber = 0;

    public static function nextTurn()
    {
        return self::$turnNumber++;
    }
}
