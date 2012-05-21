using System.IO;
using System.Web;

namespace TDDMicroExercises.OneSolution.UnicodeFileToHtmTextConverter
{
    public class UnicodeFileToHtmTextConverter
    {
        private IUnicodeTextSource _textSource;

        public UnicodeFileToHtmTextConverter(string fullFilenameWithPath)
            : this (new UnicodeTextSourceFromFile(fullFilenameWithPath))
        {
        }

        public UnicodeFileToHtmTextConverter(IUnicodeTextSource textSource)
        {
            _textSource = textSource;
        }

        public string ConvertToHtml()
        {
            using (TextReader unicodeFileStream = _textSource.GetTextReader())
            {
                string html = string.Empty;

                string line = unicodeFileStream.ReadLine();
                while (line != null)
                {
                    html += HttpUtility.HtmlEncode(line);
                    html += "<br />";
                    line = unicodeFileStream.ReadLine();
                }

                return html;
            }
        }
    }
}
