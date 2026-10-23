package parking.refactored;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingService service = new ParkingService(
                List.of(new CarTariff(), new MotorbikeTariff(), new TruckTariff()),
                new ReceiptFormatter(),
                new FileReceiptLog("parking.log"));

        Vehicle car = new Vehicle("12345-A-6", "CAR");
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK");
        CardPayment card = new CardPayment("4242");
        CashPayment cash = new CashPayment();

        service.checkout(car, 3, card);
        service.checkout(bike, 2, cash);
        service.checkout(truck, 4, card);
        service.cancelCashAtDesk(bike, 2);
        service.cancel(truck, 4, card);
        System.out.print(service.dailyReport());
    }
}
