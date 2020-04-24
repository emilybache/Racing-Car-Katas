<?php

namespace RacingCar\TurnTicketDispenser;

class TicketDispenser
{
    public function getTurnTicket()
    {
        $newTurnNumber = TurnNumberSequence::nextTurn();
        return new TurnTicket($newTurnNumber);
    }
}
