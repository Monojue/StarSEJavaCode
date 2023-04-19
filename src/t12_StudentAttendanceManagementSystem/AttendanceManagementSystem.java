package t12_StudentAttendanceManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.Scanner;

public class AttendanceManagementSystem {

	private static boolean exit = false;
	private static Scanner scan;
	private static StudentService service;

	public static void main(String[] args) {
		service = new StudentService();
		scan = new Scanner(System.in);

		do {
			System.out.print("""
					Welcome to Student Attendance Management System. Please choose an option:
					1. View all students' attendance
					2. Mark attendance
					3. Exit
					Enter your choice:""");

			var choiceId = scan.nextInt();

			switch (choiceId) {
			case 1 -> viewAllStudentAttendance();
			case 2 -> markAttendance();
			case 3 -> exit();
			default -> System.out.println("Invalid choice. Please enter a number from 1-3.");
			}
		} while (!exit);

	}

	private static void exit() {
		exit = true;
		scan.close();
		System.out.println("Exiting Student Attendance Management System. Goodbye!");
	}

	private static void markAttendance() {
		System.out.println("Enter the student ID :");
		var studentId = scan.nextInt();
		if (service.searchStudentById(studentId)) {
			System.out.print("Enter the attendance status (p or a) :");

			var status = scan.next();
			service.setStudentStatus(studentId, status.charAt(0));

			System.out.println("Attendance data has been written to file.");

		} else {
			System.out.println("Please enter the correct student ID");
		}
	}

	private static void viewAllStudentAttendance() {
		System.out.println("Name\tAttendance Status");
		var list = service.getAllStudentList();
		list.forEach(System.out::println);
	}
}
