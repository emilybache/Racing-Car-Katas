package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence implements ITurnNumberSequence
{
	public static ITurnNumberSequence turnNumberSequence = new TurnNumberSequence();

	private int _turnNumber = 0;

    public int getNextTurnNumber()
    {
        return _turnNumber++;
    }
}
