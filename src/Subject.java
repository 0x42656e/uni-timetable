import java.util.*;

public class Subject {
  private int number;
  private String name;
  private LinkedList<Activity> activities = new LinkedList<Activity>();

  public Subject(int number, String name) {
    this.number = number;
    this.name = name;
  }

  public void addActivity(String group, int number, String day, int start, int duration, String room, int capacity) {
    activities.add(new Activity(this, group, number, day, start, duration, room, capacity));
  }

  public int getNumber() {
    return this.number;
  }
  public boolean hasNumber(int number) {
    return this.number == number;
  }

  public Activity fetch(String session) {
if (session.contains(":")) {   
	for (Activity activity : activities) {
        if (activity.hasSession(session)) {
          return activity.getSession();
        }
    }
    } else {

	//Check the group name
	//find a group with space
	//return group
	
	for (Activity activity : activities) {
        if (activity.hasGroup(session)) {
	if (!(activity.isFull())) {
          return activity.getSession();
	 }
	}
        }
    }
	
 
    return null;
  }

  public boolean getSubject(int number) {
    if (this.number == number) {
      return true;
    }
  return false;
  }

  @Override
  public String toString() {
    return number + " " + name;
  }

  public boolean checkIfActReal(String session) {
	for (Activity activity : activities) {	
	 if ( activity.hasGroup(session)) {
		return true;
	}
	}
	return false;
  }

  public void printActivities() {
    for (Activity activity : activities) {
      System.out.println(activity);
    }
  }
}
