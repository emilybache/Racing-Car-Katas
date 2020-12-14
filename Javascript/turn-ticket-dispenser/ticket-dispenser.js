var TurnNumberSequence = require('./turn-number-sequence.js');
var TurnTicket = require('./turn-ticket.js');

TicketDispenser = function() {
};

TicketDispenser.prototype = {

	getTurnTicket: function() {
		var newTurnNumber = TurnNumberSequence.getNextTurnNumber();
		var newTurnTicket = new TurnTicket(newTurnNumber);

		return newTurnTicket;
	}

};

module.exports = TicketDispenser;
