package t03_VendingMechine;

public class Product {

	private String name;
	private int price;

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s (%s yen)", name, price);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
