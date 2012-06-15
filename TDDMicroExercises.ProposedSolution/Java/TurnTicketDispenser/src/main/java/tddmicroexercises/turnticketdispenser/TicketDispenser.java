package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    private ITurnNumberSequence turnNumberSequence;
    
    public TicketDispenser(){
    	this(TurnNumberSequence.turnNumberSequence);
    }

	public TicketDispenser(ITurnNumberSequence turnNumberSequence) {
		this.turnNumberSequence = turnNumberSequence;
	}

	public TurnTicket getTurnTicket()
    {
        int newTurnNumber = turnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
