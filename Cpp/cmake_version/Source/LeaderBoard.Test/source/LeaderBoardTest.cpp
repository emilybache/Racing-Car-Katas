
#include "../include/TestData.h"

#include <cppunit/TestCase.h>
#include <cppunit/TestFixture.h>
#include <cppunit/extensions/HelperMacros.h>

#include <map>
#include <string>

class LeaderboardTest : public CppUnit::TestFixture 
{
public:
    virtual void setUp() {}
    virtual void tearDown() {}

    void t_SumThePoints();
    void t_FindTheWinner();
    void t_KeepAllDriversWhenSamePoints();
    
    
    CPPUNIT_TEST_SUITE(LeaderboardTest);
    CPPUNIT_TEST(t_SumThePoints);
    CPPUNIT_TEST(t_FindTheWinner);
    CPPUNIT_TEST(t_KeepAllDriversWhenSamePoints);
    CPPUNIT_TEST_SUITE_END();
};

void LeaderboardTest::t_SumThePoints()
{
    std::map<std::string, int> results = TestData::sampleLeaderboard1.driverResults();
    CPPUNIT_ASSERT(results.end() != results.find("Lewis Hamilton"));
    CPPUNIT_ASSERT((18 + 18 + 25) == results["Lewis Hamilton"]);
}

void LeaderboardTest::t_FindTheWinner()
{
    CPPUNIT_ASSERT(0 == TestData::sampleLeaderboard1.driverRankings().front().compare("Lewis Hamilton"));
}

void LeaderboardTest::t_KeepAllDriversWhenSamePoints()
{
    // bug, drops drivers with same points
    Race winDriver1("Australian Grand Prix", TestData::CreateDriverList(TestData::driver1, TestData::driver2, TestData::driver3));
    Race winDriver2("Malaysian Grand Prix", TestData::CreateDriverList(TestData::driver2, TestData::driver1, TestData::driver3));
    Leaderboard exEquoLeaderBoard(TestData::CreateRaceList(winDriver1, winDriver2));

    std::list<std::string> rankings = exEquoLeaderBoard.driverRankings();
    std::list<std::string>::const_iterator r = rankings.begin();
    CPPUNIT_ASSERT(TestData::driver2.getName() == *r); ++r;
    CPPUNIT_ASSERT(TestData::driver1.getName() == *r); ++r;
    CPPUNIT_ASSERT(TestData::driver3.getName() == *r); ++r;
    // note: the order of driver1 and driver2 is runtime/platform dependent
}

CPPUNIT_TEST_SUITE_REGISTRATION(LeaderboardTest);
