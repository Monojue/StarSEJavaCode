package t10_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Members {

	private List<Member> members = new ArrayList<>();

	public void addNewMember(int memberId, String name) {
		members.add(new Member(memberId, name));
	}

	public void displayAllMembers() {
		members.stream().forEach(m -> System.out.println(m.toString()));
	}

	public boolean checkMemeberById(int id) {
		return members.stream().anyMatch(m -> m.getMemberID() == id);
	}

	public Member getMemberById(int id) {
		try {
			return members.get(id - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new MemberNotFoundException("Member does not found!");
		}
	}

	public boolean searchMemberById(int id) {
		return members.contains(getMemberById(id));
	}

	public boolean isMemberlendTheBook(int memberId, Book book) {
		return getMemberById(memberId).getBorrowedBookList().contains(book);
	}

}
