package t09_HotelBookingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelBookingSystem {

	private static Boolean[] roomStatus = new Boolean[10];
	private static int menuId = 0;
	private static Scanner scan = new Scanner(System.in);
	private static boolean exit = false;

	public static void main(String[] args) {

		// set all roomStatus as true (true : not booked, false : booked)
		initializeRooms();

		while (!exit) {
			try {
				// display the initial display.
				displayOptions();
				switch (menuId) {
				case 1:
					bookRoom();
					break;
				case 2:
					cancelBooking();
					break;
				case 3:
					displayBookings();
					break;
				case 4:
					exit();
					break;
				default:
					showErrorMessage();
					break;
				}
			} catch (InputMismatchException e) {
				scan.next();
				System.out.println(">>Invalid input. Please enter number only.");
			}
		}
	}

	// set all roomStatus as true (true : not booked, false : booked)
	private static void initializeRooms() throws InputMismatchException {
		for (int i = 0; i < roomStatus.length; i++) {
			roomStatus[i] = true;
		}
	}

	// initial display and get user input.
	private static void displayOptions() throws InputMismatchException {
		System.out.print("""

				Welcome to the Hotel Booking System!
				1. Book a room
				2. Cancel booking
				3. Display bookings
				4. Exit
				Enter your choice : """);

		menuId = scan.nextInt();
	}

	private static void bookRoom() throws InputMismatchException {
		System.out.println(">>Please enter the room number you want to book (1-10) : ");

		// get the room no from user.
		var roomNo = scan.nextInt() - 1;
		// if room can be book. set room status as booked.
		if (roomStatus[roomNo]) {
			System.out.println(">>Booking successful! Thank you for choosing our hotel.");
			roomStatus[roomNo] = false;
		} else {
			System.out.println(">>This room is already booked, please choose another room.");
		}
	}

	private static void cancelBooking() {
		System.out.println(">>Please enter the room number you want to cancel (1-10) : ");

		// get the room no from user.
		var roomNo = scan.nextInt() - 1;
		// if room is already booked. set room status true to cancel.
		if (roomStatus[roomNo]) {
			System.out.println(">>This room is not booked, please enter a valid room number.");
		} else {
			System.out.println(">>Booking cancelled successfully.");
			roomStatus[roomNo] = true;
		}
	}

	// show the room that already booked.
	private static void displayBookings() {
		int roomNo = 1;
		for (Boolean notBooked : roomStatus) {
			if (!notBooked) {
				System.out.println(String.format(">>Room %d : %s", roomNo, (notBooked ? "not booked" : "booked")));
			}
			roomNo++;
		}
	}

	private static void exit() {
		System.out.println(">>Exiting Hotel Booking System. Goodbye!");
		exit = true;
		scan.close();
	}

	private static void showErrorMessage() {
		System.out.println(">>Invalid choice, please try again.");
	}
}
