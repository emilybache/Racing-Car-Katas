class TurnTicket(object):
    def __init__(self, turnNumber):
        self.turnNumber = turnNumber

class TurnNumberSequence(object):
    _turnNumber = -1

    @staticmethod
    def getNextTurnNumber():
        TurnNumberSequence._turnNumber += 1
        return TurnNumberSequence._turnNumber


class TicketDispenser(object):
    def getTurnTicket(self):
        newTurnNumber = TurnNumberSequence.getNextTurnNumber()
        newTurnTicket = TurnTicket(newTurnNumber)
        return newTurnTicket
