
#include "../include/TurnNumberSequence.h"

int TurnNumberSequence::s_turnNumber = 0;

int TurnNumberSequence::getNextTurnNumber()
{
    return s_turnNumber++;
}
