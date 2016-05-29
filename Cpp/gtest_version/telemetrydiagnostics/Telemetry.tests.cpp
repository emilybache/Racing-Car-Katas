
#include "TelemetryDiagnosticControls.hpp"
#include <gtest/gtest.h>

using namespace ::testing;

TEST(TelemetryDiagnosticControls, SendDiagnosticMessageAndReceiveStatusResponse)
{
    TelemetryDiagnosticControls controls;
    controls.checkTransmission();
    ASSERT_EQ(false, controls.getDiagnosticInfo().empty());
}