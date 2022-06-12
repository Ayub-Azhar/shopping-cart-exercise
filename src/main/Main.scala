import item.Apple
import parser.FileParser
import service.CheckoutService

object Main extends App {

  val parser = new FileParser

  println(
    CheckoutService
      .calcOrderTotal(
        basket = parser.parseFile("src/main/resources/basket.txt")
      )
  )
}