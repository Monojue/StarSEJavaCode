package t05_AgeCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your birthday (YYYY/MM/DD) : ");

		var dob = sc.nextLine();

		if (dob.matches("\\d{4}/\\d{2}/\\d{2}")) {

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date bDate = sdf.parse(dob);
				long ageInMillis = System.currentTimeMillis() - bDate.getTime();
				/*
				 * calculate miliSec to year 1 second = 1000 millisecond 1 minute = 60 second 1
				 * hour = 60 minutes 1 day = 24 hours 1 year = 365 days
				 */
				long ageInDay = ageInMillis / 1000L / 60L / 60L / 24L;
				long ageInMonth = ageInDay / 30L;
				long ageInYears = ageInMillis / 1000L / 60L / 60L / 24L / 365L;
			
				if (ageInYears > 0)
					System.out.println(String.format("You are %s years old.", ageInYears));
				else if (ageInMonth > 0)
					System.out.println(String.format("You are %s months old.", ageInMonth));
				else if (ageInDay > 0)
					System.out.println(String.format("You are %s days old.", ageInDay));
				else if (ageInDay == 0)
					System.out.println("You born Today!");
				else
					System.out.println("You will born in Future!");
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("Please type birthday in YYYY/MM/DD format!");
			main(args);
		}

		sc.close();

	}
}
