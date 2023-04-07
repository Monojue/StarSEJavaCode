package t08_GuessNumber;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		int rnd = (int) (Math.random() * 10);

		System.out.println("======= Guess the Number =======");
		String tryagian = "yes";

		while (tryagian.equals("yes") || tryagian.equals("Y") || tryagian.equals("y")) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Please Input Number : ");
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
			}
			System.out.println();
		}
	}
}
