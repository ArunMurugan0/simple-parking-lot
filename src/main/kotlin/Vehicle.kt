import java.util.UUID

abstract class Vehicle {
    val vehicleNumber: UUID = UUID.randomUUID()
}