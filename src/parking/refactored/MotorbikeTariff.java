package parking.refactored;

public class MotorbikeTariff implements VehicleTariff {
    public boolean supports(String type) { return "MOTORBIKE".equals(type); }
    public double fee(Vehicle vehicle, int hours) { return hours * 2.0; }
}
