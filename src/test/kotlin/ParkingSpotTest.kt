import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ParkingSpotTest {

    @Test
    fun `It should have default status as available`() {
        val parkingSpot = ParkingSpot()

        val actualStatus = parkingSpot.getStatus()

        val expectedStatus = ParkingSpotStatus.AVAILABLE
        assertEquals(expectedStatus, actualStatus)
    }

    @Test
    fun `It should set as occupied`() {
        val parkingSpot = ParkingSpot()

        parkingSpot.setOccupied()
        val actualStatus = parkingSpot.getStatus()

        val expectedStatus = ParkingSpotStatus.OCCUPIED
        assertEquals(expectedStatus, actualStatus)
    }

    @Test
    fun `It should set as available`() {
        val parkingSpot = ParkingSpot()

        parkingSpot.setOccupied()
        parkingSpot.setAvailable()
        val actualStatus = parkingSpot.getStatus()

        val expectedStatus = ParkingSpotStatus.AVAILABLE
        assertEquals(expectedStatus, actualStatus)
    }

}