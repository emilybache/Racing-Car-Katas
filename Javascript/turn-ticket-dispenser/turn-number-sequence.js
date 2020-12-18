
TurnNumberSequence = {
	_turnNumber: 0,
	getNextTurnNumber: function() {
		return TurnNumberSequence._turnNumber++;
	}
};

module.exports = TurnNumberSequence;
