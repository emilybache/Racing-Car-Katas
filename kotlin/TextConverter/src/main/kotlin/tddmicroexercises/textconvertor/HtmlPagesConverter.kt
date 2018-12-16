package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

class HtmlPagesConverter @Throws(IOException::class)
constructor(val filename: String) {
    private val breaks = ArrayList<Int>()

    init {

        this.breaks.add(0)
        val reader = BufferedReader(FileReader(this.filename))
        var cumulativeCharCount = 0
        var line: String? = reader.readLine()
        while (line != null) {
            cumulativeCharCount += line.length + 1 // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                val page_break_position = cumulativeCharCount
                breaks.add(page_break_position)
            }
            line = reader.readLine()
        }
        reader.close()
    }

    @Throws(IOException::class)
    fun getHtmlPage(page: Int): String {
        val reader = BufferedReader(FileReader(this.filename))
        reader.skip(breaks[page].toLong())
        val htmlPage = StringBuffer()
        var line: String? = reader.readLine()
        while (line != null) {
            if (line.contains("PAGE_BREAK")) {
                break
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line))
            htmlPage.append("<br />")

            line = reader.readLine()
        }
        reader.close()
        return htmlPage.toString()
    }

}
