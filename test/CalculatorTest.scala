
import models.{Order, Book}
import org.scalatest.{ShouldMatchers, WordSpec}
class CalculatorTest extends WordSpec with ShouldMatchers {

  "Calculator" should {

    "charge 8 EUR for one of the first Harry Potter book" in {
      val order = Order(Seq(Book.BOOK_ONE))
      val total = Calculator.calculateTotal(order)

      total shouldBe "8.00"
    }

    "charge 16 EUR for two copies of the first Harry Potter book" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_ONE))
      val total = Calculator.calculateTotal(order)

      total shouldBe "16.00"

    }

    "charge 15.20 EUR for buying two different Harry Potter books" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_TWO))
      val total = Calculator.calculateTotal(order)

      total shouldBe "15.20"
    }

    "charge 21.60 EUR for buying three different Harry Potter books" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_THREE))
      val total = Calculator.calculateTotal(order)

      total shouldBe "21.60"
    }

    "charge 25.60 for buying four different Harry Potter books" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_THREE, Book.BOOK_FOUR))
      val total = Calculator.calculateTotal(order)

      total shouldBe "25.60"
    }

    "charge 30.00 for buying four different Harry Potter books" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_THREE, Book.BOOK_FOUR, Book.BOOK_FIVE))
      val total = Calculator.calculateTotal(order)

      total shouldBe "30.00"
    }

    "charge 23.20 for buying two of the first Harry Potter book and one of the second Harry Potter book" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_TWO))
      val total = Calculator.calculateTotal(order)

      total shouldBe "23.20"
    }

    "charge 36.80 for buying two of the first book, two of the second book and one of the third book" in{
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_THREE))
      val total = Calculator.calculateTotal(order)

      total shouldBe "36.80"
    }

    "charge 52.00 for boying three of the first book, three of the third book and one of the third book" in {
      val order = Order(Seq(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_THREE))
      val total = Calculator.calculateTotal(order)

      total shouldBe "52.00"
    }
  }

}
