import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ParkingCapacityConfigTest {

    @Test
    fun `it should return the count of floors`() {
        val parkingCapacityConfig = ParkingCapacityConfig(listOf(0U, 0U, 1U, 1U))

        assertEquals(parkingCapacityConfig.getFloorCount(), 4U)
    }

    @Test
    fun `it should return the capacity for each floor`() {
        val parkingCapacityConfig = ParkingCapacityConfig(listOf(1U, 2U, 3U, 4U))

        val expectedCapacityOfFloorOne = 1U
        val expectedCapacityOfFloorTwo = 2U
        val expectedCapacityOfFloorThree = 3U
        val expectedCapacityOfFloorFour = 4U

        assertEquals(expectedCapacityOfFloorOne, parkingCapacityConfig.getParkingCapacityForFloor(0U))
        assertEquals(expectedCapacityOfFloorTwo, parkingCapacityConfig.getParkingCapacityForFloor(1U))
        assertEquals(expectedCapacityOfFloorThree, parkingCapacityConfig.getParkingCapacityForFloor(2U))
        assertEquals(expectedCapacityOfFloorFour, parkingCapacityConfig.getParkingCapacityForFloor(3U))
    }

    @Test
    fun `it should throw exception if floor number greater than or equal to the number of floors is being passed`() {
        val parkingCapacityConfig = ParkingCapacityConfig(listOf(0U, 0U, 1U, 1U))

        val exception = assertThrows<IllegalArgumentException> {
            parkingCapacityConfig.getParkingCapacityForFloor(4U)
        }

        assertEquals("Invalid Floor Number. Floor Number has to be less than number of floors", exception.message)
    }
}