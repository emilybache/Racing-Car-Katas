package tddmicroexercises.turnticketdispenser;

public class MockTurnNumberSequence implements ITurnNumberSequence {
	
	private int turnNumber = 0;

	public int getNextTurnNumber() {
		// TODO Auto-generated method stub
		return turnNumber++;
	}

}
