import ParkingSpotStatus.AVAILABLE

class ParkingSpotCollection(parkingSpotCount: UInt) {
    private val parkingSpots: List<ParkingSpot> = initList(parkingSpotCount)

    private fun initList(parkingSpotCount: UInt) =
        List(parkingSpotCount.toInt()) { ParkingSpot() }

    fun getAvailableParkingSpotOrNull(): ParkingSpot? {
        return parkingSpots.firstOrNull { it.getStatus() == AVAILABLE }
    }

    fun getByParkingSpotNumberOrNull(parkingSpotNumber: ParkingSpotNumber): ParkingSpot? {
        return parkingSpots.find { it.parkingSpotNumber == parkingSpotNumber }
    }
}
