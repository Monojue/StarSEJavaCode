package t10_LibraryManagementSystem;

public class MemberNotFoundException extends IndexOutOfBoundsException{
	public MemberNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
