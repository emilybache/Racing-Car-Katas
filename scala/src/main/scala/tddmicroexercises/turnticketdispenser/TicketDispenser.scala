package tddmicroexercises.turnticketdispenser


class TicketDispenser {
  def getTurnTicket() : TurnTicket = {
    var newTurnNumber = TurnNumberSequence.getNextTurnNumber()
    var newTurnTicket = new TurnTicket(newTurnNumber)

    return newTurnTicket
  }
}