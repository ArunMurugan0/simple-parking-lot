import utils.Counter

@JvmInline
value class ParkingSpotNumber(val value: Long) {
    companion object {
        private val counter = Counter()
    }

    constructor(): this(counter.next())
}