TicketDispenser = function (turnNumberSequence) {
	this._turnNumberSequence = turnNumberSequence;
};

TicketDispenser.Create = function () {
	var turnNumberSequence = new TurnNumberSequence();
	return new TicketDispenser(turnNumberSequence);
};

TicketDispenser.prototype = {
	
	getTurnTicket: function () {

		var newTurnNumber = this._turnNumberSequence.getNextTurnNumber();
		var newTurnTicket = new TurnTicket(newTurnNumber);

		return newTurnTicket;
	}

};
