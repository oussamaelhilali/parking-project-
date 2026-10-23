package parking.refactored;

public interface VehicleTariff {
    boolean supports(String type);
    double fee(Vehicle vehicle, int hours);
}
