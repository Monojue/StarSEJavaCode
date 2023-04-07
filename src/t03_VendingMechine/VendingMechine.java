package t03_VendingMechine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMechine {

	private static Scanner sc = new Scanner(System.in);
	private static boolean exit = false;
	private static int cash = 0;

	public static void main(String[] args) {

		productService pService = new productService();

		// Add Product using Product Service.
		pService.addNewProduct(new Product("Tea", 190));
		pService.addNewProduct(new Product("Pure Water", 100));
		pService.addNewProduct(new Product("Pepsi", 130));
		pService.addNewProduct(new Product("Coffee", 150));
		pService.addNewProduct(new Product("Energy Drink", 220));

		while (!exit) {
			try {
				System.out.println(String.format("Your cash amount : %s", cash));
				// Show all product.
				pService.showAllProducts();
				// Get user's cash amount.
				System.out.print("Please input your cash (n/N to cancel): ");
				cash = getInputIfNotCancel();

				vendingProcessing(pService);

			} catch (IndexOutOfBoundsException e) { // if user choose the product that does not exit.
				if (!exit)
					System.out.println("Sorry. Product does not found!");
			} catch (InputMismatchException e) { // if user type the wrong input.
				System.out.println("Sorry. Input Worng!");
			}
			System.out.println();
		}
		System.out.println("GoodBye!");
	}

	private static void vendingProcessing(productService pService) {
		// if cash is not enough vending machine will not processing.
		if (cash <= 0)
			return;

		System.out.println(String.format("Your cash amount : %s", cash));

		// Filter the product that can able to buy with input amount.
		int size = pService.showFilterProducts(cash);

		if (size > 0) { // if user can able buy some products.

			// Get product id no form user input.
			System.out.print("Please input prodcut number you want to buy (n/N to cancel): ");
			var pNum = getInputIfNotCancel();

			// Get the product object using Product Service by product ID.
			Product buyP = pService.getProduct(pNum);

			if (cash >= buyP.getPrice()) {
				cash -= buyP.getPrice();
				System.out.println("Thank You!");
				vendingProcessing(pService);
			}
		} else { // if there is nothing that user can able to buy.
			System.out.println("Sorry! Your input amount is not enough to buy.");
			System.out.println("Type cash amount to add more money (n/N to cancel): ");

			if (sc.hasNextInt()) {
				cash += getInputIfNotCancel();
				vendingProcessing(pService);
			}
		}
	}

	// Every time get userInput check cancel or not.
	// if cancel program will exit.
	// if no cancel return user input.
	private static Integer getInputIfNotCancel() {
		if (sc.hasNextInt())
			return sc.nextInt();
		else if (sc.next().matches("[n|N]")) {
			exit = true;
			if (cash > 0)
				System.out.println("Please take your change : " + cash);
		}
		return 0;
	}
}
