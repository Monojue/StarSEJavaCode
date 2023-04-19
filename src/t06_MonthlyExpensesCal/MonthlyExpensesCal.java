package t06_MonthlyExpensesCal;

import java.util.ArrayList;
import java.util.Scanner;

public class MonthlyExpensesCal {
	private static int totalAmount = 200000;
	private static String[] expName = new String[] { "house-rent", "phone-bill", "shopping", "electric-bill",
			"water-supply-bill", "gas-bill" };

	private static ArrayList<Float> expAmount = new ArrayList<>();

	public static void main(String[] args) {
		// start processing.
		processing(totalAmount, expName, expAmount);
	}

	private static void processing(int totalAmount, String[] expName, ArrayList<Float> expAmount) {
		Scanner sc = new Scanner(System.in);
		boolean error = false;

		// if expense is already add, skip this expense.
		for (int i = expAmount.size(); i < expName.length; i++) {

			System.out.print(String.format("Enter monthly expences for %s : ", expName[i]));
			if (sc.hasNextFloat()) // if input is a number
				// add to expenses amount array
				expAmount.add(sc.nextFloat());
			// if input is not a number
			else {
				// show error message and set error as true
				System.out.println("Sorry.Input Worng! Input Again!");
				error = true;
				break;
			}
		}

		// if error happened, try to processing again by calling this method again.
		if (error)
			processing(totalAmount, expName, expAmount);
		// if everything correct.
		else {
			// calculate and show
			float totalExp = 0;
			float rAmount = 0;

			for (float bill : expAmount) {
				totalExp += bill;
			}

			rAmount = totalAmount - totalExp;

			System.out.println(String.format("Total Expences : %s yen", totalExp));
			System.out.println(String.format("Remaining Amount : %s yen", rAmount));

			// close the scanner.
			sc.close();
		}
	}
}
