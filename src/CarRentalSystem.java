import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalSystem {
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;
    private Scanner scanner;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeCars(); // Add some sample cars
    }

    private void initializeCars() {
        cars.add(new Car("C001", "Toyota", "Camry", 60.0));
        cars.add(new Car("C002", "Honda", "Accord", 65.0));
        cars.add(new Car("C003", "BMW", "3 Series", 90.0));
        cars.add(new Car("C004", "Tesla", "Model 3", 100.0));
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. View Available Cars");
            System.out.println("3. Rent a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewAvailableCars();
                    break;
                case 3:
                    rentCar();
                    break;
                case 4:
                    System.out.println("Thank you for using Car Rental System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCustomer() {
        System.out.println("\n=== Add Customer ===");
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        customers.add(new Customer(id, name, phone, email));
        System.out.println("Customer added successfully!");
    }

    private void viewAvailableCars() {
        System.out.println("\n=== Available Cars ===");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    private void rentCar() {
        if (customers.isEmpty()) {
            System.out.println("Please add a customer first!");
            return;
        }

        System.out.println("\n=== Rent a Car ===");
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId().equals(customerId)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        viewAvailableCars();
        System.out.print("Enter car ID to rent: ");
        String carId = scanner.nextLine();

        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getId().equals(carId) && car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }

        if (selectedCar == null) {
            System.out.println("Invalid car selection!");
            return;
        }

        System.out.print("Enter number of days for rental: ");
        int days = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Rental rental = new Rental(customer, selectedCar, days);
        rentals.add(rental);
        selectedCar.setAvailable(false);

        rental.displayRentalInfo();
    }

    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        rentalSystem.showMainMenu();
    }
}