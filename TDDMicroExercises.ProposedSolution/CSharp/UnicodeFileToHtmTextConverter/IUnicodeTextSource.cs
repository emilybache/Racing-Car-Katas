using System.IO;

namespace TDDMicroExercises.OneSolution.UnicodeFileToHtmTextConverter
{
    public interface IUnicodeTextSource
    {
        TextReader GetTextReader();
    }
}