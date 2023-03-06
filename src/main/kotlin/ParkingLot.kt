import exceptions.ParkingSpotNotAvailableException
import exceptions.TicketNotFoundException
import utils.DateUtils
import java.time.LocalDateTime

class ParkingLot(parkingCapacityConfig: ParkingCapacityConfig, private val feeStrategy: FeeStrategy) {
    private val parkingSpots = ParkingSpotCollection(parkingCapacityConfig)
    private val tickets = TicketCollection()


    fun generateParkingTicket(vehicle: Vehicle, entryDateTime: LocalDateTime): Ticket {
        val availableParkingSpot = parkingSpots.getAvailableParkingSpotOrNull()
            ?: throw ParkingSpotNotAvailableException()

        availableParkingSpot.setOccupied()

        val ticket = Ticket(vehicle.vehicleNumber, parkingSpot = availableParkingSpot, entryDateTime)
        tickets.add(ticket)

        return ticket
    }

    fun generateParkingFeeReceipt(vehicle: Vehicle, ticketNumber: TicketNumber, exitDateTime: LocalDateTime): Receipt {
        val ticket = tickets.findTicketOrNull(ticketNumber)
            ?: throw TicketNotFoundException()

        val parkingSpot = parkingSpots.getByParkingSpotNumberOrNull(ticket.parkingSpotNumber)!!
        parkingSpot.setAvailable()

        tickets.remove(ticket)

        return Receipt(
            ticket = ticket,
            exitDateTime = exitDateTime,
            fee = feeStrategy.calculateFee(ticket.entryDateTime, exitDateTime)
        )
    }
}