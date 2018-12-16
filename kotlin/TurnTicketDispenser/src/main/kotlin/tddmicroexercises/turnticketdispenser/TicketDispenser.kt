package tddmicroexercises.turnticketdispenser

class TicketDispenser {
    val turnTicket: TurnTicket
        get() {
            val newTurnNumber = TurnNumberSequence.nextTurnNumber

            return TurnTicket(newTurnNumber)
        }
}
