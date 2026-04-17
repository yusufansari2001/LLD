import com.vehiclerental.service.VehicleRentalSystem;
import com.vehiclerental.model.*;
import com.vehiclerental.enums.*;
import java.time.LocalDateTime;

void main() {
    VehicleRentalSystem system = VehicleRentalSystem.getInstance();

    // Add a store
    Location loc = new Location("New York", "NY", "10001");
    Store store = new Store("STORE1", loc);
    system.addStore(store);

    // Add vehicles
    Bike bike = new Bike("BIKE1", "Honda CBR");
    Car car = new Car("CAR1", "Toyota Camry");
    store.getInventory().addVehicle(bike);
    store.getInventory().addVehicle(car);

    // Add user
    User user = new User("USER1", "John Doe", "john@example.com", "1234567890");
    system.addUser(user);

    // Make reservation
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = start.plusHours(2);
    Reservation res = system.makeReservation(user, VehicleType.CAR, start, end, ReservationType.HOURLY, store);

    if (res != null) {
        System.out.println("Reservation made: " + res.getId());

        // Generate bill
        Bill bill = system.generateBill(res);
        System.out.println("Bill amount: " + bill.getAmount());

        // Make payment
        Payment payment = system.makePayment(bill, PaymentMode.CARD);
        System.out.println("Payment done: " + payment.getId());

        // Return vehicle
        system.returnVehicle(res);
        System.out.println("Vehicle returned");
    } else {
        System.out.println("No vehicle available");
    }
}
