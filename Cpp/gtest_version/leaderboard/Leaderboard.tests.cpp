#include "TestData.hpp"
#include <gtest/gtest.h>

#include <map>
#include <string>

using namespace ::testing;

TEST(Leaderboard, SumThePoints)
{
    std::map<std::string, int> results = TestData::sampleLeaderboard1.driverResults();
    ASSERT_NE(results.end(), results.find("Lewis Hamilton"));
    ASSERT_EQ((18 + 18 + 25), results["Lewis Hamilton"]);  
}

TEST(Leaderboard, FindTheWinner)
{
    ASSERT_EQ(0, TestData::sampleLeaderboard1.driverRankings().front().compare("Lewis Hamilton"));  
}

TEST(Leaderboard, KeepAllDriversWhenSamePoints)
{
    // bug, drops drivers with same points
    Race winDriver1("Australian Grand Prix", TestData::CreateDriverList(TestData::driver1, TestData::driver2, TestData::driver3));
    Race winDriver2("Malaysian Grand Prix", TestData::CreateDriverList(TestData::driver2, TestData::driver1, TestData::driver3));
    Leaderboard exEquoLeaderBoard(TestData::CreateRaceList(winDriver1, winDriver2));

    std::list<std::string> rankings = exEquoLeaderBoard.driverRankings();
    std::list<std::string>::const_iterator r = rankings.begin();
    ASSERT_EQ(TestData::driver2.getName(), *r); ++r;
    ASSERT_EQ(TestData::driver1.getName(), *r); ++r;
    ASSERT_EQ(TestData::driver3.getName(), *r); ++r;
    // note: the order of driver1 and driver2 is runtime/platform dependent
}