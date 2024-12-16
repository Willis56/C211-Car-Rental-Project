/*
 * 
 * Project Stub
 * Simple Car Rental System
 * 
 * File: RentalSystemStub.java
 * 
 * Create methods for the Use Class:
 * Create Car constructor
 * Method for displaying car information
 * Method for renting car // removing carID from available cars, adding carID to unavailable cars
 * Method for returning car // removing carID from unavailable cars, adding carID to available cars
 * 
 * 
 * @author: Morgan Elliott
 * @version 1.0
 * @date: 12/16/24
 * 
 */

import java.util.ArrayList;

public class RentalSystemStub {
	
	// array lists for available and unavailable
	protected ArrayList<CarStub> availableCars;
	protected ArrayList<CarStub> unavailableCars;
	
	// create car constructor
	public void createCar(int rentalLength, Customer customer, double rentalTotal, String Make, String Model, int Year, String carID, int dailyCost) {
		availableCars.add(new CarStub(rentalLength, customer, rentalTotal, Make, Model, Year, carID, dailyCost));
		
	}
	
	// display car information by searching carID
	public void displayCarInformation(String carIDInfo) {
		for (CarStub id : availableCars) {
            if (id.getCarID().equalsIgnoreCase(carIDInfo)) {
                System.out.println(id.toString());
                return;
            }
        }
        System.out.println("Car ID not found!");
		
	}
	
	// when customer rents a car
	// remove car from available array list using carID
	// add car to unavailable array list using carID
	public void rentCar(String carIDRemove) {
		for (CarStub id : availableCars) {
	        if (id.getCarID().equalsIgnoreCase(carIDRemove)){
	        	availableCars.remove(id);
	        	unavailableCars.add(id);
	        	System.out.println("\nCar rental initiated\n");
	        	return;
        	}
        
		} System.out.println("Car ID not found!");
	}
	
	// when customer returns a car
	// remove car from unavailable array list using carID
	// add car to available array list using carID
	public void returnCar(String carIDRemove) {
		for (CarStub id : unavailableCars) {
	        if (id.getCarID().equalsIgnoreCase(carIDRemove)){
	        	unavailableCars.remove(id);
	        	availableCars.add(id);
	        	System.out.println("\nCar rental returned\n");
	        	return;
        	}
        
		} System.out.println("Car ID not found!");
	}

}
