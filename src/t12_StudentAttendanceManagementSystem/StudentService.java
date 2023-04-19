package t12_StudentAttendanceManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
	File file = new File(AttendanceManagementSystem.class.getResource("attendance.txt").getFile());

	public List<Student> getAllStudentList() {
		List<Student> studentList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				var array = line.split("\t");
				studentList.add(new Student(Integer.parseInt(array[0]), array[1], array[2].charAt(1)));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return studentList;
	}

	public boolean searchStudentById(int id) {
		var list = getAllStudentList();
		return list.stream().anyMatch(s -> s.getSutdentId() == id);
	}

	public void setStudentStatus(int id, char stauts) {
		var list = getAllStudentList();
		list.forEach(b -> {
			if (b.getSutdentId() == id) {
				b.setAttendanceStatus(stauts);
			}
		});
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Student student : list) {
				writer.write(student.saveFileString());
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
