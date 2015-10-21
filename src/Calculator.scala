import scala.math.BigDecimal.RoundingMode

object Calculator {

  def getTotal(order: Order) = BigDecimal(order.books.size * 8).setScale(2,RoundingMode.HALF_UP).toString

}
