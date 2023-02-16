import java.time.LocalDateTime

data class Ticket(val vehicleNumber: VehicleNumber, private val parkingSpot: ParkingSpot, val entryDateTime: LocalDateTime) {
    val ticketNumber = TicketNumber()

    val parkingSpotNumber: ParkingSpotNumber
        get() = parkingSpot.parkingSpotNumber

}