
#include "TextConverter/include/HtmlTextConverter.h"

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

class HtmlTextConverterTest : public CppUnit::TestFixture 
{
public:
    virtual void setUp() {}
    virtual void tearDown() {}

    void t_foo();
    
    CPPUNIT_TEST_SUITE(HtmlTextConverterTest);
    CPPUNIT_TEST(t_foo);
    CPPUNIT_TEST_SUITE_END();
};

void HtmlTextConverterTest::t_foo()
{
    HtmlTextConverter converter("foo");
    CPPUNIT_ASSERT( std::string("fixme").compare( converter.getFilename() ) == 0 );
}

CPPUNIT_TEST_SUITE_REGISTRATION(HtmlTextConverterTest);
