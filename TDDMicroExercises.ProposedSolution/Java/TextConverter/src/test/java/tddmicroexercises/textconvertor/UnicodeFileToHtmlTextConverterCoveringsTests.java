package tddmicroexercises.textconvertor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class UnicodeFileToHtmlTextConverterCoveringsTests {

	@Test
	// Regression test to ensure existing API is not broken
	public void shouldConvertFileContentsToHtmlEscapedString() throws IOException {
		String fullFilenameWithPath = this.getClass().getClassLoader().getResource("data.txt").getPath();
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(fullFilenameWithPath);
		assertEquals("hello<br />mum&amp;dad<br />less&lt;than<br />greater&gt;than<br />",converter.convertToHtml());
	}
}
