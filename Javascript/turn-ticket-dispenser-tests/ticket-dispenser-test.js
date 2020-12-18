/* globals describe, it */
var chai = require('chai');
chai.should();

var TicketDispenser = require('../turn-ticket-dispenser/ticket-dispenser.js');

describe('Turn Ticket Dispenser', function() {

	describe('TurnTicketDispenser', function() {

		it('foo', function() {
			var dispenser = new TicketDispenser();
			var ticket = dispenser.getTurnTicket();
			ticket.turnNumber().should.equal(-1);
		});

	});

});
