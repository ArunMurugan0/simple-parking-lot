import exceptions.ParkingSpotNotAvailableException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime

class ParkingLotTest {

    @Test
    fun `It should generate Ticket`() {
        val car = Car()
        val parkingLot = ParkingLot(2U, hourlyParkingFeeRate = 10U)

        val entryDateTime = LocalDateTime.now()
        val ticket = parkingLot.generateParkingTicket(car, entryDateTime)

        assertEquals(car.vehicleNumber, ticket.vehicleNumber)
        assertEquals(entryDateTime, ticket.entryDateTime)
    }

    @Test
    fun `It should throw exception if there is no parking spot available`() {
        val parkingLot = ParkingLot(3U, hourlyParkingFeeRate = 10U)
        parkingLot.generateParkingTicket(Car(), LocalDateTime.now())
        parkingLot.generateParkingTicket(Car(), LocalDateTime.now())
        parkingLot.generateParkingTicket(Car(), LocalDateTime.now())

        assertThrows<ParkingSpotNotAvailableException> {
            parkingLot.generateParkingTicket(Car(), LocalDateTime.now())
        }
    }
}