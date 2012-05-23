package tddmicroexercises.textconvertor;

import java.io.File;
import java.io.FileReader;

public class UnicodeFileToHtmTextConverter
{
    private String _fullFilenameWithPath;


    public UnicodeFileToHtmTextConverter(String fullFilenameWithPath)
    {
        _fullFilenameWithPath = fullFilenameWithPath;
    }

    public String ConvertToHtml(){
    
    File file = new File(_fullFilenameWithPath);
    FileReader filereader = new FileReader(file);
    
    filereader.
    
    {
        using (TextReader unicodeFileStream = File.OpenText(_fullFilenameWithPath))
        {
            String html = "";

            String line = unicodeFileStream.ReadLine();
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
