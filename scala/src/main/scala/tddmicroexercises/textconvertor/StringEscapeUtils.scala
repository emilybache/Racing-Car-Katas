package tddmicroexercises.textconvertor


object StringEscapeUtils {
  def escapeHtml(input : String) : String = {
    var output = input
    output = output.replace("&", "&amp;")
    output = output.replace("'", "&quot;")
    output = output.replace("<", "&lt;")
    output = output.replace(">", "&gt;")
    output = output.replace("\"", "&quot;")
    return output
  }

}