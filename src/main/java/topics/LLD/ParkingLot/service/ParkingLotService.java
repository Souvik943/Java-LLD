package topics.LLD.ParkingLot.service;

import topics.LLD.ParkingLot.model.floor.ParkingFloor;
import topics.LLD.ParkingLot.model.payment.Payment;
import topics.LLD.ParkingLot.model.payment.PaymentStatus;
import topics.LLD.ParkingLot.model.slot.ParkingSlot;
import topics.LLD.ParkingLot.model.ticket.Ticket;
import topics.LLD.ParkingLot.model.vehicle.Vehicle;
import topics.LLD.ParkingLot.model.vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingLotService {
    protected List<ParkingFloor> parkingFloorList = new ArrayList<>();
    protected Map<String, Ticket> tickets = new HashMap<>();

    public ParkingLotService(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public Ticket parkVehicle(Vehicle vehicle) throws InterruptedException {
        for(ParkingFloor parkingFloor : parkingFloorList) {
            Optional<ParkingSlot> availableSlot = parkingFloor.getAvailableSlot(vehicle.getVehicleType());
            if(availableSlot.isPresent()) {
                ParkingSlot slot = availableSlot.get();
                slot.allocateVehicle(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, slot);
                System.out.println("Generating a ticket ...");
                Thread.sleep(3000);
                tickets.put(ticket.getTicketId(), ticket);
                System.out.println("Vehicle should be parked at : Floor - " + parkingFloor.getFloorNumber() + " Slot : " + slot.getSlotNumber());
                return ticket;
            }
        }
        throw new RuntimeException("No slots found for the specific vehicle type .");
    }

    public Payment unParkVehicle(String ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if(ticket == null) {
            throw new RuntimeException("Ticket Not found");
        }
        ParkingSlot assignedSlot = ticket.getAssignedParkingSlot();
        assignedSlot.deallocateVehicle(ticket.getCurrentVehicle());
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        double amountToBePaid = calculateParkingFee(hours, ticket.getCurrentVehicle());
        return new Payment(ticketId, amountToBePaid, PaymentStatus.SUCCESS);
    }

    public double calculateParkingFee(long hours, Vehicle vehicle) {
        if(vehicle.getVehicleType() == VehicleType.BIKE) {
            return hours * 10;
        } else if(vehicle.getVehicleType() == VehicleType.CAR) {
            return hours * 30;
        } else if(vehicle.getVehicleType() == VehicleType.BUS) {
            return  hours * 70;
        }
        throw new RuntimeException("Vehicle not allowed for parking .");
    }


}
