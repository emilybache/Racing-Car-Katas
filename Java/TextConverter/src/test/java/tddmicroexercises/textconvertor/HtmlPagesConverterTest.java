package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class HtmlPagesConverterTest {
    @Test
    public void foo() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter("foo");
        assertEquals("fixme", converter.getFilename());
    }
}
