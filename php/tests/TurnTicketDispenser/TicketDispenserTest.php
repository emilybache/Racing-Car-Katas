<?php

declare(strict_types=1);

namespace Tests\TurnTicketDispenser;

use PHPUnit\Framework\TestCase;
use RacingCar\TurnTicketDispenser\TicketDispenser;

class TicketDispenserTest extends TestCase
{
    public function testFoo(): void
    {
        $dispenser = new TicketDispenser();
        $ticket = $dispenser->getTurnTicket();
        $this->assertSame(-1, $ticket->getTurnNumber());
    }
}
