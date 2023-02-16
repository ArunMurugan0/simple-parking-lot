import exceptions.ParkingSpotNotAvailableException
import java.time.LocalDateTime

class ParkingLot(parkingSpotCount: UInt, private val hourlyParkingFeeRate: UInt) {
    private val parkingSpots = ParkingSpotCollection(parkingSpotCount)

    fun generateParkingTicket(vehicle: Vehicle, entryDateTime: LocalDateTime): Ticket {
        val availableParkingSpot = parkingSpots.getAvailableParkingSpotOrNull()
            ?: throw ParkingSpotNotAvailableException()

        availableParkingSpot.setOccupied()

        val ticket = Ticket(vehicle.vehicleNumber, parkingSpot = availableParkingSpot, entryDateTime)

        return ticket
    }

}