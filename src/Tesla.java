public class Tesla extends ElectricCar {

    private boolean isAutoPilotEnabled;
    private boolean isFullSelfDrivingEnabled;
    private boolean isTeslaTheatreEnabled;

    protected Tesla(String carID, String carModel, Manufacturer manufacturer, double batteryCapacityKWh,
                  boolean hasPanaromicSunroof, boolean hasWirelessCharging) {
        super(carID, carModel, manufacturer, batteryCapacityKWh);
        this.isAutoPilotEnabled = isAutoPilotEnabled;
        this.isFullSelfDrivingEnabled = isFullSelfDrivingEnabled;
        this.isTeslaTheatreEnabled = isTeslaTheatreEnabled;
    }


    public boolean isAutoPilotEnabled() {
        return isAutoPilotEnabled;
    }

    public boolean isFullSelfDrivingEnabled() {
        return isFullSelfDrivingEnabled;
    }

    public boolean isTeslaTheatreEnabled() {
        return isTeslaTheatreEnabled;
    }
}
