package t04_Star;


public class Star {

	public static void main(String[] args) {

		System.out.println("i)");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("ii)");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5 - i); j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("iii)");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(j>=i) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			for (int j = 4; j > 0; j--) {
				if(j>i) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
