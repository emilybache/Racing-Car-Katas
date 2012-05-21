using NUnit.Framework;

namespace TDDMicroExercises.OneSolution.UnicodeFileToHtmTextConverter.Tests
{
    [TestFixture]
    public class UnicodeFileToHtmTextConverterTest
    {
        [Test]
        public void should_convert_ampersand()
        {
            StubUnicodeTextSource stubSource = new StubUnicodeTextSource();
            stubSource.StubCallToGetTextReader("Cut & Paste");

            UnicodeFileToHtmTextConverter target = new UnicodeFileToHtmTextConverter(stubSource);
            string result = target.ConvertToHtml();

            Assert.AreEqual(result, "Cut &amp; Paste<br />", "html converted text");
        }

        [Test]
        public void should_convert_greate_than_and_less_than()
        {
            StubUnicodeTextSource stubSource = new StubUnicodeTextSource();
            stubSource.StubCallToGetTextReader("10 > 5; 5 < 10");

            UnicodeFileToHtmTextConverter target = new UnicodeFileToHtmTextConverter(stubSource);
            string result = target.ConvertToHtml();

            Assert.AreEqual(result, "10 &gt; 5; 5 &lt; 10<br />", "html converted text");
        }

        [Test]
        public void should_add_breakline_for_multiple_lines()
        {
            StubUnicodeTextSource stubSource = new StubUnicodeTextSource();
            stubSource.StubCallToGetTextReader("hello\nhow are you doing?");

            UnicodeFileToHtmTextConverter target = new UnicodeFileToHtmTextConverter(stubSource);
            string result = target.ConvertToHtml();

            Assert.AreEqual(result, "hello</b>how are you doing?<br />", "html converted text");
        }

    }
}
