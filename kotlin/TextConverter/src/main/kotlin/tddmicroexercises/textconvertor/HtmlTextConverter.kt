package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class HtmlTextConverter(val filename: String) {

    @Throws(IOException::class)
    fun convertToHtml(): String {

        val reader = BufferedReader(FileReader(filename))

        var line: String? = reader.readLine()
        var html = ""
        while (line != null) {
            html += StringEscapeUtils.escapeHtml(line)
            html += "<br />"
            line = reader.readLine()
        }
        return html

    }
}
