package turnticket

// TurnNumberSequence handles the change between turns
type TurnNumberSequence struct {
	turnNumber int
}

func (t *TurnNumberSequence) getNextTurnNumber() int {
	t.turnNumber++
	return t.turnNumber
}
