import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime
import java.util.stream.Stream

class MallFeeStrategyTest {

    @ParameterizedTest
    @MethodSource("getFeeCalculationTestCases")
    fun `it should return fee based on the hourly rate and the time elapsed between entry and exit`(
        hourlyRate: UInt, entryDateTime: LocalDateTime, exitDateTime: LocalDateTime, expectedFee: UInt
    ) {
        val feeStrategy: FeeStrategy = MallFeeStrategy(hourlyParkingFeeRate = hourlyRate)

        val actualFee = feeStrategy.calculateFee(entryDateTime, exitDateTime)

        assertEquals(expectedFee, actualFee)
    }

    companion object {
        @JvmStatic
        fun getFeeCalculationTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    10,
                    LocalDateTime.of(2022, 9, 11, 11, 30),
                    LocalDateTime.of(2022, 9, 11, 13, 30),
                    20
                ),
                Arguments.of(
                    10,
                    LocalDateTime.of(2022, 11, 11, 0, 0),
                    LocalDateTime.of(2022, 11, 12, 0, 0),
                    240
                ),
                Arguments.of(
                    10,
                    LocalDateTime.of(2022, 9, 11, 11, 30),
                    LocalDateTime.of(2022, 9, 11, 16, 15),
                    40
                ),
            )
        }
    }
}