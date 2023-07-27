import java.util.ArrayList;

public class ChargingStation {
    private String chargeID;
    private String chargeLocation;
    private double availableChargingCapacityKWh;

    public ChargingStation(String chargeID, String chargeLocation, double availableChargingCapacityKWh) {
        this.chargeID = chargeID;
        this.chargeLocation = chargeLocation;
        this.availableChargingCapacityKWh = availableChargingCapacityKWh;
    }

    // Getters and setters

    public String getChargeID() {
        return chargeID;
    }
    public void setChargeID(String chargeID) {
        this.chargeID = chargeID;
    }
    public String getChargeLocation() {
        return chargeLocation;
    }
    public void setChargeLocation(String chargeLocation) {
        this.chargeLocation = chargeLocation;
    }
    public double getAvailableChargingCapacityKWh() {
        return availableChargingCapacityKWh;
    }

    public void setAvailableChargingCapacityKWh(double availableChargingCapacityKWh) {
        this.availableChargingCapacityKWh = availableChargingCapacityKWh;
    }

}
