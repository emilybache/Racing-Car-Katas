#include <gtest/gtest.h>

extern "C"
{
#include "alarm.h"
}

using namespace ::testing;

TEST(AlarmTest, AlarmIsOn)
{
    ASSERT_EQ(false, ALARM_ON);
}