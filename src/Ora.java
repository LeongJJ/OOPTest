public class Ora extends ElectricCar {
    private boolean hasPanaromicSunroof;
    private boolean hasWirelessCharging;

    protected Ora(String carID, String carModel, Manufacturer manufacturer, double batteryCapacityKWh,
                  boolean hasPanaromicSunroof, boolean hasWirelessCharging) {
        super(carID, carModel, manufacturer, batteryCapacityKWh);
        this.hasPanaromicSunroof = hasPanaromicSunroof;
        this.hasWirelessCharging = hasWirelessCharging;
    }

    public boolean hasPanaromicSunroof() {
        return hasPanaromicSunroof;
    }

    public boolean hasWirelessCharging() {
        return hasWirelessCharging;
    }
}
