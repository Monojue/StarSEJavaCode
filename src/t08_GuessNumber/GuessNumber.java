package t08_GuessNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		int rnd = (int) (Math.random() * 10);
		Scanner sc = new Scanner(System.in);
		System.out.println("======= Guess the Number =======");
		String tryagian = "yes";
		do {
			try {

				System.out.print("Input a number between 0 and 9: ");
				Integer inputNum = sc.nextInt();

				if (inputNum.toString().matches("\\d")) {
					if (inputNum == rnd) {
						System.out.println("======= Congratulation! =======");
						sc.close();
						break;
					} else {
						System.out.print("Sorry! Would you like to try agian?(yes/no) : ");
						tryagian = sc.next();
					}
				} else {
					System.out.println(">>>>Input more than 1 line!");
				}
			} catch (InputMismatchException e) {
				System.out.println(">>>>Input is not a Number!");
				sc.next();
			}
			System.out.println();
		} while (tryagian.equals("yes") || tryagian.equals("Y") || tryagian.equals("y"));
		System.out.println("== Thank you ==");
		sc.close();
	}
}
