public class Activity {
  private Subject subject;
  private String group;
  private int number;
  private String day;
  private int start;
  private int duration;
  private String room;
  private int capacity;
  private int enrolled = 0;

  public Activity(Subject subject, String group, int number, String day, int start, int duration, String room, int capacity) {
    this.subject = subject;
    this.group = group;
    this.number = number;
    this.day = day;
    this.start = start;
    this.duration = duration;
    this.room = room;
    this.capacity = capacity;
  }

//  public String hasSession(String session) {
//    String[] ar = session.split(":");
//      return this.group.equals(ar[0]) &&  this.number.equals(ar[1]);
//  }
  public boolean hasSession(String session) {
   String[] ar = session.split(":");
   String num = "" + this.number;
   return group.contains(ar[0]) && num.contains(ar[1]);
  }

  public boolean hasWithdrawSession(String session) {
   String[] ar = session.split(":");
   String n = "" + this.subject.getNumber();
   return n.contains(ar[0]) && group.contains(ar[1]);
  }

  public Activity getSession() {
    return this;
  }

  public void incrementEnrolled() {
        enrolled += 1;
  }

  public int fetchSubject() {
    return subject.getNumber();
  }

  public String fetchGroup() {
    return this.group;
  }

  public boolean isFull() {
    return capacity == enrolled;
  }

  public int fetchNumber() {
    return this.number;
  }

  public void withdraw() {
    this.enrolled--;
  }

  public boolean hasGroup(String session) {
	return this.group.contains(session);	
  }

  @Override
	public String toString() {
		return "" + subject.getNumber() + " " + group + " " + number + " " + day + " " + room + " " + getTimeFormat() + " " + duration + "hrs " + enrolled + "/" + capacity;
	}

  private String getTimeFormat() {
    int n = this.start;
    return String.format("%02d", n) + ":00";
  }
}
