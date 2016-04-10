
#include "TirePressureMonitoring/include/Alarm.h"

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

///< \todo Remove/Clean-up before final commit

class AlarmTest : public CppUnit::TestFixture 
{
public:
    virtual void setUp() {}
    virtual void tearDown() {}

    void t_FirstTest();
    
    CPPUNIT_TEST_SUITE(AlarmTest);
    CPPUNIT_TEST(t_FirstTest);
    CPPUNIT_TEST_SUITE_END();
};

void AlarmTest::t_FirstTest()
{
    CPPUNIT_ASSERT(false);
}

CPPUNIT_TEST_SUITE_REGISTRATION(AlarmTest);
