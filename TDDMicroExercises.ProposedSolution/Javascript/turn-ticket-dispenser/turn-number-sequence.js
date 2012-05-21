TurnNumberSequence = function () {
	
};

TurnNumberSequence._turnNumber = 1;

TurnNumberSequence.prototype = {

	getNextTurnNumber: function() {
		return TurnNumberSequence._turnNumber++;
	}
	
};