package t10_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Books {

	private List<Book> books = new ArrayList<>();

	public void addNewBook(int bookId, String title) {
		books.add(new Book(bookId, title));
	}

	public void displayAllBooks() {
		books.stream().forEach(b -> System.out.println(b.toString()));
	}
	
	// display only book that can borrow(lendFlag = 0)
	public void displayAvailableBooks() {
		books.stream().forEach(b -> {
			if(b.getLendFlag() == 0) {
				System.out.println(b.toString());
			}
		});
	}

	public Book getBookById(int id) {
		try {
			return books.get(id - 1);
		}catch(IndexOutOfBoundsException e) {
			throw new BookNotFoundException("Book does not found!");
		}
	}

	public boolean searchBookById(int id) {
		return books.contains(getBookById(id));
	}

	public boolean isAlreadyLend(int id) {
		return getBookById(id).getLendFlag() == 1;
	}

	public void lendBook(int id) {
		getBookById(id).setLendFlag(1);
	}

	public void returnBook(int id) {
		getBookById(id).setLendFlag(0);
	}

	
}
