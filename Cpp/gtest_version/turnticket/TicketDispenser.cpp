
#include "TicketDispenser.hpp"
#include "TurnNumberSequence.hpp"

TurnTicket TicketDispenser::getTurnTicket()
{
    int newTurnNumber = TurnNumberSequence::getNextTurnNumber();
    return TurnTicket(newTurnNumber);
}
