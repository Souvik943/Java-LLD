package topics.LLD.ParkingLot.model.ticket;

import topics.LLD.ParkingLot.model.slot.ParkingSlot;
import topics.LLD.ParkingLot.model.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    protected String ticketId;
    protected Vehicle currentVehicle;
    protected ParkingSlot assignedParkingSlot;
    protected LocalDateTime entryTime;

    public Ticket(String ticketId, Vehicle currentVehicle, ParkingSlot assignedParkingSlot) {
        this.ticketId = ticketId;
        this.currentVehicle = currentVehicle;
        this.assignedParkingSlot = assignedParkingSlot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public ParkingSlot getAssignedParkingSlot() {
        return assignedParkingSlot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
