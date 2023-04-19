package t11_Shape;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			var radius = 0f;
			var width = 0f;
			var height = 0f;

			do {
				// if user input invalid, continue loop and get input again.
				if (radius == 0f) {
					System.out.print("""
							Welcome to Area and Perimeter Calculator.
							Enter the radius of the circle:""");
					if (scan.hasNextFloat()) {
						radius = scan.nextFloat();
					} else {
						System.out.println(">>Invalid Input!");
						scan.next();
						continue;
					}
				}

				if (width == 0f) {
					System.out.print("Enter the width of the rectangle:");
					if (scan.hasNextFloat()) {
						width = scan.nextFloat();
					} else {
						System.out.println(">>Invalid Input!");
						scan.next();
						continue;
					}

				}

				if (height == 0f) {
					System.out.print("Enter the height of the rectangle:");

					if (scan.hasNextFloat()) {
						height = scan.nextFloat();
					} else {
						System.out.println(">>Invalid Input!");
						scan.next();
						continue;
					}
				}

				break;
			} while (true);
			
			Circle circle = new Circle(radius);
			Rectangle rectangle = new Rectangle(height, width);

			System.out.println(String.format("""
					
					Area of Circle		: %s
					Perimeter of circle	: %s
					Area of rectangle	: %s
					Perimeter of rectangle	: %s""", circle.getArea(), circle.getPerimeter(), rectangle.getArea(),
					rectangle.getPerimeter()));
		}
	}
}
