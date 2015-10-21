
import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

class CalculatorTest extends WordSpec with ShouldMatchers {

  "Calculator" should {

    "charge 8 EUR for one of the first Harry Potter book" in {
      val order = Order(Seq(Book("BOOK_ONE")))
      val total = Calculator.getTotal(order)

      total should equal("8.00")
    }
  }

}
