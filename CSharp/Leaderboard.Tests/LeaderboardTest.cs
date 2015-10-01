using System.Collections.Generic;
using NUnit.Framework;

namespace TDDMicroExercises.LeaderBoard.Tests
{
    public class LeaderboardTest
    {
        [Test]
        public void ShouldSumThePoints()
        {
            var results = TestData.SampleLeaderboard1.DriverResults();
            Assert.IsTrue(results.ContainsKey("Lewis Hamilton"));
            Assert.AreEqual(18 + 18 + 25, results["Lewis Hamilton"]);
        }

        [Test]
        public void ShouldFindTheWinner()
        {
            Assert.AreEqual("Lewis Hamilton", TestData.SampleLeaderboard1.DriverRankings()[0]);
        }

        [Test]
        public void ShouldKeepAllDriversWhenSamePoints()
        {
            var winDriver1 = new Race("Australian Grand Prix", TestData.Driver1, TestData.Driver2, TestData.Driver3);
            var winDriver2 = new Race("Malaysian Grand Prix", TestData.Driver2, TestData.Driver1, TestData.Driver3);
            var exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

            var rankings = exEquoLeaderBoard.DriverRankings();

            CollectionAssert.AreEqual(
                new List<string> {TestData.Driver2.Name, TestData.Driver1.Name, TestData.Driver3.Name},
                rankings);
        }
    }
}