class TicketCollection {
    private val tickets = mutableSetOf<Ticket>()
    fun add(ticket: Ticket) {
        tickets.add(ticket)
    }

    fun remove(ticket: Ticket) {
        tickets.remove(ticket)
    }

    fun findTicketOrNull(ticketNumber: TicketNumber): Ticket? {
        return tickets.find { it.ticketNumber == ticketNumber }
    }
}