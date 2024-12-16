import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemTest {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			RentalSystemStub rental = new RentalSystemStub();
			ArrayList<CarStub> carList = new ArrayList<>();
			
			CarStub car1 = new CarStub("Honda", "CRV", 2024, "001", 150);
	        carList.add(car1);
	        CarStub car2 = new CarStub("Toyota", "Highlander", 2023, "002", 175);
	        carList.add(car2);
	        CarStub car3 = new CarStub("Chevy", "Cruze", 2022, "003", 110);
	        carList.add(car3);

			// menu display
			while (true) {
				System.out.print("\n");
				System.out.println("\nCar Rental Menu:");
				System.out.println("=================");
				System.out.print("\n");
				System.out.println("1. Display Available Cars");
				System.out.println("2. Calculate Rental Cost");
				System.out.println("3. Select Car Rental");
				System.out.println("4. Return Car Rental");
				System.out.println("5. Exit");
				System.out.print("\n");
				System.out.print("Please input your choice <1-5>: ");
				System.out.print("\n");
				int option = scanner.nextInt();
				scanner.nextLine();

				// if input value is out of range:
				try {
					if (option < 1 || option > 5) {
						System.out.println("Range Error: Invalid input. Please input your choice <1-5>: \n ");
						continue;
					}
					// case options
					switch (option) {
					case 1:
						System.out.println("Cars available for rent: \n");
						for (CarStub car : carList) {
							System.out.println(car.toString());
						} break;
					case 2:
						System.out.println("Number of days of projected rental: ");
						int length = scanner.nextInt();
						System.out.println("Enter the Car ID for interested rental: ");
						String totalID = scanner.nextLine();
						rental.calculateTotal(totalID, length);
						break;

					case 3:
						System.out.println("Enter Customer name: ");
						String name = scanner.nextLine();
						System.out.println("Enter Customer License: ");
						String license = scanner.nextLine();
						System.out.println("Enter phone number: ");
						String phone = scanner.nextLine();
						new Customer(name, license, phone);
						System.out.println("Enter Car ID to rent: ");
						String carIDRemove = scanner.nextLine();
						System.out.println("Enter rental length: ");
						int rentalLength = scanner.nextInt();
						System.out.println("Cost of rental: ");
						rental.calculateTotal(carIDRemove, rentalLength);
						//
						//
						//
						rental.rentCar(carIDRemove);
						break;
					case 4:
						System.out.println("Enter Car Id to return: ");
						String returnID = scanner.nextLine();
						rental.returnCar(returnID);
					case 5:
						System.out.println("Thank you for renting with us.");
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
}

	


