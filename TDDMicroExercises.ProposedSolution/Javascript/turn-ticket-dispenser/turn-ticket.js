TurnTicket = function(turnNumber) {

	this._turnNumber = turnNumber;
};

TurnTicket.prototype = {

	turnNumber: function () {
		return this._turnNumber;
	}
};

