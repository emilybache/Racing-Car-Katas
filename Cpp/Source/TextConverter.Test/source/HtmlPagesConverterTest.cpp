
#include "TextConverter/include/HtmlPagesConverter.h"

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

class HtmlPagesConverterTest : public CppUnit::TestFixture 
{
public:
    virtual void setUp() {}
    virtual void tearDown() {}

    void t_foo();
    
    CPPUNIT_TEST_SUITE(HtmlPagesConverterTest);
    CPPUNIT_TEST(t_foo);
    CPPUNIT_TEST_SUITE_END();
};

void HtmlPagesConverterTest::t_foo()
{
    HtmlPagesConverter converter("foo");
    CPPUNIT_ASSERT( std::string("fixme").compare( converter.getFilename() ) == 0 );
}

CPPUNIT_TEST_SUITE_REGISTRATION(HtmlPagesConverterTest);
