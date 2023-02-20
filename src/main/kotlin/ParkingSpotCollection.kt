import ParkingSpotStatus.AVAILABLE

class ParkingSpotCollection(private val parkingCapacityConfig: ParkingCapacityConfig) {
    private val parkingSpots: List<ParkingSpot> = initList(parkingCapacityConfig)

    private fun createParkingSpotListForFloor(floorNumber: UInt): List<ParkingSpot> {
        val parkingCapacityAtFloor = parkingCapacityConfig.getParkingCapacityForFloor(floorNumber)
        return List(parkingCapacityAtFloor.toInt()) { ParkingSpot(floorNumber = floorNumber) }
    }

    private fun initList(parkingCapacityConfig: ParkingCapacityConfig): List<ParkingSpot> =
        (0U until parkingCapacityConfig.getFloorCount())
            .map { floorNumber -> createParkingSpotListForFloor(floorNumber) }.flatten()

    fun getAvailableParkingSpotOrNull(): ParkingSpot? {
        return parkingSpots.firstOrNull { it.getStatus() == AVAILABLE }
    }

    fun getByParkingSpotNumberOrNull(parkingSpotNumber: ParkingSpotNumber): ParkingSpot? {
        return parkingSpots.find { it.parkingSpotNumber == parkingSpotNumber }
    }
}
