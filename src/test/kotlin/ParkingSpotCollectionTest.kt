import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class ParkingSpotCollectionTest {

    @Test
    fun `it should fetch an available parking spot`() {
        val parkingCapacityConfig = ParkingCapacityConfig(parkingCapacityForEachFloor = listOf(2U))
        val parkingSpots = ParkingSpotCollection(parkingCapacityConfig)
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()

        val parkingSpot = parkingSpots.getAvailableParkingSpotOrNull()

        assertNotEquals(null, parkingSpot)
    }

    @Test
    fun `it should return null if parking spot is not available`() {
        val parkingCapacityConfig = ParkingCapacityConfig(parkingCapacityForEachFloor = listOf(3U))
        val parkingSpots = ParkingSpotCollection(parkingCapacityConfig)
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()

        val parkingSpot = parkingSpots.getAvailableParkingSpotOrNull()

        assertEquals(null, parkingSpot)
    }

    @Test
    fun `It should find parking spot by it's number`() {
        val parkingCapacityConfig = ParkingCapacityConfig(parkingCapacityForEachFloor = listOf(3U))
        val parkingSpots = ParkingSpotCollection(parkingCapacityConfig)
        val parkingSpot = parkingSpots.getAvailableParkingSpotOrNull()!!

        val actualParkingSpot = parkingSpots.getByParkingSpotNumberOrNull(parkingSpot.parkingSpotNumber)

        assertEquals(parkingSpot, actualParkingSpot)
    }
}