import models.{Discount, Order}

import scala.collection.immutable.IndexedSeq
import scala.math.BigDecimal.RoundingMode

object Calculator {

  def calculateDiscount(discounts: Seq[Discount]):  BigDecimal = {

    val totalDiscounted: Seq[BigDecimal] = for (discount <- discounts) yield {
      val percentDiscount: BigDecimal = FakeData.getPercentDiscountForNumberOfBooks(discount.numberOfBooks)
      val cost: BigDecimal = discount.numberOfBooks * FakeData.getCostOfOneBook()
      (cost * percentDiscount).setScale(2, RoundingMode.HALF_UP)
    }
    totalDiscounted.sum
  }

  def findAllDiscounts(order: Order) : Seq[Discount] = {
    val numberOfBooks: Map[models.Book.Book, Int] = order.books.groupBy(l => l).map(t => (t._1, t._2.length))
    val discounts: IndexedSeq[Discount] = (1 to numberOfBooks.values.max).map(size => Discount(numberOfBooks.values.count(bookCount => bookCount >= size)))
    discounts.toSeq
  }

  def calculateTotal(order: Order): String  = {
    val total: BigDecimal = BigDecimal(order.books.size * FakeData.getCostOfOneBook())
    val discount: BigDecimal = calculateDiscount(findAllDiscounts(order))
    (total - discount).setScale(2, RoundingMode.HALF_UP).toString()
  }


}
