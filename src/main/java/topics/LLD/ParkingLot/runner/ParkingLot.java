package topics.LLD.ParkingLot.runner;

import topics.LLD.ParkingLot.model.floor.ParkingFloor;
import topics.LLD.ParkingLot.model.payment.Payment;
import topics.LLD.ParkingLot.model.slot.ParkingSlot;
import topics.LLD.ParkingLot.model.ticket.Ticket;
import topics.LLD.ParkingLot.model.vehicle.Bike;
import topics.LLD.ParkingLot.model.vehicle.Car;
import topics.LLD.ParkingLot.model.vehicle.Vehicle;
import topics.LLD.ParkingLot.model.vehicle.VehicleType;
import topics.LLD.ParkingLot.service.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int floor=0; floor<2; floor++) {
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for(int slot=0; slot<2; slot++) {
                parkingSlots.add(new ParkingSlot(slot, VehicleType.BIKE));
            }
            for(int slot=2; slot<4; slot++) {
                parkingSlots.add(new ParkingSlot(slot, VehicleType.CAR));
            }
            for(int slot=4; slot<6; slot++) {
                parkingSlots.add(new ParkingSlot(slot, VehicleType.BUS));
            }
            parkingFloors.add(new ParkingFloor(floor, parkingSlots));
        }

        ParkingLotService parkingLot = new ParkingLotService(parkingFloors);

        Vehicle car = new Car("WB-42-9843", VehicleType.CAR);
        Vehicle bike = new Bike("WB-42-1234", VehicleType.BIKE);

        Ticket carTicket = parkingLot.parkVehicle(car);
        Ticket bikeTicket = parkingLot.parkVehicle(bike);

        Thread.sleep(10000);

        Payment carPayment = parkingLot.unParkVehicle(carTicket.getTicketId());
        System.out.println("Car Payment : Rs. " + carPayment.getAmount());


        Payment bikePayment = parkingLot.unParkVehicle(bikeTicket.getTicketId());
        System.out.println("Bike Payment : Rs. " + bikePayment.getAmount());
    }
}
