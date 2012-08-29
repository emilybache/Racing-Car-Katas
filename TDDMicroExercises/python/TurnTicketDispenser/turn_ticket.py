class TurnTicket(object):
    def __init__(self, turnNumber):
        self.turnNumber = turnNumber

class TurnNumberSequence(object):
    _turnNumber = -1

    @staticmethod
    def next_turn_number():
        TurnNumberSequence._turnNumber += 1
        return TurnNumberSequence._turnNumber


class TicketDispenser(object):
    def getTurnTicket(self):
        newTurnNumber = TurnNumberSequence.next_turn_number()
        newTurnTicket = TurnTicket(newTurnNumber)
        return newTurnTicket
