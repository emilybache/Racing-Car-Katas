//
//  HTMLPagesConverter.swift
//  TextConverter
//
//  Created by Jonathan Beyrak-Lev on 09/06/2022.
//

import Foundation

class HtmlPagesConverter {

    let filename: String
    private var breaks = [UInt64]()

    init(filename: String) throws {
        self.filename = filename;
        breaks.append(0)
        guard let reader = StreamReader(path: filename) else { throw NSError(domain: "", code: 0, userInfo: [:]) }
        defer { reader.close() }
        var cumulativeCharCount: UInt64 = 0
        var line = reader.nextLine()
        while (line != nil)
        {
            cumulativeCharCount += UInt64(line!.count + 1) // add one for the newline
            if (line!.contains("PAGE_BREAK")) {
                let page_break_position = cumulativeCharCount
                breaks.append(page_break_position)
            }
            line = reader.nextLine()
        }
        reader.close();
    }

    func getHtmlPage(page: Int) throws -> String {
        guard let reader = StreamReader(path: filename) else { throw NSError(domain: "", code: 0, userInfo: [:]) }
        defer { reader.close() }
        try reader.skip(breaks[page])
        var htmlPage = ""
        var line = reader.nextLine()
        while (line != nil)
        {
            if line!.contains("PAGE_BREAK") {
                break
            }
            htmlPage += line!.escapedHTML
            htmlPage += ("<br />")
            line = reader.nextLine()
        }
        reader.close();
        return htmlPage
    }
}
