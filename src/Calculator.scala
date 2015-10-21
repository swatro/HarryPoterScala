import models.Order

import scala.math.BigDecimal.RoundingMode

object Calculator {

  def getDiscount(numberOfUniqueBooks: Int, total: BigDecimal):  BigDecimal = {
    (FakeData.getPercentDiscountForNumberOfBooks(numberOfUniqueBooks) * total).setScale(2, RoundingMode.HALF_UP)
  }

  def getTotal(order: Order): String  = {
    val total: BigDecimal = BigDecimal(order.books.size * 8)
    val discount: BigDecimal = getDiscount(order.books.distinct.size, total)
    (total - discount).setScale(2, RoundingMode.HALF_UP).toString()
  }

}
