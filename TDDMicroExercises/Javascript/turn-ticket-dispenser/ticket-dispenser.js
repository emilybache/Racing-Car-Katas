TicketDispenser = function() {
};

TicketDispenser.prototype = {
	
	getTurnTicket: function () {
		
			var newTurnNumber = TurnNumberSequence.getNextTurnNumber();
			var newTurnTicket = new TurnTicket(newTurnNumber);

			return newTurnTicket;
	}

};
