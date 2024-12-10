
/**
 * Project - Car Rental Management
 * Class Author - Josh Willis
 * 12/10/2024
 * The project will simulate a car rental system with an interface to select the car and calculate costs
 */

public class CarStub {
    
    private String Make;
    private String Model;
    private int Year;
    private int carID;
    

    
 // Constructor to initialize Car attributes
    public Car(String Make, String Model, int Year, int carID) {
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
        this.carID = carID;
    }

 // Get method for Make
    public String getMake() {
        return Make;
    }
    
 // set method for Make
    public void setMake(String Make) {
        this.Make = Make;
    }

 // Get method for Model
    public String getModel() {
        return Model;
    }
    
 // Set method for Model
    public void setModel(String Model) {
        this.Model = Model;
    }

 // Get method for Year
    public int Year() {
        return Year;
    }
    
 // Set method for Year
    public void setYear( int Year) {
        this.Year = Year;
    }
    
 // Get method for carID
    public int carID() {
        return Year;
    }
    
 // Set method for carID
    public void carID( int Year) {
        this.Year = Year;
    }

    
    @Override
    public String toString() {
        return "Car Make: " + Make + ", Model: " + Model + ", Year: " + Year + ", Car ID: " + carID;
    }
}


