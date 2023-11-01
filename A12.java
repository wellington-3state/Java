import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class A12{

	JTextField nameField;
	JTextArea contents;
	JButton read;
	JButton readStudents;
	JButton sort;
	JButton quit;
	Student[] students;

	public A12(){

		JPanel panel = new TopPanel();
		nameField = new MyTextField(12);
		NameListener nameListener = new NameListener();
		nameField.addActionListener(nameListener);

		read = new MyButton("Read File");
		read.addActionListener(nameListener);

		readStudents = new MyButton("Read Students");
		readStudents.addActionListener(new ReadStudents());

		sort = new MyButton("Sort Data");
		sort.addActionListener(new SortListener());
		
		quit = new MyButton("Quit");
		quit.addActionListener(new QuitListener());

		panel.add(nameField);
		panel.add(read);
		panel.add(readStudents);
		panel.add(sort);
		panel.add(quit);

		contents = new ContentsArea();


		// How to create a JFrame
		JFrame frame = new JFrame("Lab 12 GUI Inheritance");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add components in the frame
		frame.add(BorderLayout.NORTH, panel);
		frame.add(contents);
		frame.add(new JScrollPane(contents));
		frame.setVisible(true);

	}	// Ends constructor

	public static void main(String[] args){
		A12 lab = new A12();
	} // main ends

	// Inner Class Class
	class NameListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String fileName = nameField.getText();
			contents.setText(MyUtils.readFile(fileName));
		}
	} // NameListener ends

	class QuitListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			System.out.println("Processing Completed!");
			System.exit(0);
		}
	}

	class ReadStudents implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String fileName = nameField.getText();
			students = MyUtils.getStudents(fileName);
			contents.setText(MyUtils.toString(students));
		}
	}

	class SortListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Arrays.sort(students);
			contents.setText(MyUtils.toString(students));
		}
	}

}  // Lab12Inheritance ends

class MyTextField extends JTextField{

	public MyTextField(int length){
		super(length);
		setBackground(Color.orange);
		setForeground(Color.blue);
	}
}

class TopPanel extends JPanel{
	public TopPanel(){
		setBackground(Color.red);
		setForeground(Color.white);
	}
}

class ContentsArea extends JTextArea{
	public ContentsArea(){
		setBackground(Color.white);
		setForeground(Color.black);
		setEditable(false);
	}
}

class MyButton extends JButton{

	public MyButton(String str){
		super(str);
		setBackground(Color.pink);
		setForeground(Color.white);
	}
}