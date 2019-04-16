const { TurnNumberSequence } = require('./turn-number-sequence.js');
const { TurnTicket } = require('./turn-ticket.js');

TicketDispenser = function() {
};

TicketDispenser.prototype = {
	
	getTurnTicket: function () {
		
			var newTurnNumber = TurnNumberSequence.getNextTurnNumber();
			var newTurnTicket = new TurnTicket(newTurnNumber);

			return newTurnTicket;
	}

};

module.exports = { TicketDispenser };
