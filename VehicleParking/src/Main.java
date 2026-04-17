import com.parkinglot.parking.ParkingLot;
import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.payment.CashPayment;
import com.parkinglot.payment.CardPayment;
import com.parkinglot.payment.UPIPayment;

public class Main {
    public static void main(String[] args) {
        // Create parking lot with 3 floors, 30 spaces per floor (10 per type)
        ParkingLot parkingLot = new ParkingLot("Central Parking", 3, 30);

        // Create vehicles
        Vehicle bike = new Vehicle("ABC123", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("XYZ456", VehicleType.FOUR_WHEELER);
        Vehicle truck = new Vehicle("TRK789", VehicleType.HEAVY_VEHICLE);

        // Entry
        var entryGate = parkingLot.getGateManager().getEntryGates().get(0);
        var ticket1 = entryGate.generateTicket(bike);
        var ticket2 = entryGate.generateTicket(car);
        var ticket3 = entryGate.generateTicket(truck);

        if (ticket1 != null) {
            System.out.println("Bike parked at space " + ticket1.getParkingSpace().getId() + " on floor " + ticket1.getParkingSpace().getFloorNumber());
        }
        if (ticket2 != null) {
            System.out.println("Car parked at space " + ticket2.getParkingSpace().getId() + " on floor " + ticket2.getParkingSpace().getFloorNumber());
        }
        if (ticket3 != null) {
            System.out.println("Truck parked at space " + ticket3.getParkingSpace().getId() + " on floor " + ticket3.getParkingSpace().getFloorNumber());
        }

        // Simulate time passage (in real system, use actual time)
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exit
        var exitGate = parkingLot.getGateManager().getExitGates().get(0);
        var payment1 = exitGate.calculateAndProcessPayment(ticket1, new CashPayment());
        var payment2 = exitGate.calculateAndProcessPayment(ticket2, new CardPayment());
        var payment3 = exitGate.calculateAndProcessPayment(ticket3, new UPIPayment());

        System.out.println("Payments processed:");
        System.out.println("Bike: $" + payment1.getAmount() + " via " + payment1.getMode());
        System.out.println("Car: $" + payment2.getAmount() + " via " + payment2.getMode());
        System.out.println("Truck: $" + payment3.getAmount() + " via " + payment3.getMode());
    }
}
