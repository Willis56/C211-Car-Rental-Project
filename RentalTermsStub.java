/*
 * 
 * Project Stub
 * Simple Car Rental System
 * 
 * File: RentalTermsStub.java
 * 
 * 
 * Establish rental terms
 * Create abstract method for calculating total cost, inherited by Car class
 * Includes attributes of rentalLength, rentalTotal, and customer
 * 
 * 
 * @author: Morgan Elliott
 * @version 1.0
 * @date: 12/13/24
 * 
 */

public abstract class RentalTermsStub {
	
	protected int rentalLength;
	protected Customer customer;
	protected double rentalTotal;
	
	public RentalTermsStub(int rentalLength,Customer customer, double rentalTotal) {
        this.rentalLength = rentalLength;
        this.customer = customer;
        this.rentalTotal = rentalTotal;
    }
	
    // get and set rental length
    public int getrentalLength() {
        return rentalLength;
    }

    public void setRentalLength(int rentalLength) {
        this.rentalLength = rentalLength;
    }
	
    // get and set customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
	
    // get and set rental total
    public double getRentalTotal() { 
    	return rentalTotal;
    }
    
    public void setRentalTotal(double rentalTotal) {
    	this.rentalTotal = rentalTotal;
    }
    
    // shared methods with subclass
    // calculate rental total using rentalLength * dailyCost
    public abstract void calculateTotal();

    // toString method
    @Override
    public String toString() {
        return "Rental Length: " + rentalLength + "\n" + customer.toString() + "\nRental Total: " + rentalTotal;
    }	
	
}
