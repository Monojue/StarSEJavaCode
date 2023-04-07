package t10_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {

	private Integer memberID;
	private String name;
	private ArrayList<Book> borrowedBooks;

	public Member(Integer memberID, String name) {
		super();
		this.memberID = memberID;
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void lendBook(Book book) {
		borrowedBooks.add(book);
	}
	
	public void returnBook(Book book) {
		borrowedBooks.remove(book);
	}
	
	public List<Book> getBorrowedBookList() {
		return List.copyOf(borrowedBooks);
	}

	public String getListofBookName() {
	
		String str = "";
		borrowedBooks.stream().forEach(b -> {
			
		})
	}
	
	@Override
	public String toString() {
		return String.format("ID : %s, Name : %s\nBorrowedBooks : %s", 
				memberID, name, );
	}
	
	
}
