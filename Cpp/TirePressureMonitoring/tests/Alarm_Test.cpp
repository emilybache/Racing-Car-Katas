#include <gmock/gmock.h>
#include "Alarm.h"

namespace {
  TEST(Alarm, Foo) {
    auto alarm = new Alarm();
    ASSERT_EQ(false, alarm->isAlarmOn());
  }
}
