package t10_LibraryManagementSystem;

public class MemberNotFoundException extends IndexOutOfBoundsException {

	private static final long serialVersionUID = 1L;

	public MemberNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
