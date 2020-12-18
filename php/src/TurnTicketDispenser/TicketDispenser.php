<?php

declare(strict_types=1);

namespace RacingCar\TurnTicketDispenser;

class TicketDispenser
{
    public function getTurnTicket()
    {
        $newTurnNumber = TurnNumberSequence::nextTurn();
        return new TurnTicket($newTurnNumber);
    }
}
