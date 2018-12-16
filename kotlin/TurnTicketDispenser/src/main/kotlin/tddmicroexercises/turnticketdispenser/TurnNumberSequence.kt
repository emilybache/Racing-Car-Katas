package tddmicroexercises.turnticketdispenser

object TurnNumberSequence {
    private var _turnNumber = 0

    val nextTurnNumber: Int
        get() = _turnNumber++
}
