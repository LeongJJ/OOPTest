import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    private String manuID;
    private String manuName;
    private List<String> carModels;
    private List<ElectricCar> cars;

    protected Manufacturer(String manuID, String manuName ) {
        this.manuID = manuID;
        this.manuName = manuName;
        this.carModels = new ArrayList<>();

    }

    public void addCarModel(String model) {
        carModels.add(model);
    }

    // Getters

    public String getManuID() {
        return manuID;
    }
    public void setManuID(String manuID){
        this.manuID=manuID;
    }
    public String getManuName() {
        return manuName;
    }
    public void setManuNames(String manuName){

        this.manuName=manuName;
    }

    public List<String> getCarModels() {

        return carModels;
    }
     public void setCarModels(ArrayList<String> carModels){
        this.carModels=carModels;
     }
    public void addCar(ElectricCar car) {
        cars.add(car);
    }
    public List<ElectricCar> getCars() {
        return cars;
    }
}
