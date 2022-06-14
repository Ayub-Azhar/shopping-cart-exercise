package service

import item.{Apple, Banana, Item, Orange}

object CheckoutService {

  def calcOrderTotal(basket: List[Item],
                     bogofItems: Set[Item] = Set(),
                     tftItems: Set[Item] = Set()): BigDecimal = {

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

    if(basket.contains(Apple) && basket.contains(Banana)) {

      val totalAppleCost = basket.filter(_ == Apple).map(applyBogofDiscount).sum

      val totalBananaCost = basket.filter(_ == Banana).map(applyBogofDiscount).sum

      val cheapestRemoved: BigDecimal = (totalAppleCost, totalBananaCost) match {
        case (a, b) if a > b => a
        case (a, b) if a < b => b
        case _               => totalAppleCost
      }

      val bogofDiscount = bogofItems
          .filterNot(x => x == Apple || x == Banana)
          .map(applyBogofDiscount).sum

      val tftDiscount = tftItems
        .filterNot(x => x == Apple || x == Banana)
        .map(applyTftDiscount).sum

      basket.map(_.price).sum - bogofDiscount - tftDiscount - cheapestRemoved
    } else {
      basket.map(_.price).sum - bogofDiscount - tftDiscount
    }
  }
}