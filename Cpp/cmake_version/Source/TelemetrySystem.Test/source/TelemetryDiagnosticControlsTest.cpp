
#include "TelemetrySystem/include/TelemetryClient.h"
#include "TelemetrySystem/include/TelemetryDiagnosticControls.h"

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

class TelemetryDiagnosticControlsTest : public CppUnit::TestFixture 
{
public:
    virtual void setUp() {}
    virtual void tearDown() {}

    void t_SendDiagnosticMessageAndReceiveStatusResponse();
    
    CPPUNIT_TEST_SUITE(TelemetryDiagnosticControlsTest);
    CPPUNIT_TEST(t_SendDiagnosticMessageAndReceiveStatusResponse);
    CPPUNIT_TEST_SUITE_END();
};

void TelemetryDiagnosticControlsTest::t_SendDiagnosticMessageAndReceiveStatusResponse()
{
    TelemetryDiagnosticControls controls;
    controls.checkTransmission();
    CPPUNIT_ASSERT(!controls.getDiagnosticInfo().empty());
}

CPPUNIT_TEST_SUITE_REGISTRATION(TelemetryDiagnosticControlsTest);
