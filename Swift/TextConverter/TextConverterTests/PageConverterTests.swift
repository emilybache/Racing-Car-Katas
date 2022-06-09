//
//  PageConverterTests.swift
//  TextConverterTests
//
//  Created by Jonathan Beyrak-Lev on 09/06/2022.
//

import XCTest
@testable import TextConverter

class PageConverterTests: XCTestCase {

    func testFoo() {
        let converter = try! HtmlPagesConverter(filename: "foo")
        XCTAssertEqual("fixme", converter.filename)
    }
}
