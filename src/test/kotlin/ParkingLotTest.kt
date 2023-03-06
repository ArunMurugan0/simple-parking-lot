import exceptions.ParkingSpotNotAvailableException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito
import java.time.LocalDateTime
import java.util.stream.Stream
import kotlin.test.assertIs


class ParkingLotTest {

    @Test
    fun `It should generate Ticket`() {
        val car = Car()
        val parkingCapacityConfig = ParkingCapacityConfig(parkingCapacityForEachFloor = listOf(1U, 2U))
        val feeStrategy: FeeStrategy = Mockito.mock(MallFeeStrategy::class.java)
        val parkingLot = ParkingLot(parkingCapacityConfig, feeStrategy)

        val entryDateTime = LocalDateTime.now()
        val ticket = parkingLot.generateParkingTicket(car, entryDateTime)

        assertIs<UInt>(ticket.floorNumber)
        assertEquals(car.vehicleNumber, ticket.vehicleNumber)
        assertEquals(entryDateTime, ticket.entryDateTime)
    }

    @Test
    fun `It should throw exception if there is no parking spot available`() {
        val parkingCapacityConfig = ParkingCapacityConfig(parkingCapacityForEachFloor = listOf(3U))
        val feeStrategy: FeeStrategy = Mockito.mock(MallFeeStrategy::class.java)
        val parkingLot = ParkingLot(parkingCapacityConfig, feeStrategy)
        parkingLot.generateParkingTicket(Car(), LocalDateTime.now())
        parkingLot.generateParkingTicket(Car(), LocalDateTime.now())
        parkingLot.generateParkingTicket(Car(), LocalDateTime.now())

        assertThrows<ParkingSpotNotAvailableException> {
            parkingLot.generateParkingTicket(Car(), LocalDateTime.now())
        }
    }

    @MethodSource("getFeeCalculationTestCases")
    @ParameterizedTest
    fun `it should calculate fee based on entry and exit datetime`(entryDateTime: LocalDateTime, exitDateTime: LocalDateTime, vehicle: Vehicle, expectedParkingFee: UInt) {
        val parkingCapacityConfig = ParkingCapacityConfig(parkingCapacityForEachFloor = listOf(10U))
        val feeStrategy: FeeStrategy = Mockito.mock(MallFeeStrategy::class.java)
        val parkingLot = ParkingLot(parkingCapacityConfig, feeStrategy)

        Mockito.doReturn(expectedParkingFee.toInt()).`when`(feeStrategy).calculateFee(entryDateTime, exitDateTime)
        val ticket = parkingLot.generateParkingTicket(vehicle, entryDateTime = entryDateTime)
        val receipt = parkingLot.generateParkingFeeReceipt(vehicle, ticket.ticketNumber, exitDateTime)

        assertEquals(expectedParkingFee, receipt.fee)
    }


    companion object {
        @JvmStatic
        fun getFeeCalculationTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    LocalDateTime.of(2022, 9, 11, 11, 30),
                    LocalDateTime.of(2022, 9, 11, 13, 30),
                    Car(),
                    20
                ),
                Arguments.of(
                    LocalDateTime.of(2022, 11, 11, 0, 0),
                    LocalDateTime.of(2022, 11, 12, 0, 0),
                    Car(),
                    240
                ),
                Arguments.of(
                    LocalDateTime.of(2022, 9, 11, 11, 30),
                    LocalDateTime.of(2022, 9, 11, 16, 15),
                    Car(),
                    40
                ),
            )
        }
    }
}