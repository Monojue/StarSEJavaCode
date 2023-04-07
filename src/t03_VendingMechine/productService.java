package t03_VendingMechine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class productService {

	List<Product> products = new ArrayList<>();
	List<Product> filterProducts;

	// Add new product to product list
	public void addNewProduct(Product product) {
		products.add(product);
	}

	// Show all products form product list
	public void showAllProducts() {
		for (int i = 0; i < products.size(); i++) {
			System.out.println((i + 1) + ". " + products.get(i).toString());
		}
	}

	// Filter the product by amount of user cash and show the filter product.
	public int showFilterProducts(int cash) {
		filterProducts = products.stream().filter(a -> a.getPrice() <= cash).collect(Collectors.toList());

		for (int i = 0; i < filterProducts.size(); i++) {
			System.out.println((i + 1) + ". " + filterProducts.get(i).toString());
		}

		return filterProducts.size();

	}

	// get the product by ID.
	public Product getProduct(int id) throws IndexOutOfBoundsException {
		return filterProducts.get(id - 1);
	}
}
