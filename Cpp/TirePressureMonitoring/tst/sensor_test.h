#ifndef SENSOR_TEST__H_
#define SENSOR_TEST__H_

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

class SensorTest : public CppUnit::TestFixture {
public:
    SensorTest();
    virtual ~SensorTest() {}
    virtual void setUp();
    virtual void tearDown();

    // TODO: begin implementing tests
    void t_FirstTest();

    CPPUNIT_TEST_SUITE(SensorTest);
    CPPUNIT_TEST(t_FirstTest);
    CPPUNIT_TEST_SUITE_END();
};

#endif // SENSOR_TEST__H_
