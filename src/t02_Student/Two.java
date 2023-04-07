package t02_Student;

public class Two {

	public static void main(String[] args) {

		Student mgmg = new Student("Mg Mg", "Java Class", 26, "Male");
		Student hlahla = new Student("Hla Hla", "C# Class", 25, "Female");
		Student thidar = new Student("Thidar", "Laravel Class", 24, "Female");

		System.out.println(mgmg.toString());
		System.out.println(hlahla.toString());
		System.out.println(thidar.toString());

	}

}
