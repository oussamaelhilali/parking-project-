package parking.refactored;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final List<VehicleTariff> tariffs;
    private final ReceiptFormatter formatter;
    private final ReceiptLog log;
    private final List<Receipt> receipts = new ArrayList<>();
    private double total;

    public ParkingService(List<VehicleTariff> tariffs, ReceiptFormatter formatter, ReceiptLog log) {
        this.tariffs = List.copyOf(tariffs);
        this.formatter = formatter;
        this.log = log;
    }

    public double fee(Vehicle vehicle, int hours) {
        for (VehicleTariff tariff : tariffs) {
            if (tariff.supports(vehicle.getType())) return tariff.fee(vehicle, hours);
        }
        throw new IllegalArgumentException(vehicle.getType());
    }

    public Receipt checkout(Vehicle vehicle, int hours, PaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;

        Receipt receipt = new Receipt(vehicle, hours, amount, method);
        receipts.add(receipt);
        log.write(formatter.formatReceipt(receipt));
        return receipt;
    }

    public void cancel(Vehicle vehicle, int hours, RefundablePayment method) {
        double amount = fee(vehicle, hours);
        method.refund(amount);
        total -= amount;
    }

    public void cancelCashAtDesk(Vehicle vehicle, int hours) {
        double amount = fee(vehicle, hours);
        System.out.println("Refund " + amount + " MAD at the desk for " + vehicle.getPlate());
        total -= amount;
    }

    public String dailyReport() {
        return formatter.formatDailyReport(receipts, total);
    }
}
