import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ParkingSpotNumberTest {

    @Disabled("This test is not working")
    @Test
    fun `it should generate parking spot number incrementally from 1`() {
        val spotNumberOne = ParkingSpotNumber()
        val spotNumberTwo = ParkingSpotNumber()

        assertEquals(1, spotNumberOne.value)
        assertEquals(2, spotNumberTwo.value)
    }
}
