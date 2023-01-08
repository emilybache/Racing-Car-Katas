<?php

declare(strict_types=1);

namespace RacingCar\TurnTicketDispenser;

class TurnTicket
{
    public function __construct(
        private int $turnNumber
    ) {
    }

    public function getTurnNumber(): int
    {
        return $this->turnNumber;
    }
}
