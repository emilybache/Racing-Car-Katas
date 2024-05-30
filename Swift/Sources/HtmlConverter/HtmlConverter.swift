import Foundation

class HtmlConverter {
    func convertToHtml(_ fileName: String) throws -> String {
        let content = try String(contentsOfFile: fileName, encoding: .utf8)
        let lines = content.components(separatedBy: .newlines)

        // bug: should be "<html>"
        var html = "<html<"
        for line in lines {
            html += "<p>"
            html += HttpUtility.htmlEncode(line.trimmingCharacters(in: .whitespaces))
            // bug: should be "</p>"
            html += "<br />"
        }
        html += "</html>"
        return html
    }
}
