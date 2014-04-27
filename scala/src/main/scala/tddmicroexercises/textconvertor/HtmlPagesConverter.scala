package tddmicroexercises.textconvertor

import java.io.FileReader

import java.io.BufferedReader
import scala.util.control.Breaks._

class HtmlPagesConverter(val filename : String) {
  var breaks = List[Int](0)
  var reader = new BufferedReader(new FileReader(this.filename))
  var cumulativeCharCount = 0
  var line = reader.readLine()
  while (line != null)
  {
    cumulativeCharCount += line.length() + 1 // add one for the newline
    if (line.contains("PAGE_BREAK")) {
      val page_break_position = cumulativeCharCount
      breaks :+ page_break_position
    }
    line = reader.readLine()
  }
  reader.close()

  def getHtmlPage(page : Int) : String = {
    reader = new BufferedReader(new FileReader(filename))
    reader.skip(breaks(page))
    var htmlPage = new StringBuffer()
    var line = reader.readLine()
    while (line != null)
    {
      if (line.contains("PAGE_BREAK")) {
        break
      }
      htmlPage.append(StringEscapeUtils.escapeHtml(line))
      htmlPage.append("<br />")

      line = reader.readLine()
    }
    reader.close()
    return htmlPage.toString
  }
}