
TurnNumberSequence = {
	_turnNumber: 1,
	getNextTurnNumber: function() {
		return TurnNumberSequence._turnNumber++;
	}
};

module.exports = { TurnNumberSequence };
