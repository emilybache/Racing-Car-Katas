package tddmicroexercises.textconvertor

import java.io.{FileReader, BufferedReader}


class HtmlTextConverter(val fullFilenameWithPath : String) {

  def convertToHtml() : String  = {

    val reader = new BufferedReader(new FileReader(fullFilenameWithPath))

    var line = reader.readLine()
    var html = ""
    while (line != null)
    {
      html += StringEscapeUtils.escapeHtml(line)
      html += "<br />"
      line = reader.readLine()
    }
    return html

  }

}