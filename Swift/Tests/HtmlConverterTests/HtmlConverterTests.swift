import XCTest

final class HtmlConverterTests: XCTestCase {
    func test_convertToHtml_usesValidHtmlTags() {
        // TODO: write this test
    }

    func test_convertToHtml_usesValidParagraphTags() {
        // TODO: write this test
    }
}

fileprivate class StubTwoLinesFileReader {
    func readLines() -> [String] {
        [
            "first line",
            "    second line"
        ]
    }
}

fileprivate class EmptyLinesFileReader {
    func readLines() -> [String] {
        []
    }
}
