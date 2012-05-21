describe('Turn Ticket Dispenser', function () {

	describe('TurnTicketDispenser', function () {

		it('After ticket 10 come ticket 11', function () {

			var stubTurnNumberSequence = a.stub(TurnNumberSequence);
			spyOn(stubTurnNumberSequence, 'getNextTurnNumber').andCallFake(function () { return 11; });
			var target = new TicketDispenser(stubTurnNumberSequence);

			var newTicket = target.getTurnTicket();

			expect(newTicket.turnNumber()).toEqual(11);

		});

		it('A new ticket must have the turn number subsequent to the previous ticket', function () {

			var target = TicketDispenser.Create();

			var previousTicket = target.getTurnTicket();
			var newTicket = target.getTurnTicket();

			expect(newTicket.turnNumber()).toBeGreaterThan(previousTicket.turnNumber());

		});

		it('A new ticket must have the turn number subsequent to the previous ticket from another dispencer', function () {

			var targetOne = TicketDispenser.Create();
			var targetTwo = TicketDispenser.Create();

			var previousTicket = targetOne.getTurnTicket();
			var newTicket = targetTwo.getTurnTicket();

			expect(newTicket.turnNumber()).toBeGreaterThan(previousTicket.turnNumber());

		});

	});

});
