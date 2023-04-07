package t10_LibraryManagementSystem;

public class Data {
	
	Members membersData = new Members();
	Books booksData = new Books();

	public void seed() {

		membersData.addNewMember(1, "John");
		membersData.addNewMember(2, "Mike");

		booksData.addNewBook(1, "The Lord of the Rings");
		booksData.addNewBook(2, "The Hobbit");
		booksData.addNewBook(3, "Harry Potter and the Philosopher's Stone");
		booksData.addNewBook(4, "Harry Potter and the Chamber of Secrets");
	}

	public Members getMembersData() {
		return membersData;
	}

	public Books getBooksData() {
		return booksData;
	}
	
	
}
