# Parking project answers

1. The actors are the tariff person, payment person, refund/support person, reporting person, logging person, and application person.

2. The review table is in `review-table.md`.

3. With the old design:

   - BUS: `ParkingGarage.java` and `Main.java`
   - Mobile wallet: a new payment class, `ParkingGarage.java`, and `Main.java`
   - Database log: `ParkingGarage.java` and `FileLogger.java`
   - CSV report: `ParkingGarage.java` and `Main.java`

4. Without the cash check, `CashPayment.refund()` throws `UnsupportedOperationException`. Cash does not support the refund behavior. The `instanceof` check is not a good fix because the garage still has to know payment types.

5. The old class creates `FileLogger` inside itself. There is no way to give it a fake logger, so the test creates a file.

6. The diagram is `parking-refactored-uml.svg`. It has a tariff interface, payment interfaces, a log interface, a formatter, and `ParkingService`.

7. The refactored program is in `parking.refactored`. It prints the same output as the original.

8. Cash cannot be passed to `ParkingService.cancel`, because that method requires `RefundablePayment`. The compiler catches it.

9. `ParkingServiceTest` checks car, motorbike, and truck fees plus the report total. It uses `MemoryReceiptLog`.

10. A new tariff, payment method, logger, or report format can be added as a new class. In these examples, only `Main` needs new wiring.
