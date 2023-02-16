class ParkingSpot(
    private var status: ParkingSpotStatus = ParkingSpotStatus.AVAILABLE
) {
    val parkingSpotNumber = ParkingSpotNumber()

    fun getStatus(): ParkingSpotStatus {
        return status
    }

    fun setOccupied() {
        status = ParkingSpotStatus.OCCUPIED
    }

    fun setAvailable() {
        status = ParkingSpotStatus.AVAILABLE
    }
}