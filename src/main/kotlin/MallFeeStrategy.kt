import utils.DateUtils
import java.time.LocalDateTime

@OpenClass
class MallFeeStrategy(private val hourlyParkingFeeRate: UInt): FeeStrategy() {
    override fun calculateFee(startDateTime: LocalDateTime, endDateTime: LocalDateTime): UInt {
        val hoursParked = DateUtils.getTotalHoursBetween(startDateTime, endDateTime).toUInt()
        return hoursParked * hourlyParkingFeeRate
    }
}