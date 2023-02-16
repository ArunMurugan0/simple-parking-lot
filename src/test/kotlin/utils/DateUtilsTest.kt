package utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import kotlin.test.assertEquals

class DateUtilsTest {
    @Test
    fun `It should give the total hours from and to the given datetime`() {
        val totalHoursBetween = DateUtils.getTotalHoursBetween(
            LocalDateTime.of(2001, 11, 11, 10, 5),
            LocalDateTime.of(2001, 11, 11, 12, 0)
        )

        assertEquals(1, totalHoursBetween)
    }

    @Test
    fun `It should throw exception if the start datetime is after end datetime`() {
        val exception = assertThrows<IllegalArgumentException> {
            DateUtils.getTotalHoursBetween(
                LocalDateTime.of(2001, 11, 11, 12, 0),
                LocalDateTime.of(2001, 11, 11, 10, 5)
            )
        }

        val expectedExceptionMessage = "end datetime has to be before start datetime"
        assertEquals(expectedExceptionMessage, exception.message)
    }
}