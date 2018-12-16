package tddmicroexercises.textconvertor

import org.junit.Test
import java.io.IOException

import org.junit.Assert.*

class HtmlPagesConverterTest {
    @Test
    @Throws(IOException::class)
    fun foo() {
        val converter = HtmlPagesConverter("foo")
        assertEquals("fixme", converter.filename)
    }
}
