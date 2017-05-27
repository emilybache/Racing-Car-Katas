
using NUnit.Framework;
namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter
{
    [TestFixture]
    public class HikerTest
    {
        [Test]
        public void foobar()
        {
            UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter("foobar.txt");
            Assert.AreEqual("fixme", converter.GetFilename());
        }
    }
}
