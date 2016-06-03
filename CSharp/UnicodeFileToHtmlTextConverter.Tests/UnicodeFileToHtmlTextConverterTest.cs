
using NUnit.Framework;
namespace TDDMicroExercises.UnicodeFileToHtmTextConverter
{
    [TestFixture]
    public class HikerTest
    {
        [Test]
        public void foobar()
        {
            UnicodeFileToHtmTextConverter converter = new UnicodeFileToHtmTextConverter("foobar.txt");
            Assert.AreEqual("fixme", converter.GetFilename());
        }
    }
}
