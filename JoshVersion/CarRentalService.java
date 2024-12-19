
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarRentalService {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RentalSystem rentalSystem = new RentalSystem();

        // Preload cars
        rentalSystem.addCar(new Car("Honda", "CRV", 2024, 1, 150));
        rentalSystem.addCar(new Car("Toyota", "Highlander", 2023, 2, 175));
        rentalSystem.addCar(new Car("Chevrolet", "Cruze", 2022, 3, 110));

        int rentalDays = 0;
        Customer currentCustomer = null;

        // menu display
        while (true) {
            System.out.print("\n");
            System.out.println("\nCar Rental Menu:");
            System.out.println("=================");
            System.out.print("\n");
            System.out.println("1. Create New Customer");
            System.out.println("2. Display Available Cars");
            System.out.println("3. Set Number of Rental Days");
            System.out.println("4. Rent a Car");
            System.out.println("5. Return a Car");
            System.out.println("6. Exit");
            System.out.print("\n");
            System.out.print("Please input your choice <1-6>: ");
            System.out.print("\n");
            int option = scanner.nextInt();
            scanner.nextLine();

            // if input value is out of range:
            try {
                if (option < 1 || option > 6) {
                    System.out.println("Range Error: Invalid input. Please input your choice <1-6>: \n ");
                    continue;
                }
                // case options
                switch (option) {

                    //customer creation process
                    case 1:
                        System.out.print("Enter Customer Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Customer License: ");
                        String license = scanner.nextLine();
                        System.out.print("Enter Customer Phone Number: ");
                        String phone = scanner.nextLine();

                        currentCustomer = new Customer(name, license, phone);
                        System.out.println("Customer created: " + currentCustomer);
                        break;

                    // display available cars
                    case 2:
                        rentalSystem.displayAvailableCars();
                        break;

                    // set number of rental days
                    case 3: // Set Rental Days
                        System.out.print("Enter the number of rental days: ");
                        rentalDays = scanner.nextInt();
                        if (rentalDays > 0) {
                            System.out.println("Rental days set to " + rentalDays + ".");
                        } else {
                            System.out.println("Invalid number of days. Please enter a positive value.");
                            rentalDays = 0; // Reset rental days on invalid input
                        }
                        break;

                    // rent car process    
                    case 4:
                        if (currentCustomer == null) {
                            System.out.println("Please create a customer first (option 1).");
                            break;
                        }

                        if (rentalDays <= 0) {
                            System.out.println("Please set the number of rental days first (option 2).");
                            break;
                        }
                        System.out.print("Enter Car ID to rent: ");
                        int carID = scanner.nextInt();
                        System.out.print("Enter rental days: ");
                        int days = scanner.nextInt();
                        double totalCost = rentalSystem.calculateTotal(carID, days);

                        if (totalCost > 0 && rentalSystem.rentCar(carID)) {
                            System.out.println("Rental successful! Total cost: $" + totalCost);
                        } else {
                            System.out.println("Car not available.");
                        }
                        break;

                    //return car process
                    case 5:
                        System.out.print("Enter Car ID to return: ");
                        int returnID = scanner.nextInt();
                        if (rentalSystem.returnCar(returnID)) {
                            System.out.println("Car returned successfully!");
                        } else {
                            System.out.println("Invalid Car ID.");
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for your business!");
                        scanner.close();
                        return;
                }

            } catch (InputMismatchException e) {
                // exception catch
                System.out.println("Range Error: Invalid input. Please input your choice <1-5>: \n");
                scanner.nextLine();
                continue;
            }

        }
    }
}
