package t10_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Books {
	
	List<Book> books = new ArrayList<>();
	
	public void addNewBook(int bookId, String title) {
		books.add(new Book(bookId, title));
	}
	
	public void displayAllBooks() {
		books.stream().forEach(b ->{
			System.out.println(String.format("%d\\t%s\\t%s", 
					b.getBookId(), b.getTitle(), (b.getLendFlag()==0)?"borrowed" : "can borrow"));
		});
	}
	
	public void lendBook(int id) {
		
	}
	
	public void returnBook(int id) {
		
	}

}
