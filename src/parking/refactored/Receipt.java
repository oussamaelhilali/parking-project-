package parking.refactored;

public class Receipt {
    private final Vehicle vehicle;
    private final int hours;
    private final double amount;
    private final PaymentMethod payment;

    public Receipt(Vehicle vehicle, int hours, double amount, PaymentMethod payment) {
        this.vehicle = vehicle;
        this.hours = hours;
        this.amount = amount;
        this.payment = payment;
    }

    public Vehicle vehicle() { return vehicle; }
    public int hours() { return hours; }
    public double amount() { return amount; }
    public PaymentMethod payment() { return payment; }
}
