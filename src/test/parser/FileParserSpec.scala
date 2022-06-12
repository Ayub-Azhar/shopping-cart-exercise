package parser

import item.{Apple, Orange}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FileParserSpec extends AnyWordSpec with Matchers {

  "parseFile" should {
    "return a list of 2 Apples and 2 Oranges" when {
      "each line is either Apple or Orange" in {
        val parser = new FileParser
        val result = parser.parseFile("src/test/resources/basket_example.txt")
        result shouldBe List(Apple, Orange, Apple, Orange)
      }
    }
  }
}
