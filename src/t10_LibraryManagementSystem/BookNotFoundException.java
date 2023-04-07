package t10_LibraryManagementSystem;

public class BookNotFoundException extends IndexOutOfBoundsException{
	public BookNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
