package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Test;


public class TurnTicketDispenserCoveringsTests {
	
	@Test
	// Regression test to ensure existing API is not broken
	public void returnsAnIncrementingSequenceOfTicketsUsingDefaultSequenceImplementation() {
		TicketDispenser dispenser = new TicketDispenser();
		assertEquals(0,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(1,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(2,dispenser.getTurnTicket().getTurnNumber());
	}
}
