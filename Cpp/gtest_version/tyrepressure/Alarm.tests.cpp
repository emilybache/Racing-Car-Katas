#include "Alarm.hpp"
#include <gtest/gtest.h>

using namespace ::testing;

TEST(Alarm, Foobar)
{
    Alarm *alarm = new Alarm();
    ASSERT_EQ(true, alarm->isAlarmOn());
}