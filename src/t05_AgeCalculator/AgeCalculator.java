package t05_AgeCalculator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {
	
	// use simple date 
	// use java Date

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your birthday (YYYY/MM/DD) : ");

		var bDay = sc.nextLine();

		if (bDay.matches("\\d{4}/\\d{2}/\\d{2}")) {

			Date date = new Date();
			System.out.println(date.getDate());
//			var bDate = 
//			var bNow = 
//
//			Period pd = Period.between(bDate, bNow);
//
//			if (pd.getYears() > 0)
//				System.out.println(String.format("You are %s years old.", pd.getYears()));
//			else if (pd.getMonths() > 0)
//				System.out.println(String.format("You are %s months old.", pd.getMonths()));
//			else if (pd.getDays() > 0)
//				System.out.println(String.format("You are %s days old.", pd.getDays()));
//			else if (pd.getDays() == 0)
//				System.out.println("You born Today!");
//			else
//				System.out.println("You will born in Future!");

		}else {
			System.out.println("Please type birthday in YYYY/MM/DD format!");
			main(args);
		}

		sc.close();

	}
}
