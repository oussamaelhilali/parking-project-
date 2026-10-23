package parking.refactored;

import java.util.List;

public class ParkingServiceTest {
    public static void main(String[] args) {
        MemoryReceiptLog log = new MemoryReceiptLog();
        ParkingService service = new ParkingService(
                List.of(new CarTariff(), new MotorbikeTariff(), new TruckTariff()),
                new ReceiptFormatter(), log);

        Vehicle car = new Vehicle("CAR-1", "CAR");
        Vehicle bike = new Vehicle("BIKE-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("TRUCK-1", "TRUCK");

        check(service.fee(car, 3) == 15, "car fee");
        check(service.fee(bike, 2) == 4, "motorbike fee");
        check(service.fee(truck, 4) == 60, "truck fee");

        service.checkout(car, 3, new CashPayment());
        service.checkout(bike, 2, new CashPayment());
        service.checkout(truck, 4, new CashPayment());
        check(service.dailyReport().contains("Total: 79.0 MAD"), "daily total");
        check(log.entries().size() == 3, "log entries");
        System.out.println("ParkingServiceTest passed");
    }

    private static void check(boolean condition, String name) {
        if (!condition) throw new AssertionError("Failed: " + name);
    }
}
