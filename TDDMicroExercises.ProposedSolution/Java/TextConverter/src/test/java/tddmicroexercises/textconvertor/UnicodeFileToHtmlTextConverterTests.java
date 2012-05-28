package tddmicroexercises.textconvertor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class UnicodeFileToHtmlTextConverterTests {

	@Test
	// Regression test to ensure existing API is not broken
	public void shouldConvertFileContentsToHtmlEscapedString() throws IOException {
		String fullFilenameWithPath = this.getClass().getClassLoader().getResource("data.txt").getPath();
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(fullFilenameWithPath);
		assertEquals("hello<br />mum&amp;dad<br />less&lt;than<br />greater&gt;than<br />",converter.convertToHtml());
	}
	
	@Test
	public void shouldEscapeTheEscapableCharactersInInputString() throws IOException{
		UnicodeDataSourceStub stubReader = new UnicodeDataSourceStub();
		stubReader.setLine("mum&dad lessthan< greaterthan>");
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(stubReader);
		assertEquals("mum&amp;dad lessthan&lt; greaterthan&gt;<br />", converter.convertToHtml());
	}
	
	@Test
	public void shouldAddLineBreakAtEndOfEveryInputLine() throws IOException{
		UnicodeDataSourceStub stubReader = new UnicodeDataSourceStub();
		stubReader.setLine("hello");
		stubReader.setLine("mum dad");
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(stubReader);
		assertEquals("mum dad<br />hello<br />", converter.convertToHtml());
	}
	
	@Test
	public void shouldNotEscapeTheNonEscapableCharactersInInputString() throws IOException{
		UnicodeDataSourceStub stubReader = new UnicodeDataSourceStub();
		stubReader.setLine("mum dad lessthan greaterthan");
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(stubReader);
		assertEquals("mum dad lessthan greaterthan<br />", converter.convertToHtml());
	}
	
	@Test
	public void shouldReturnEmptyStringForNoInput() throws IOException{
		UnicodeDataSourceStub stubReader = new UnicodeDataSourceStub();
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(stubReader);
		assertEquals("", converter.convertToHtml());
	}
}
