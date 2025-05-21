package tddmicroexercises.textconvertor

import java.io.IOException

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HtmlPagesConverterTest {
    @Test
    @Throws(IOException::class)
    fun foo() {
        val converter = HtmlPagesConverter("foo")
        assertEquals("fixme", converter.filename)
    }
}
