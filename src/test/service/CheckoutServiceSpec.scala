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
            bogofItems = Set(),
            tftItems = Set()
          ) shouldBe (Apple.price + Orange.price)
      }
      "the basket contains 3 Apples and 0 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Apple, Apple, Apple),
            bogofItems = Set(),
            tftItems = Set()
          ) shouldBe Apple.price * 3
      }
      "the basket contains 0 Apples and 3 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Orange, Orange, Orange),
            bogofItems = Set(),
            tftItems = Set()
          ) shouldBe Orange.price * 3
      }
      "the basket contains no items" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(),
            bogofItems = Set(),
            tftItems = Set()
          ) shouldBe 0
      }
    }
    "return the correct cost with buy-one-get-one-free on Apples and three-for-two on Oranges" when {
      "the basket contains 2 Apples and 3 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Apple, Apple, Orange, Orange, Orange),
            bogofItems = Set(Apple),
            tftItems = Set(Orange)
          ) shouldBe (Apple.price + Orange.price*2)
      }
      "the basket contains 3 Apples and 4 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Apple, Apple, Apple, Orange, Orange, Orange, Orange),
            bogofItems = Set(Apple),
            tftItems = Set(Orange)
          ) shouldBe (Apple.price*2 + Orange.price*3)
      }
      "the basket contains 1 Apple and 2 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Apple, Orange, Orange),
            bogofItems = Set(Apple),
            tftItems = Set(Orange)
          ) shouldBe (Apple.price + Orange.price*2)
      }
    }
    "return the correct cost when there are no promotions set for Apples or Oranges" when {
      "the basket contains 3 Apples and 4 Oranges" in {
        CheckoutService
          .calcOrderTotal(
            basket = List(Apple, Apple, Apple, Orange, Orange, Orange, Orange),
            bogofItems = Set(),
            tftItems = Set()
          ) shouldBe (Apple.price*3 + Orange.price*4)
      }
    }
  }
}
