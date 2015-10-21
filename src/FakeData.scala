import scala.collection.immutable.HashMap

object FakeData {
  def getCostOfOneBook() = 8

  def getPercentDiscountForNumberOfBooks(numberOfBooks : Int) : BigDecimal = {
    val discountForNumberOfBooks: HashMap[Int, BigDecimal] = HashMap(2 -> .05, 3 -> .1, 4 -> .2, 5 -> .25)
    discountForNumberOfBooks.get(numberOfBooks) match {
      case Some(value) => value
      case None => BigDecimal(0)
    }
  }
}
