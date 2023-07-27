import java.util.*;

public class Test {
    private static List<Manufacturer> manufacturers = new ArrayList<>();
    private static List<ChargingStation> chargingStations = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    // Method to add a car manufacturer
    private static void addCarManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    // Method to add a charging station
    private static void addChargingStation(ChargingStation chargingStation) {
        chargingStations.add(chargingStation);
    }

    // Method to add a customer
    private static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method for customers to purchase an electric car
    private static void purchaseElectricCar(Customer customer, ElectricCar electricCar) {
        customer.addElectricCar(electricCar);
    }

    // Method for customers to view and update the charging station
    private static void updateChargingStation(ElectricCar electricCar, ChargingStation chargingStation) {
        electricCar.setChargingStation(chargingStation);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Charging Stations
        ChargingStation chargingStation1 = new ChargingStation("CS001", "Location A", 100);
        ChargingStation chargingStation2 = new ChargingStation("CS002", "Location B", 150);
        addChargingStation(chargingStation1);
        addChargingStation(chargingStation2);

        // Create Car Manufacturers
        Manufacturer teslaManufacturer = new Manufacturer("M001", "Tesla");
        teslaManufacturer.addCarModel("Model S");
        teslaManufacturer.addCarModel("Model X");
        addCarManufacturer(teslaManufacturer);

        Manufacturer oraManufacturer = new Manufacturer("M002", "Ora");
        oraManufacturer.addCarModel("Ora Model 1");
        oraManufacturer.addCarModel("Ora Model 2");
        addCarManufacturer(oraManufacturer);

        // Create Customers
        Customer customer1 = new Customer("C001", "John");
        addCustomer(customer1);

        Customer customer2 = new Customer("C002", "Alice");
        addCustomer(customer2);

        // Print available car manufacturers and models
        System.out.println("Available Car Manufacturers:");
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }

        // Allow user to purchase electric cars
        System.out.println("\nPurchase Electric Cars:");
        System.out.print("Enter customer identifier (C001 or C002): ");
        String customerIdentifier = scanner.next();

        Customer selectedCustomer = null;
        for (Customer customer : customers) {
            if (customer.getCusID().equals(customerIdentifier)) {
                selectedCustomer = customer;
                break;
            }
        }

        if (selectedCustomer != null) {
            System.out.println("Available Car Models:");
            for (Manufacturer manufacturer : manufacturers) {
                System.out.println(manufacturer.getManuName() + ": " + manufacturer.getCarModels());
            }

            System.out.print("Enter car model to purchase: ");
            String carModel = scanner.next();

            Manufacturer selectedManufacturer = null;
            for (Manufacturer manufacturer : manufacturers) {
                if (manufacturer.getCarModels().contains(carModel)) {
                    selectedManufacturer = manufacturer;
                    break;
                }
            }

            if (selectedManufacturer != null) {
                ElectricCar electricCar = new ElectricCar(UUID.randomUUID().toString(), carModel,
                        selectedManufacturer, 0); // You may want to prompt for battery capacity too
                purchaseElectricCar(selectedCustomer, electricCar);
                System.out.println("Car purchased successfully!");
            } else {
                System.out.println("Invalid car model.");
            }
        } else {
            System.out.println("Invalid customer identifier.");
        }

        // Allow user to view and update the charging station
        System.out.println("\nUpdate Charging Station:");
        System.out.print("Enter customer identifier (C001 or C002): ");
        customerIdentifier = scanner.next();

        selectedCustomer = null;
        for (Customer customer : customers) {
            if (customer.getCusID().equals(customerIdentifier)) {
                selectedCustomer = customer;
                break;
            }
        }

        if (selectedCustomer != null) {
            List<ElectricCar> customerCars = selectedCustomer.getElectricCars();
            if (!customerCars.isEmpty()) {
                System.out.println("Your Electric Cars:");
                for (ElectricCar car : customerCars) {
                    System.out.println(car);
                }

                System.out.print("Enter car identifier to update charging station: ");
                String carIdentifier = scanner.next();

                ElectricCar selectedCar = null;
                for (ElectricCar car : customerCars) {
                    if (car.getCarID().equals(carIdentifier)) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    System.out.print("Enter charging station identifier: ");
                    String stationIdentifier = scanner.next();
                    ChargingStation selectedStation = null;
                    for (ChargingStation chargingStation : chargingStations) {
                        if (chargingStation.getChargeID().equals(stationIdentifier)) {
                            selectedStation = chargingStation;
                            break;
                        }
                    }

                    if (selectedStation != null) {
                        updateChargingStation(selectedCar, selectedStation);
                        System.out.println("Charging station updated successfully!");
                    } else {
                        System.out.println("Invalid charging station identifier.");
                    }
                } else {
                    System.out.println("Invalid car identifier.");
                }
            } else {
                System.out.println("No electric cars owned by this customer.");
            }
        } else {
            System.out.println("Invalid customer identifier.");
        }

        // Display the list of electric cars owned by each customer and their corresponding details
        System.out.println("\nCustomers and Their Electric Cars:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
