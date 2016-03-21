
#include "../include/TicketDispenser.h"
#include "../include/TurnNumberSequence.h"

TurnTicket TicketDispenser::getTurnTicket()
{
    int newTurnNumber = TurnNumberSequence::getNextTurnNumber();
    return TurnTicket(newTurnNumber);
}
