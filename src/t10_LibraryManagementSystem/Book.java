package t10_LibraryManagementSystem;

public class Book {

	private Integer bookId;
	private String title;
	private Integer lendFlag;

	public Book(Integer bookId, String title) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.lendFlag = 0;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLendFlag() {
		return lendFlag;
	}

	public void setLendFlag(Integer lendFlag) {
		this.lendFlag = lendFlag;
	}

	@Override
	public String toString() {
		return String.format("%d %s (%s)", getBookId(), getTitle(), (getLendFlag() == 1) ? "borrowed" : "can borrow");
	}

}
