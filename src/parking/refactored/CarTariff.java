package parking.refactored;

public class CarTariff implements VehicleTariff {
    public boolean supports(String type) { return "CAR".equals(type); }
    public double fee(Vehicle vehicle, int hours) { return hours * 5.0; }
}
