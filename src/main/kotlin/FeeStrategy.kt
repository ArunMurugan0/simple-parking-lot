import java.time.LocalDateTime

abstract class FeeStrategy {
    abstract fun calculateFee(startDateTime: LocalDateTime, endDateTime: LocalDateTime): UInt
}