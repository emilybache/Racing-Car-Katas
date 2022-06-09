//
//  StringEscapeUtils.swift
//  TextConverter
//
//  Created by Jonathan Beyrak-Lev on 09/06/2022.
//

import Foundation

extension String {
    var escapedHTML: String {
        replacingOccurrences(of: "&", with: "&amp;")
        .replacingOccurrences(of: "<", with: "&lt;")
        .replacingOccurrences(of: ">", with: "&gt;")
        .replacingOccurrences(of: "\"", with: "&quot;")
        .replacingOccurrences(of: "'", with: "&quot;")
    }
}
