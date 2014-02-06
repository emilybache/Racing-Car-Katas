package tddmicroexercises.textconvertor

import org.scalatest.{Matchers, FlatSpec}


class HtmlPagesConverterTest  extends FlatSpec with Matchers {
  it should "foo" in {
    val converter = new HtmlPagesConverter("foo")
    converter.filename shouldEqual "fixme"
  }
}