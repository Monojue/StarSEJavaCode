package t10_LibraryManagementSystem;

public class BookNotFoundException extends IndexOutOfBoundsException{

	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
