import java.util.*;

public class Student {

	private String number;
	private String name;
	private LinkedList<Activity> activities = new LinkedList<Activity>();

	public Student(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public void use(LinkedList<Subject> subjects) {
		char choice;
		while ((choice = readChoice()) != 'x') {
			switch (choice) {
				case 'v': viewActivities(); break;
				case 'e': enrol(subjects); break;
				case 'w': withdraw(); break;
				default: help(); break;
			}
		}
	}
	private void viewActivities() {
		for (Activity activity : activities) {
      System.out.println(activity);
    }
	}

	private void enrol(LinkedList<Subject> subjects) {
			System.out.println("Select a subject");
			for (Subject subject : subjects) {
				System.out.println(subject);
			}
			int subjectNumber = readNumber();
			boolean isThere = false;
			for (Subject sub : subjects) {
				if (sub.getSubject(subjectNumber)) {
					isThere = true;
				}
			}
			if (!(isThere)) {
				System.out.println("No such subject");
				return;
			}
			System.out.println("Select an activity");
			for (Subject subject : subjects) {
				if (subject.hasNumber(subjectNumber)) {
						subject.printActivities();
						String readAct = readActivity();
						Activity act = subject.fetch(readAct);
						

						if (act == null && subject.checkIfActReal(readAct)) {
							System.out.println("No available seats");
							return;
						} else { 
						if (act == null) {
							System.out.println("No such activity");
							return;
						}
						}
						LinkedList<Activity> same = new LinkedList<Activity>();
						for (Activity activity : activities) {
						if (act.fetchGroup() == activity.fetchGroup() && act.fetchSubject() == activity.fetchSubject()){
										same.add(activity);
							}
						}
						activities.removeAll(same);
						if (act.isFull()) {
							System.out.println("No available seats");
							return;
						}
						act.incrementEnrolled();
						activities.add(act);
				}
			}
		}

	private void withdraw() {
		String session = readWithdrawActivity();
		for (Activity activity : activities) {
			if (activity.hasWithdrawSession(session)) {
				activity.withdraw();
				activities.remove(activity);
				return;
			}
		}
		System.out.println("Not enrolled in activity");
	}

	private void help() {
		System.out.println("Student menu options\nv = view my activities\ne = enrol in an activity\nw = withdraw from an activity\nx = exit");
	}

	public boolean hasId(String number) {
		//System.out.println("<" + this.number + "> : <" + number + ">");
		return this.number.equals(number);
	}


	public void withdrawFromUni() {
		for (Activity activity : activities) {
						activity.withdraw();
			}
		activities.removeAll(activities);
	}

	@Override
	public String toString() {
		return number + " " + name;
	}

	//#### READS ####
		private char readChoice() {
			System.out.print("Choice (v/e/w/x): ");
			return In.nextChar();
		}

		private int readNumber() {
			System.out.print("Subject number: ");
			return In.nextInt();
		}

		private String readActivity() {
			System.out.print("Activity code (group:activity): ");
			return In.nextLine();
		}

		private String readWithdrawActivity() {
			System.out.print("Activity code (subject:group): ");
			return In.nextLine();
		}
}
