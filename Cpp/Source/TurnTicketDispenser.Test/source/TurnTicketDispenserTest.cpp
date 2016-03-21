
#include "TurnTicketDispenser/include/TicketDispenser.h"

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

class TurnTicketDispenserTest : public CppUnit::TestFixture 
{
public:
    virtual void setUp() {}
    virtual void tearDown() {}

    void t_GetTicket();
    
    CPPUNIT_TEST_SUITE(TurnTicketDispenserTest);
    CPPUNIT_TEST(t_GetTicket);
    CPPUNIT_TEST_SUITE_END();
};

void TurnTicketDispenserTest::t_GetTicket()
{
}

CPPUNIT_TEST_SUITE_REGISTRATION(TurnTicketDispenserTest);
