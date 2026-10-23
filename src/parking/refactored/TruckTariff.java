package parking.refactored;

public class TruckTariff implements VehicleTariff {
    public boolean supports(String type) { return "TRUCK".equals(type); }
    public double fee(Vehicle vehicle, int hours) { return 20 + hours * 10.0; }
}
