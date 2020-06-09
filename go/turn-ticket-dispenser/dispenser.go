package turnticket

// TicketDispenser handles the despensing of tickets
type TicketDispenser struct {
}

func (t TicketDispenser) GetTurnTicket() TurnTicket {
	ts := TurnNumberSequence{}
	tn := ts.getNextTurnNumber()
	tt := TurnTicket{turnNumber: tn}

	return tt
}
