package topics.LLD.ParkingLot.model.floor;

import topics.LLD.ParkingLot.model.slot.ParkingSlot;
import topics.LLD.ParkingLot.model.vehicle.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    protected int floorNumber;
    List<ParkingSlot> parkingSlotList;

    public ParkingFloor(int floorNumber, List<ParkingSlot> parkingSlotList) {
        this.floorNumber = floorNumber;
        this.parkingSlotList = parkingSlotList;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Optional<ParkingSlot> getAvailableSlot(VehicleType vehicleType) {
        return parkingSlotList.stream()
                .filter(parkingSlot -> parkingSlot.getVehicleType() == vehicleType && parkingSlot.isParkingSlotAvailable())
                .findFirst();
    }
}