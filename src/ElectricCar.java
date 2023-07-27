public class ElectricCar {
    private String carModel;
    private String carID;
    private Manufacturer manufacturer;
    private ChargingStation chargingStation;
    private double batteryCapacityKWh;

    protected ElectricCar( String carID,String carModel, Manufacturer manufacturer, double batteryCapacityKWh){
        this.carID=carID;
        this.carModel=carModel;
        this.manufacturer = manufacturer;
        this.batteryCapacityKWh = batteryCapacityKWh;
    }
    public String getCarID() {
        return carID;
    }
    public void setCarID(String carID){
        this.carID=carID;
    }
    public String getCarModel(){
        return carModel;
    }
    public void setCarModel(String carModel){
        this.carModel=carModel;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturer=manufacturer;
    }
    public ChargingStation getChargingStation() {
        return chargingStation;
    }
    public void setChargingStation(ChargingStation chargingStation){
        this.chargingStation=chargingStation;
    }
    public double getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }
    public void setBatteryCapacityKWh(double batteryCapacityKWh){
        this.batteryCapacityKWh=batteryCapacityKWh;
    }

}
