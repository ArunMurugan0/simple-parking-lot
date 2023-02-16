import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `it should generate random UUID`() {
        val carOne = Car()
        val carTwo = Car()

        assertNotEquals(carOne.vehicleNumber, carTwo.vehicleNumber)
    }
}