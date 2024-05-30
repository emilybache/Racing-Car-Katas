import Foundation

public class TicketDispenser {
    public func getTurnTicket() -> TurnTicket {
        let newTurnNumber = TurnNumberSequence.getNextTurnNumber()
        let newTurnTicket = TurnTicket(_turnNumber: newTurnNumber)

        return newTurnTicket
    }
}
