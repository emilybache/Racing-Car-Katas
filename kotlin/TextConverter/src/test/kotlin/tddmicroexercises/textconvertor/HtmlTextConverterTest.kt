package tddmicroexercises.textconvertor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HtmlTextConverterTest {
    @Test
    fun foo() {
        val converter = HtmlTextConverter("foo")
        assertEquals("fixme", converter.filename)
    }
}
