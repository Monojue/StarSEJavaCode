package t02_Student;

public class Student {

	private String Name;
	private String ClassName;
	private int Age;
	private String Gender;

	public Student(String name, String className, int age, String gender) {
		super();
		Name = name;
		ClassName = className;
		Age = age;
		Gender = gender;
	}

	@Override
	public String toString() {
		return String.format("Name : %s\t Class : %s\t Age : %d\t Gender : %s", Name, ClassName, Age, Gender);
	}

}
