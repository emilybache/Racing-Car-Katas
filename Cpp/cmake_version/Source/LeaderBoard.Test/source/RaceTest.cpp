
#include "../include/TestData.h"

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

class RaceTest : public CppUnit::TestFixture 
{
public:
    virtual void setUp() {}
    virtual void tearDown() {}

    void t_CalculateDriverPoints();
    
    CPPUNIT_TEST_SUITE(RaceTest);
    CPPUNIT_TEST(t_CalculateDriverPoints);
    CPPUNIT_TEST_SUITE_END();
};

void RaceTest::t_CalculateDriverPoints()
{
    CPPUNIT_ASSERT(25 == TestData::race1.getPoints(TestData::driver1));
    CPPUNIT_ASSERT(18 == TestData::race1.getPoints(TestData::driver2));
    CPPUNIT_ASSERT(15 == TestData::race1.getPoints(TestData::driver3));
}

CPPUNIT_TEST_SUITE_REGISTRATION(RaceTest);
