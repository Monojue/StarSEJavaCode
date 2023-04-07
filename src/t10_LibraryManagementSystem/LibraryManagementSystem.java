package t10_LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystem {

	private static Members membersData;
	private static Books booksData;
	private static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		initializedData();
		initializedDisplay();
		
		
	}

	private static int initializedDisplay() {
		System.out.println("""
				Welcome to the library management system.Please choose an option:
				1. Display All Books
				2. Display All Members
				3. Lend Book
				4. Return Book
				5. Exit
				Enter your choice:""");
		if(sc.hasNextInt()) return sc.nextInt();
		else System.out.println("Input Error!");
		return -1;
	}

	private static void initializedData() {
		var data = new Data();
		data.seed();
		membersData = data.getMembersData();
		booksData = data.getBooksData();
	}
}
