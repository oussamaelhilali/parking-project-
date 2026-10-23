# Parking code review

| Principle | Class | Smell |
|---|---|---|
| SRP | `ParkingGarage` | It calculates fees, takes payments, cancels payments, reports, and logs. |
| OCP | `ParkingGarage` | The vehicle `switch` must be edited for a new vehicle type. |
| LSP | `CashPayment` | `refund()` throws an exception. |
| ISP | `PaymentMethod` | Cash is forced to have a refund operation it cannot use. |
| DIP | `ParkingGarage` | It creates `new FileLogger("parking.log")` itself. |
