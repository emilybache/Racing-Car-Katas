using System.IO;

namespace TDDMicroExercises.OneSolution.UnicodeFileToHtmTextConverter.Tests
{
    public class StubUnicodeTextSource : IUnicodeTextSource
    {
        private string _text;

        public void StubCallToGetTextReader(string returnedText)
        {
            _text = returnedText;
        }

        TextReader IUnicodeTextSource.GetTextReader()
        {
            return new StringReader(_text);
        }
    }
}
