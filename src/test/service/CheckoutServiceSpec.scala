package service

import item.{Apple, Orange}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CheckoutServiceSpec extends AnyWordSpec with Matchers {

  "calcOrderTotal" should {
    "return the correct total cost" when {
      "the basket contains 1 Apple and 1 Orange" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Apple, Orange),
          ) shouldBe (Apple.price + Orange.price)
      }
      "the basket contains 3 Apples and 0 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Apple, Apple, Apple)
          ) shouldBe Apple.price * 3
      }
      "the basket contains 0 Apples and 3 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Orange, Orange, Orange)
          ) shouldBe Orange.price * 3
      }
      "the basket contains no items" in {
        CheckoutService
          .calcOrderTotal(
            basket = List()
          ) shouldBe 0
      }
    }
  }
}
