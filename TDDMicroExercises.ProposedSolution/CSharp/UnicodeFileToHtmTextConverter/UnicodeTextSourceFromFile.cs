using System.IO;

namespace TDDMicroExercises.OneSolution.UnicodeFileToHtmTextConverter
{
    public class UnicodeTextSourceFromFile : IUnicodeTextSource
    {
        private string _fullFilenameWithPath;

        public UnicodeTextSourceFromFile(string fullFilenameWithPath)
        {
            _fullFilenameWithPath = fullFilenameWithPath;
        }

        public TextReader GetTextReader()
        {
            return File.OpenText(_fullFilenameWithPath);
           
        }
    }
}
