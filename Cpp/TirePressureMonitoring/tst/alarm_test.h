#ifndef ALARM_TEST__H_
#define ALARM_TEST__H_

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

class AlarmTest : public CppUnit::TestFixture {
public:
    AlarmTest();
    virtual ~AlarmTest() {}
    virtual void setUp();
    virtual void tearDown();

    // TODO: begin implementing tests
    void t_FirstTest();

    CPPUNIT_TEST_SUITE(AlarmTest);
    CPPUNIT_TEST(t_FirstTest);
    CPPUNIT_TEST_SUITE_END();
};

#endif // ALARM_TEST__H_
