package topics.LLD.ParkingLot.model.slot;

import topics.LLD.ParkingLot.model.vehicle.Vehicle;
import topics.LLD.ParkingLot.model.vehicle.VehicleType;

public class ParkingSlot {
    protected int slotNumber;
    protected VehicleType vehicleType;
    protected SlotStatus currentSlotStatus;
    protected Vehicle currentVehicle;

    public ParkingSlot(int slotNumber, VehicleType vehicleType) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.currentSlotStatus = SlotStatus.AVAILABLE;
    }

    public boolean isParkingSlotAvailable() {
        return currentSlotStatus == SlotStatus.AVAILABLE;
    }

    public void allocateVehicle(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.currentSlotStatus = SlotStatus.OCCUPIED;
    }

    public void deallocateVehicle(Vehicle vehicle) {
        this.currentVehicle = null;
        this.currentSlotStatus = SlotStatus.AVAILABLE;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public SlotStatus getCurrentSlotStatus() {
        return currentSlotStatus;
    }
}
