import java.util.*;

public class University {
	private LinkedList<Subject> subjects = new LinkedList<Subject>();
	private LinkedList<Student> students = new LinkedList<Student>();

	public static void main(String[] args) {
		new University().use();
	}

	public University() {
		//students.add(new Student("97116368", "Ben Fran"));
		subjects.add(new Subject(48024, "Applications Programming"));

		subjects.get(0).addActivity("Lec1", 1, "Wed", 18, 1, "CB11.00.405", 200);
		subjects.get(0).addActivity("Cmp1", 1, "Wed", 19, 2, "CB11.B1.403", 2);
    subjects.get(0).addActivity("Cmp1", 2, "Wed", 19, 2, "CB11.B1.401", 2);
    subjects.get(0).addActivity("Cmp1", 3, "Wed", 19, 2, "CB11.B1.402", 2);

		subjects.add(new Subject(31284, "Web Services Development"));
		subjects.get(1).addActivity("Lec1", 1, "Tue", 16, 1, "CB02.03.002", 160);
    subjects.get(1).addActivity("Cmp1", 1, "Tue", 9, 2, "CB11.B1.102", 30);
    subjects.get(1).addActivity("Cmp1", 2, "Tue", 9, 2, "CB11.B1.103", 30);
    subjects.get(1).addActivity("Cmp1", 3, "Tue", 14, 2, "CB11.B1.102", 30);
    subjects.get(1).addActivity("Cmp1", 4, "Tue", 14, 2, "CB11.B1.103", 30);
	}

	public void use() {
		char choice;
		while ((choice = readChoice()) != 'x') {
			switch (choice) {
				case 'a': addStudent(); break;
				case 'r': removeStudent(); break;
				case 'v': viewStudents(); break;
				case 'l': login(); break;
				default: help(); break;
			}
		}
	}

	private void addStudent() {
		String number = readNumber();
		for (Student student : students) {
			if (student.hasId(number)) {
				System.out.println("Student number already exists");
				return;
			}
		}
		students.add(new Student(number, readName()));
	}

	private void removeStudent() {
		String number = readNumber();
		for (Student student : students) {
			if (student.hasId(number)) {
				student.withdrawFromUni();
				students.remove(student);
				return;
			}
		}
		System.out.println("No such student");
	}


	private void viewStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void login() {
		String number = readNumber();
		for (Student student : students) {
			if (student.hasId(number)) {
					student.use(subjects);
					return;
			}
		}
			 System.out.println("No such student");
		}


	private void help() {
		System.out.println("University menu options\na = add a student\nr = remove a student\nv = view all students\nl = login\nx = exit");
	}


	//#### READS ####
		private char readChoice() {
			System.out.print("Choice (a/r/v/l/x): ");
			return In.nextChar();
		}
		private String readNumber() {
			System.out.print("Number: ");
			return In.nextLine();
		}
		private String readName() {
			System.out.print("Name: ");
			return In.nextLine();
		}
}
