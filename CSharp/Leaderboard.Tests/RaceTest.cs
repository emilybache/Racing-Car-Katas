using NUnit.Framework;

namespace TDDMicroExercises.LeaderBoard.Tests
{
    public class RaceTest
    {
        [Test]
        public void ShouldCalculateDriverPoints()
        {
            Assert.AreEqual(25, TestData.Race1.GetPoints(TestData.Driver1));
            Assert.AreEqual(18, TestData.Race1.GetPoints(TestData.Driver2));
            Assert.AreEqual(15, TestData.Race1.GetPoints(TestData.Driver3));
        }
    }
}