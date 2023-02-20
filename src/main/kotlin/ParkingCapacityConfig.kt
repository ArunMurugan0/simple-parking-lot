class ParkingCapacityConfig(private val parkingCapacityForEachFloor: List<UInt>) {
    fun getFloorCount(): UInt = parkingCapacityForEachFloor.size.toUInt()
    fun getParkingCapacityForFloor(floorNumber: UInt) =
        if (floorNumber < getFloorCount()) {
            parkingCapacityForEachFloor[floorNumber.toInt()]
        }
        else throw IllegalArgumentException("Invalid Floor Number. Floor Number has to be less than number of floors")
}