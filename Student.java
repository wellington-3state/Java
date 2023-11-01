public class Student implements Comparable<Student>{
	//instance variables
	private String firstName;
	private String lastName;
	private double gpa;
	private String major;
	private int id;

	// static (class) variables
	private static int idCount = 1000;

	public Student(String firstName, String lastName, double gpa, String major){
		this.id = ++idCount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.major = major;
	}

	public String toString(){
		return id + " " + firstName + " " + lastName + " " + gpa + " " + major;
	}

	public int compareTo(Student other){
		return this.lastName.compareTo(other.lastName);
	}
}