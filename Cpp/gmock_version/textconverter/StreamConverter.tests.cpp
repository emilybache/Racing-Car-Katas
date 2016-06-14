#include "StreamConverter.hpp"
#include <gtest/gtest.h>

#include <sstream>

using namespace ::testing;

TEST(StreamConverter, newlines_become_br)
{
    std::stringstream reader("hej\npå\ndej\n");

    StreamConverter converter(reader);

    std::string htmlString = converter.convertToHtml();

    ASSERT_STREQ("hej<br>på<br>dej<br>", htmlString.c_str());
}