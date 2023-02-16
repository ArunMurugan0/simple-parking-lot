import java.time.LocalDateTime

data class Receipt(val ticket: Ticket, val exitDateTime: LocalDateTime, val fee: UInt) {
    val receiptNumber
            get() = "R-${ticket.ticketNumber.value}"
}