//
//  HtmlTextConverter.swift
//  TextConverter
//
//  Created by Jonathan Beyrak-Lev on 09/06/2022.
//

import Foundation

class HtmlTextConverter {
    let fullFilenameWithPath: String

    init(fullFilenameWithPath: String) {
        self.fullFilenameWithPath = fullFilenameWithPath;
    }

    func convertToHtml() throws -> String {

        guard let reader = StreamReader(path: fullFilenameWithPath) else { throw NSError(domain: "", code: 0, userInfo: [:]) }
        defer { reader.close() }

        var line = reader.nextLine();
        var html = "";
        while (line != nil)
        {
            html += line!.escapedHTML
            html += "<br />";
            line = reader.nextLine();
        }
        return html;
    }
}
