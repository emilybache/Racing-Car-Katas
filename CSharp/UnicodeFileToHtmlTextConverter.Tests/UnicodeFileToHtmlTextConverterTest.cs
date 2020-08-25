
using Xunit;
namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter
{
    public class HikerTest
    {
        [Fact]
        public void Foobar()
        {
            UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter("foobar.txt");
            Assert.Equal("fixme", converter.GetFilename());
        }
    }
}
