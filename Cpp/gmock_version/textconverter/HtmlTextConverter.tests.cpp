#include "HtmlTextConverter.hpp"
#include <gtest/gtest.h>

using namespace ::testing;

TEST(HtmlTextConverter, can_open_a_file)
{
    std::string filename("foo.txt");
    HtmlTextConverter converter(filename);
    ASSERT_EQ(filename, converter.getFilename());
    ASSERT_EQ("", converter.convertToHtml());
}