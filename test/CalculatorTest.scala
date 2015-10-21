
import org.scalatest.{ShouldMatchers, WordSpec}
class CalculatorTest extends WordSpec with ShouldMatchers {

  "Calculator" should {

    "charge 8 EUR for one of the first Harry Potter book" in {
      val order = Order(Seq(Book.BOOK_ONE))
      val total = Calculator.getTotal(order)

      total shouldBe "8.00"
    }

    "charge 16 EUR for two copies of the first Harry Potter book" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_ONE))
      val total = Calculator.getTotal(order)

      total shouldBe "16.00"

    }

    "charge 15.20 EUR for buying two different Harry Potter books" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_TWO))
      val total = Calculator.getTotal(order)

      total shouldBe "15.20"
    }
  }

}
