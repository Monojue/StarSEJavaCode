package t13_CSVReadWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReadWrite {

	public static void main(String[] args) {
	 	Scanner scanner;
		List<Student> studentList = new ArrayList<>();
		try {
			scanner = new Scanner(new File("input.csv"));
			scanner.useDelimiter("\r\n");
			while (scanner.hasNext()) {
				var line = scanner.next();

				if (!line.equals("No.,StudentName,Age,Grade")) {
					var arr = line.split(",");
					Student stu = new Student();
					stu.setNo(Integer.parseInt(arr[0]));
					stu.setName(arr[1]);
					stu.setAge(Integer.parseInt(arr[2]));
					stu.setGrade(arr[3]);
					studentList.add(stu);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileWriter writer;
		try {
			writer = new FileWriter("output.csv");
			writer.append("No.");
			writer.append(",");
			writer.append("Name");
			writer.append(",");
			writer.append("Age");
			writer.append(",");
			writer.append("Grade");
			writer.append("\n");
			for (Student student : studentList) {
				writer.append(String.valueOf(student.getNo()));
				writer.append(",");
				writer.append(student.getName());
				writer.append(",");
				writer.append(String.valueOf(student.getAge()));
				writer.append(",");
				writer.append(student.getGrade());
				writer.append("\n");
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
