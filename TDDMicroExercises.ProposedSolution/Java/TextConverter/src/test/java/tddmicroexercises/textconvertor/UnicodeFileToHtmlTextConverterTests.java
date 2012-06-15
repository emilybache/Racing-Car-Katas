package tddmicroexercises.textconvertor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class UnicodeFileToHtmlTextConverterTests {

	@Test
	public void shouldEscapeAmpersand() throws IOException{
		UnicodeDataSourceStub stubReader = new UnicodeDataSourceStub();
		stubReader.setLine("mum&dad");
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(stubReader);
		assertEquals("mum&amp;dad<br />", converter.convertToHtml());
	}
	
	@Test
	public void shouldEscapeLessThanAndGreaterThan() throws IOException{
		UnicodeDataSourceStub stubReader = new UnicodeDataSourceStub();
		stubReader.setLine("lessthan< greaterthan>");
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(stubReader);
		assertEquals("lessthan&lt; greaterthan&gt;<br />", converter.convertToHtml());
	}

	@Test
	public void shouldAddLineBreakAtEndOfEveryInputLine() throws IOException{
		UnicodeDataSourceStub stubReader = new UnicodeDataSourceStub();
		stubReader.setLine("hello");
		stubReader.setLine("mum dad");
		UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(stubReader);
		assertEquals("mum dad<br />hello<br />", converter.convertToHtml());
	}
}
