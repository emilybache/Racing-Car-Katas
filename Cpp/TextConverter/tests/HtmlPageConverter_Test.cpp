#include <gmock/gmock.h>
#include "HtmlPagesConverter.h"

namespace {
  TEST(Alarm, Foo) {
        auto converter = new HtmlPagesConverter("foo");
        ASSERT_EQ("fixme", converter->getFilename());
  }
}


