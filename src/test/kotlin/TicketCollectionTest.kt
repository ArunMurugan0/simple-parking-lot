import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

class TicketCollectionTest {

    @Test
    fun `it should be able to access all tickets that are added`() {
        val ticketOne =
            Ticket(
                parkingSpot = ParkingSpot(floorNumber = 1U),
                vehicleNumber = Car().vehicleNumber,
                entryDateTime = LocalDateTime.now()
            )
        val ticketTwo = Ticket(
            parkingSpot = ParkingSpot(floorNumber = 1U),
            vehicleNumber = Car().vehicleNumber,
            entryDateTime = LocalDateTime.now()
        )

        val tickets = TicketCollection()
        tickets.add(ticketOne)
        tickets.add(ticketTwo)

        assertEquals(ticketOne, tickets.findTicketOrNull(ticketOne.ticketNumber))
        assertEquals(ticketTwo, tickets.findTicketOrNull(ticketTwo.ticketNumber))
    }

    @Test
    fun `it should return null when trying retrieve if the ticket is not found`() {
        val ticketOne =
            Ticket(
                parkingSpot = ParkingSpot(floorNumber = 1U),
                vehicleNumber = Car().vehicleNumber,
                entryDateTime = LocalDateTime.now()
            )

        val tickets = TicketCollection()

        assertEquals(null, tickets.findTicketOrNull(ticketOne.ticketNumber))
    }

    @Test
    fun `it should remove the ticket from the collection`() {
        val ticketOne =
            Ticket(
                parkingSpot = ParkingSpot(floorNumber = 1U),
                vehicleNumber = Car().vehicleNumber,
                entryDateTime = LocalDateTime.now()
            )
        val tickets = TicketCollection()
        tickets.add(ticketOne)
        tickets.remove(ticketOne)

        assertEquals(null, tickets.findTicketOrNull(ticketOne.ticketNumber))
    }
}