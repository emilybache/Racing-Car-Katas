<?php

namespace RacingCar\TurnTicketDispenser;

class TurnTicket
{
    private int $turnNumber;

    public function __construct(int $turnNumber)
    {
        $this->turnNumber = $turnNumber;
    }

    public function getTurnNumber()
    {
        return $this->turnNumber;
    }
}
