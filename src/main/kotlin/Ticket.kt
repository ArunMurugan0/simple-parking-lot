import java.time.LocalDateTime
import java.util.UUID

data class Ticket(val vehicleNumber: UUID, private val parkingSpot: ParkingSpot, val entryDateTime: LocalDateTime) {
    val ticketNumber = TicketNumber()

    val parkingSpotNumber: ParkingSpotNumber
        get() = parkingSpot.parkingSpotNumber

}