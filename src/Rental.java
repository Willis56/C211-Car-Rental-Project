public class Rental {
    private Customer customer;
    private Car car;
    private int days;
    private double totalCost;

    public Rental(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
        this.totalCost = calculateCost();
    }

    private double calculateCost() {
        return car.getDailyRate() * days;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void displayRentalInfo() {
        System.out.println("\n=== Rental Information ===");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car: " + car.getBrand() + " " + car.getModel());
        System.out.println("Days: " + days);
        System.out.println("Total Cost: $" + totalCost);
    }
}