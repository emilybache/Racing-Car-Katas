#include "TestData.hpp"
#include <gtest/gtest.h>

#include <map>
#include <string>

using namespace ::testing;

TEST(Race, CalculateDriverPoints)
{
    ASSERT_EQ(25, TestData::race1.getPoints(TestData::driver1));
    ASSERT_EQ(18, TestData::race1.getPoints(TestData::driver2));
    ASSERT_EQ(15, TestData::race1.getPoints(TestData::driver3));
}