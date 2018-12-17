package tddmicroexercises.textconvertor

internal object StringEscapeUtils {

    fun escapeHtml(input: String): String {
        var output = input
        output = output.replace("&", "&amp;")
        output = output.replace("<", "&lt;")
        output = output.replace(">", "&gt;")
        output = output.replace("\"", "&quot;")
        output = output.replace("'", "&quot;")
        return output
    }

}
