
package t12_StudentAttendanceManagementSystem;

public class Student {

	private int sutdentId;
	private String studentName;
	private char attendanceStatus; // 'p' for present, 'a' for absent

	public Student(int sutdentId, String studentName, char attendanceStatus) {
		super();
		this.sutdentId = sutdentId;
		this.studentName = studentName;
		this.attendanceStatus = attendanceStatus;
	}

	public int getSutdentId() {
		return sutdentId;
	}

	public void setSutdentId(int sutdentId) {
		this.sutdentId = sutdentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public char getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(char attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}
	
	public String saveFileString() {
		return String.format("%s\t%s\t'%s'\r\n", sutdentId, studentName, attendanceStatus);
	}

	@Override
	public String toString() {
		return String.format("%s\t%s", studentName, attendanceStatus);
	}
	
	

}
