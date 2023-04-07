package t10_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Members {

	List<Member> members = new ArrayList<>();
	
	public void addNewMember(int memberId, String name) {
		members.add(new Member(memberId, name));
	}
	
	public boolean checkMemeberById(int id) {
		return members.stream().anyMatch(m -> m.getMemberID()==id);
	}
}
