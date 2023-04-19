package t11_Shape;

public class Rectangle extends Shape {

	private double length;
	private double width;

	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		return (length * width);
	}

	@Override
	public double getPerimeter() {
		return (2 * getArea());
	}

}
