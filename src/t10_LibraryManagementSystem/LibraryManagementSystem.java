package t10_LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystem {

	private static Members membersService;
	private static Books booksService;
	private static Scanner sc = new Scanner(System.in);
	private static boolean exit = false;

	public static void main(String[] args) {
		//
		initializedData();
		do {

			// get user choice id
			var choiceId = initializedDisplay();

			switch (choiceId) {
			case 1 -> booksService.displayAllBooks();
			case 2 -> membersService.displayAllMembers();
			case 3 -> lendBook();
			case 4 -> returnBook();
			case 5 -> exit();
			default -> showErrorMessage();
			}

		} while (!exit);

	}

	private static void showErrorMessage() {
		System.out.println("Invalid choice. Please enter a number from 1-5.");
	}

	private static void exit() {
		exit = true;
		System.out.println("Exiting Library Management System. Goodbye!");
	}

	private static void returnBook() {
		while (true) {
			System.out.print("Enter book ID: ");
			var bookId = getUserInput("Please enter correct book ID"); // return -1 if input is not integer.
			if (bookId < 0)
				continue; // make user input id again.

			try {
				if (!booksService.isAlreadyLend(bookId)) {
					System.out.println("Your choice is already returned.");
					continue;
				}
			}catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
				continue;
			}

			// search book by id
			if (booksService.searchBookById(bookId)) { // if book found
				while (true) {
					System.out.print("Enter member ID: ");
					var memberId = getUserInput("Please enter correct member ID"); // return -1 if input is not integer.
					if (memberId < 0)
						continue; // make user input id again.

					try {
						// search member by id
						if (membersService.searchMemberById(memberId)) {
							// check this member lend this book.
							if(membersService.isMemberlendTheBook(memberId, booksService.getBookById(bookId))) {
								// set lend flag as return.
								booksService.returnBook(bookId);

								// also set which member lend which book
								membersService.getMemberById(memberId).returnBook(booksService.getBookById(bookId));
							}else {
								System.out.println("Something worng! You did not lend this book.");
							}
							System.out.println("Thank you!");
						} else { // if member does not found, make user input id again.
							System.out.println("Please enter correct member ID");
							continue;
						}
					}catch(MemberNotFoundException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}
			} else { // if book does not found, make user input id again.
				System.out.println("Please enter correct book ID.");
				continue;
			}
			break;
		}
	}

	private static int getUserInput(String message) {
		if (sc.hasNextInt()) {
			return sc.nextInt();
		} else {
			sc.next();
			System.out.println(message);
		}
		return -1;
	}

	private static void lendBook() {
		while (true) {
			System.out.print("Enter book ID: ");
			var bookId = getUserInput("Please enter correct book ID"); // return -1 if input is not integer.
			if (bookId < 0)
				continue; // make user input id again.

			try {
				if (booksService.isAlreadyLend(bookId)) {
					System.out.println("Your choice is already lended.");
					continue;
				}
			}catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
				continue;
			}

			// search book by id
			if (booksService.searchBookById(bookId)) { // if book found
				while (true) {
					System.out.print("Enter member ID: ");
					var memberId = getUserInput("Please enter correct member ID"); // return -1 if input is not integer.
					if (memberId < 0)
						continue; // make user input id again.

					try {
						// search member by id
						if (membersService.searchMemberById(memberId)) {
							// set lend flag as lend.
							booksService.lendBook(bookId);

							// also set which member lend which book
							membersService.getMemberById(memberId).lendBook(booksService.getBookById(bookId));

							System.out.println("Thank you!");
						} else { // if member does not found, make user input id again.
							System.out.println("Please enter correct member ID");
							continue;
						}
					}catch(MemberNotFoundException e) {
						System.out.println(e.getMessage());
						continue;
					}
					break;
				}
			} else { // if book does not found, make user input id again.
				System.out.println("Please enter correct book ID.");
				continue;
			}
			break;
		}
	}

	private static int initializedDisplay() {
		System.out.print("""
				================================================================
				Welcome to the library management system.Please choose an option:
				1. Display All Books
				2. Display All Members
				3. Lend Book
				4. Return Book
				5. Exit
				Enter your choice:""");
		if (sc.hasNextInt())
			return sc.nextInt();
		else
			System.out.println("Input Error!");
		return -1;
	}

	// create data of book and member
	//
	private static void initializedData() {
		var data = new Data();
		data.seed();
		membersService = data.getMembersData();
		booksService = data.getBooksData();
	}
}
