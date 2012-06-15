package tddmicroexercises.textconvertor;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

public class UnicodeFileToHtmlTextConverter
{
    private UnicodeDataSource reader;

    public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) throws FileNotFoundException
    {
        reader = new FileUnicodeDataSource(fullFilenameWithPath);
    }
    
    public UnicodeFileToHtmlTextConverter(UnicodeDataSource reader) {
		this.reader = reader;
	}

	public String convertToHtml() throws IOException{
	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	            html += StringEscapeUtils.escapeHtml(line);
	            html += "<br />";
	            line = reader.readLine();
	    }
	    return html;
    }
}
