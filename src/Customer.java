import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String cusID;
    private String name;
    private List<ElectricCar> electricCars;

    protected Customer(String cusID,String name){
        this.cusID = cusID;
        this.name=name;
        this.electricCars = new ArrayList<>();
    }
    public String getCusID(){
        return name;
    }

    public void setCusID(String cusID){
        this.cusID=cusID;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public void addElectricCar(ElectricCar electricCar) {
        electricCars.add(electricCar);
    }
    public List<ElectricCar> getElectricCars() {
        return electricCars;
    }

}
