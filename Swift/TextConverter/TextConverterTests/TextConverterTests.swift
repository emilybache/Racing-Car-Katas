//
//  TextConverterTests.swift
//  TextConverterTests
//
//  Created by Jonathan Beyrak-Lev on 09/06/2022.
//

import XCTest
@testable import TextConverter

class TextConverterTests: XCTestCase {
    func testFoo() {
        let converter = HtmlTextConverter(fullFilenameWithPath: "foo")
        XCTAssertEqual("fixme", converter.fullFilenameWithPath)
    }
}

