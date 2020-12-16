<?php

declare(strict_types=1);

namespace RacingCar\TurnTicketDispenser;

class TurnTicket
{
    private $turnNumber;

    public function __construct(int $turnNumber)
    {
        $this->turnNumber = $turnNumber;
    }

    public function getTurnNumber()
    {
        return $this->turnNumber;
    }
}
