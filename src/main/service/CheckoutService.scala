package service

import item.Item

object CheckoutService {

  def calcOrderTotal(basket: List[Item]): BigDecimal = {
    basket.map(_.price).sum
  }
}
