import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketNumberTest {

    @Test
    fun  `It should generate ticket numbers sequentially`() {
        val ticketNumberOne = TicketNumber()
        val ticketNumberTwo = TicketNumber()

        assertEquals(1, ticketNumberOne.value)
        assertEquals(2, ticketNumberTwo.value)
    }
}