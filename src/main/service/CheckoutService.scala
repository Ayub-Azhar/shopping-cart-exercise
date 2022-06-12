package service

import item.{Apple, Item, Orange}

object CheckoutService {

  def calcOrderTotal(basket: List[Item],
                     bogofItems: Set[Item] = Set(Apple),
                     tftItems: Set[Item] = Set(Orange)): BigDecimal = {

    def applyBogofDiscount(item: Item): BigDecimal = {
      val itemCount = basket.count(_.equals(item))
      (itemCount / 2).floor * item.price
    }

    def applyTftDiscount(item: Item): BigDecimal = {
      basket
        .filter(_ == item)
        .grouped(3)
        .count(_.size == 3) * item.price
    }

    val bogofDiscount = bogofItems.map(applyBogofDiscount).sum

    val tftDiscount = tftItems.map(applyTftDiscount).sum

    basket.map(_.price).sum - bogofDiscount - tftDiscount
  }
}