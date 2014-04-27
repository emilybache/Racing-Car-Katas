package tddmicroexercises.textconvertor

import org.scalatest.{Matchers, FlatSpec}


class HtmlTextConverterTest  extends FlatSpec with Matchers {
  it should "foo" in {
    val converter = new HtmlTextConverter("foo");
    converter.fullFilenameWithPath shouldEqual "fixme"
  }
}