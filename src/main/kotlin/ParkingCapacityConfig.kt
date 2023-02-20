class ParkingCapacityConfig(private val parkingCapacityForEachFloor: List<UInt>) {
    fun getFloorCount(): UInt = parkingCapacityForEachFloor.size.toUInt()
    fun getParkingCapacityForFloor(floorNumber: UInt) = parkingCapacityForEachFloor[floorNumber.toInt()]
}