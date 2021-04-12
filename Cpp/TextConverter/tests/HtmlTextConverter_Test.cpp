#include <gmock/gmock.h>
#include "HtmlTextConverter.h"

namespace {
  TEST(Alarm, Foo) {
        auto converter = new HtmlTextConverter("foo");
        ASSERT_EQ("fixme", converter->getFilename());

    }
}

