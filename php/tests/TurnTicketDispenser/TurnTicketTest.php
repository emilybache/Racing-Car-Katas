<?php

use PHPUnit\Framework\TestCase;
use RacingCar\TurnTicketDispenser\TicketDispenser;

class TurnTicketTest extends TestCase
{
    public function testDoSomething()
    {
        $dispenser = new TicketDispenser();
        $ticket = $dispenser->getTurnTicket();
    }
}
