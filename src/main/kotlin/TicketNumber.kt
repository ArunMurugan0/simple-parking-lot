import utils.Counter

@JvmInline
value class TicketNumber(val value: Long) {
    companion object {
        private val counter = Counter()
    }

    constructor() : this(counter.next())
}