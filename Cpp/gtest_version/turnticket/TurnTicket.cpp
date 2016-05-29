
#include "TurnTicket.hpp"

TurnTicket::TurnTicket(int turnNumber) : m_turnNumber(turnNumber)
{}

int TurnTicket::getTurnNumber()
{
    return m_turnNumber;
}
