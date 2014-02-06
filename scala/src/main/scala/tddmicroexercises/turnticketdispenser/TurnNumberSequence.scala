package tddmicroexercises.turnticketdispenser


object TurnNumberSequence {
  private var turnNumber = 0

  def getNextTurnNumber() : Int = {
    turnNumber += 1
    return turnNumber
  }
}