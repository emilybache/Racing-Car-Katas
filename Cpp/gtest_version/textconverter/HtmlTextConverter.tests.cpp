#include "HtmlTextConverter.hpp"
#include <gtest/gtest.h>

using namespace ::testing;

TEST(HtmlTextConverter, foo)
{
    HtmlTextConverter converter("foo");
    ASSERT_EQ(std::string("fixme"), converter.getFilename());
}