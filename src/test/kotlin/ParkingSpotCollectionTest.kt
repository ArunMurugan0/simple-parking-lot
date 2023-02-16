import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingSpotCollectionTest {

    @Test
    fun `it should fetch an available parking spot`() {
        val parkingSpots = ParkingSpotCollection(2U)
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()

        val parkingSpot = parkingSpots.getAvailableParkingSpotOrNull()

        assertNotEquals(null, parkingSpot)
    }

    @Test
    fun `it should return null if parking spot is not available`() {
        val parkingSpots = ParkingSpotCollection(3U)
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()
        parkingSpots.getAvailableParkingSpotOrNull()!!.setOccupied()

        val parkingSpot = parkingSpots.getAvailableParkingSpotOrNull()

        assertEquals(null, parkingSpot)
    }

    @Test
    fun `It should find parking spot by it's number`() {
        val parkingSpots = ParkingSpotCollection(3U)
        val parkingSpot = parkingSpots.getAvailableParkingSpotOrNull()!!

        val actualParkingSpot = parkingSpots.getByParkingSpotNumberOrNull(parkingSpot.parkingSpotNumber)

        assertEquals(parkingSpot, actualParkingSpot)
    }
}