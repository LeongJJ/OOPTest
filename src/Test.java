import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChargingStation chargingStation1 = new ChargingStation("CS001", "Location A", 100);
        ChargingStation chargingStation2 = new ChargingStation("CS002", "Location B", 150);

        Manufacturer teslaManufacturer = new Manufacturer("M001", "Tesla");
        teslaManufacturer.addCarModel("Model S");
        teslaManufacturer.addCarModel("Model X");
        teslaManufacturer.addCarModel("Model Y");
        teslaManufacturer.addCarModel("Model Z");
        teslaManufacturer.addCarModel("Model U");

        Manufacturer oraManufacturer = new Manufacturer("M002", "Ora");
        oraManufacturer.addCarModel("Ora 1");
        oraManufacturer.addCarModel("Ora 2");
        oraManufacturer.addCarModel("Ora 3");
        oraManufacturer.addCarModel("Ora 4");
        oraManufacturer.addCarModel("Ora 5");


        Tesla tesla1 = new Tesla("T001", "Model S", teslaManufacturer, 85,
                true, true,false);
        Tesla tesla2 = new Tesla("T002", "Model X", teslaManufacturer, 100,
                true, false,true);
        Tesla tesla3 = new Tesla("T003", "Model Y", teslaManufacturer, 78,
                true, true,true);
        Tesla tesla4 = new Tesla("T004", "Model Z", teslaManufacturer, 88,
                false, false,false);
        Tesla tesla5 = new Tesla("T005", "Model U", teslaManufacturer, 49,
                false, true,false);

        Ora ora1 = new Ora("O001", "Ora Model 1", oraManufacturer, 75,
                true, false);
        Ora ora2 = new Ora("O002", "Ora Model 2", oraManufacturer, 90,
                false, true);
        Ora ora3 = new Ora("O003", "Ora Model 3", oraManufacturer, 59,
                true, true);
        Ora ora4 = new Ora("O004", "Ora Model 4", oraManufacturer, 100,
                false, false);
        Ora ora5 = new Ora("O005", "Ora Model 5", oraManufacturer, 50,
                false, false);

        Customer customer1 = new Customer("001","John");
        customer1.addElectricCar(tesla1);
        customer1.addElectricCar(ora1);

        System.out.println("Electric Car Manufacturers and their Car Models:");
        displayCarManufacturersWithModels(teslaManufacturer);
        displayCarManufacturersWithModels(oraManufacturer);


        tesla1.setChargingStation(chargingStation1);
        ora2.setChargingStation(chargingStation2);

        System.out.println("\nCustomers and Their Electric Cars:");
        displayCustomerElectricCars(customer1);

        System.out.println("\nWould you like to purchase another car?(Y/N):");
        String choice = scanner.next();
        String choice1;
        String modelChoice;
        if(choice.equals("Y")||choice.equals("y")){
            displayCarManufacturersWithModels(teslaManufacturer);
            displayCarManufacturersWithModels(oraManufacturer);
            System.out.println("\nTesla or Ora?");
            choice1 = scanner.next();
            if(choice1.equals("Ora")||choice1.equals("ora")){
                displayCarManufacturersWithModels(oraManufacturer);
                System.out.println("\nPlease select the model(enter car ID):");
                modelChoice = scanner.next();
                if(modelChoice.equals("Ora 1")){
                    customer1.addElectricCar(ora1);
                } else if (modelChoice.equals("Ora 2")) {
                    customer1.addElectricCar(ora2);
                }else if (modelChoice.equals("Ora 3")) {
                    customer1.addElectricCar(ora3);
                }else if (modelChoice.equals("Ora 4")) {
                    customer1.addElectricCar(ora4);
                }else if (modelChoice.equals("Ora 5")) {
                    customer1.addElectricCar(ora5);
                }
            }else if(choice1.equals("Tesla")||choice1.equals("tesla")){
                displayCarManufacturersWithModels(teslaManufacturer);
                System.out.println("\nPlease select the model:");
                modelChoice = scanner.next();
                if(modelChoice.equals("Model S")){
                    customer1.addElectricCar(tesla1);
                } else if (modelChoice.equals("Model X")){
                    customer1.addElectricCar(tesla2);

                }else if (modelChoice.equals("Model Y")) {
                    customer1.addElectricCar(tesla3);
                }else if (modelChoice.equals("Model Z")) {
                    customer1.addElectricCar(tesla4);
                }else if (modelChoice.equals("Model U")) {
                    customer1.addElectricCar(tesla5);
                }

            }
        }
        displayCustomerElectricCars(customer1);
        System.out.println("\nThank you for visiting~");
    }

    private static void displayCarManufacturersWithModels(Manufacturer manufacturer) {
        System.out.println("Manufacturer: " + manufacturer.getManuName());
        System.out.println("Car Models: " + manufacturer.getCarModels());
        for (String model : manufacturer.getCarModels()) {
            System.out.println("- " + model);
        }
        System.out.println();
    }

    private static void displayCustomerElectricCars(Customer customer) {
        System.out.println("Customer: " + customer.getName());
        List<ElectricCar> electricCars = customer.getElectricCars();
        if (electricCars.isEmpty()) {
            System.out.println("No electric cars owned by this customer.");
        } else {
            for (ElectricCar car : electricCars) {
                System.out.println("Electric Car: " + car.getCarModel());
                System.out.println("Car Identifier: " + car.getCarID());
                System.out.println("Car Manufacturer: " + car.getManufacturer().getManuName());
                System.out.println("Battery Capacity: " + car.getBatteryCapacityKWh() + " kWh");

                ChargingStation chargingStation = car.getChargingStation();
                if (chargingStation != null) {
                    System.out.println("Charging Station: " + chargingStation.getChargeLocation());
                    System.out.println("Charging Capacity: " + chargingStation.getAvailableChargingCapacityKWh() + " kWh");
                } else {
                    System.out.println("Car is not currently charging at any station.");
                }

                if (car instanceof Tesla) {
                    Tesla teslaCar = (Tesla) car;
                    System.out.println("AutoPilot Enabled: " + teslaCar.isAutoPilotEnabled());
                    System.out.println("Full Self-Driving Enabled: " + teslaCar.isFullSelfDrivingEnabled());
                    System.out.println("Tesla Theatre Enabled: " + teslaCar.isTeslaTheatreEnabled());
                } else if (car instanceof Ora) {
                    Ora oraCar = (Ora) car;
                    System.out.println("Panoramic Sunroof: " + oraCar.hasPanaromicSunroof());
                    System.out.println("Wireless Charging: " + oraCar.hasWirelessCharging());
                }

                System.out.println();
            }
        }
        System.out.println();
    }
}
