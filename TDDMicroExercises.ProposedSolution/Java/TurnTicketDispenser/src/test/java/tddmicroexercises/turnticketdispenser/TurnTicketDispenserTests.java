package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Test;


public class TurnTicketDispenserTests {
	
	@Test
	// Regression test to ensure existing API is not broken
	public void returnsAnIncrementingSequenceOfTicketsUsingDefaultSequenceImplementation() {
		TicketDispenser dispenser = new TicketDispenser();
		assertEquals(0,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(1,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(2,dispenser.getTurnTicket().getTurnNumber());
	}

	@Test
	public void returnsAnIncrementingSequenceOfTickets() {
		TicketDispenser dispenser = new TicketDispenser(new MockTurnNumberSequence());
		assertEquals(0,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(1,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(2,dispenser.getTurnTicket().getTurnNumber());
	}
	
	@Test
	public void sequenceIsMaintainedAcrossMultipleDispensers(){
		ITurnNumberSequence mockTurnNumberSequence = new MockTurnNumberSequence();
		assertEquals(0,new TicketDispenser(mockTurnNumberSequence).getTurnTicket().getTurnNumber());
		assertEquals(1,new TicketDispenser(mockTurnNumberSequence).getTurnTicket().getTurnNumber());
		assertEquals(2,new TicketDispenser(mockTurnNumberSequence).getTurnTicket().getTurnNumber());
	}
}
