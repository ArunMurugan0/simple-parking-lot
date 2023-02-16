import java.util.UUID

abstract class Vehicle {
    val vehicleNumber: VehicleNumber = VehicleNumber(UUID.randomUUID())
}