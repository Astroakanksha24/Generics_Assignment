import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BoxTest {
    @Test
    fun `Should be able to add a book to any partition in box`() {
        val book = Book("Pride and Prejudice", "Jane Austen", 2000)
        val box: Box<Book> = Box<Book>()
        Assertions.assertEquals(true, box.add(book, "Top"))
    }

    @Test
    fun `Should be able to add a ball to any partition in box`() {
        val ball = Ball("Pink", 2.56)
        val box: Box<Ball> = Box<Ball>()
        Assertions.assertEquals(true, box.add(ball, "Top"))
    }

    @Test
    fun `Should not be able to add a book to a partition that already has a book`() {
        val book1 = Book("The Lord of the Rings", "J. R. R. Tolkien", 5000)
        val book2 = Book("A Game of Thrones", "George R. R. Martin", 4000)
        val book3 = Book("Dune", "Franklin Herbert", 3000)
        val book4 = Book("The Hunger Games", "Suzanne Collins", 2000)

        val box: Box<Book> = Box<Book>()

        box.add(book1, "Top")
        box.add(book2, "Middle")
        box.add(book3, "Bottom")

        Assertions.assertEquals(false, box.add(book4, "Top"))

    }

    @Test
    fun `Should be able to get a book object from partition`() {
        val book = Book("Pride and Prejudice", "Jane Austen", 2000)
        val box: Box<Book> = Box<Book>()
        box.add(book, "Top")

        Assertions.assertEquals(book, box.get("Top"))
    }

    @Test
    fun `Should be able to get a ball object from partition`() {
        val ball = Ball("Pink", 2.56)
        val box: Box<Ball> = Box<Ball>()
        box.add(ball, "Top")

        Assertions.assertEquals(ball, box.get("Top"))
    }

    @Test
    fun `Should be able to remove object from any partition`() {
        val book = Book("Pride and Prejudice", "Jane Austen", 2000)
        val box: Box<Book> = Box<Book>()
        box.add(book, "Top")
        box.remove("Top")
        Assertions.assertEquals(null, box.get("Top"))
    }

    @Test
    fun `Should be able to sort a box of books based on number of pages`() {
        val book1 = Book("The Lord of the Rings", "J. R. R. Tolkien", 5000)
        val book2 = Book("A Game of Thrones", "George R. R. Martin", 4000)
        val book3 = Book("Dune", "Franklin Herbert", 3000)

        val box: Box<Book> = Box<Book>()

        box.add(book1, "Top")
        box.add(book2, "Middle")
        box.add(book3, "Bottom")

        val bookComparator = Comparator<Book> { book1, book2 ->
            book1.numberOfPages.compareTo(book2.numberOfPages)
        }

        box.sort(bookComparator)

        Assertions.assertEquals(book3.name, box.get("Top")?.name)
        Assertions.assertEquals(book2.name, box.get("Middle")?.name)
        Assertions.assertEquals(book1.name, box.get("Bottom")?.name)
    }

    @Test
    fun `Should be able to sort a box of balls based on radius`() {
        val ball1 = Ball("Pink", 2.56)
        val ball2 = Ball("Purple", 1.00)
        val ball3 = Ball("Peach", 5.24)

        val box: Box<Ball> = Box<Ball>()

        box.add(ball1, "Top")
        box.add(ball2, "Middle")
        box.add(ball3, "Bottom")

        val ballComparator = Comparator<Ball> { ball1, ball2 ->
            ball1.radius.compareTo(ball2.radius)
        }

        box.sort(ballComparator)

        Assertions.assertEquals(ball2.color, box.get("Top")?.color)
        Assertions.assertEquals(ball1.color, box.get("Middle")?.color)
        Assertions.assertEquals(ball3.color, box.get("Bottom")?.color)
    }

    @Test
    fun `Should be able to return all the balls present in the box`() {
        val ball1 = Ball("Pink", 2.56)
        val ball2 = Ball("Purple", 1.00)
        val ball3 = Ball("Peach", 5.24)

        val box: Box<Ball> = Box<Ball>()

        box.add(ball1, "Top")
        box.add(ball2, "Middle")
        box.add(ball3, "Bottom")

        val expectedListOfItems = arrayListOf<Ball>(ball1, ball2, ball3)

        Assertions.assertEquals(expectedListOfItems, box.getAllItems())
    }

    @Test
    fun `Should be able to return all the books present in the box `() {

        val book1 = Book("The Lord of the Rings", "J. R. R. Tolkien", 5000)
        val book2 = Book("A Game of Thrones", "George R. R. Martin", 4000)
        val book3 = Book("Dune", "Franklin Herbert", 3000)

        val box: Box<Book> = Box<Book>()

        box.add(book1, "Top")
        box.add(book2, "Middle")
        box.add(book3, "Bottom")

        val expectedListOfItems = arrayListOf<Book>(book1, book2, book3)

        Assertions.assertEquals(expectedListOfItems, box.getAllItems())

    }
}
