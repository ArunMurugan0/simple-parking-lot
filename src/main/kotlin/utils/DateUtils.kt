package utils

import java.time.Duration
import java.time.LocalDateTime

class DateUtils {
    companion object {
        fun getTotalHoursBetween(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Int {
            if (startDateTime.isAfter(endDateTime)) {
                throw IllegalArgumentException("end datetime has to be before start datetime")
            }

            return Duration.between(startDateTime, endDateTime).toHours().toInt()
        }
    }
}