using System.Collections.Generic;
using Xunit;

namespace TDDMicroExercises.LeaderBoard.Tests
{
    public class LeaderboardTest
    {
        [Fact]
        public void ShouldSumThePoints()
        {
            var results = TestData.SampleLeaderboard1.DriverResults();
            Assert.True(results.ContainsKey("Lewis Hamilton"));
            Assert.Equal(18 + 18 + 25, results["Lewis Hamilton"]);
        }

        [Fact]
        public void ShouldFindTheWinner()
        {
            Assert.Equal("Lewis Hamilton", TestData.SampleLeaderboard1.DriverRankings()[0]);
        }

        [Fact]
        public void ShouldKeepAllDriversWhenSamePoints()
        {
            var winDriver1 = new Race("Australian Grand Prix", TestData.Driver1, TestData.Driver2, TestData.Driver3);
            var winDriver2 = new Race("Malaysian Grand Prix", TestData.Driver2, TestData.Driver1, TestData.Driver3);
            var exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

            var rankings = exEquoLeaderBoard.DriverRankings();

            Assert.Equal(
                new List<string> { TestData.Driver2.Name, TestData.Driver1.Name, TestData.Driver3.Name },
                rankings);
        }
    }
}