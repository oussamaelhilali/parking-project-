package parking.refactored;

import java.util.List;

public class ReceiptFormatter {
    public String formatReceipt(Receipt receipt) {
        Vehicle vehicle = receipt.vehicle();
        return String.format("%s | %s | %d h | %.1f MAD | %s",
                vehicle.getPlate(), vehicle.getType(), receipt.hours(),
                receipt.amount(), receipt.payment().name());
    }

    public String formatDailyReport(List<Receipt> receipts, double total) {
        StringBuilder result = new StringBuilder("=== Daily report ===\n");
        for (Receipt receipt : receipts) {
            result.append(formatReceipt(receipt)).append('\n');
        }
        result.append(String.format("Total: %.1f MAD%n", total));
        return result.toString();
    }
}
