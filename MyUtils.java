import java.io.*;

public class MyUtils{

	public static String readFile(String fileName){
		In file = new In(fileName);
		return file.readAll();
	}

	public static Student[] getStudents(String fileName){

		Student[] students = null;
		try{
		FileReader fr = new FileReader(fileName);
		BufferedReader file = new BufferedReader(fr);
		int size = Integer.parseInt(file.readLine().trim());
		students = new Student[size];
		for (int i=0; i<students.length; i++){
			String line = file.readLine();
			String[] items = line.split(",");
			students[i] = new Student(
				items[0],
				items[1],
				Double.parseDouble(items[2].trim()),
				items[3]);
			}
		} catch(IOException e){
			System.out.println(e);
			}
		return students;
	}

	public static String toString(Student[] students){
		StringBuilder str = new StringBuilder();
		for(Student s: students){
			str.append(s + "\n");
		}
		return str.toString();
	}
}