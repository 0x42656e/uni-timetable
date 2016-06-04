package model;

import javafx.beans.property.*;
import org.omg.PortableInterceptor.INACTIVE;

public class Activity {
    private Subject subject;
    private StringProperty group = new SimpleStringProperty();
    private IntegerProperty number = new SimpleIntegerProperty();
    private StringProperty day = new SimpleStringProperty();
    private IntegerProperty start = new SimpleIntegerProperty();
    private IntegerProperty duration = new SimpleIntegerProperty();
    private StringProperty room = new SimpleStringProperty();
    private IntegerProperty capacity = new SimpleIntegerProperty();
    private IntegerProperty enrolled = new SimpleIntegerProperty();

    public Activity(Subject subject, String group, int number, String day, int start, int duration, String room, int capacity) {
        this.subject = subject;
        this.group.set(group);
        this.number.set(number);
        this.day.set(day);
        this.start.set(start);
        this.duration.set(duration);
        this.room.set(room);
        this.capacity.set(capacity);
        enrolled.set(0);
    }

    public Subject getSubject() { return subject; }
    public int getSubjectNumber() { return subject.getNumber(); }
    public String getGroup() { return group.get(); }
    public int getNumber() { return number.get(); }
    public String getDay() { return day.get(); }
    public int getStart() { return start.get(); }
    public int getDuration() { return duration.get(); }
    public String getRoom() { return room.get(); }
    public int getCapacity() { return capacity.get(); }
    public int getEnrolled() { return enrolled.get(); }

    public IntegerProperty subjectProperty() {
         return new SimpleIntegerProperty(subject.getNumber());
    }
    public StringProperty groupProperty() {return group;}
    public IntegerProperty numberProperty() {return number;}
    public StringProperty dayProperty() {return day;}
    public IntegerProperty startProperty() {return start;}
    public IntegerProperty durationProperty() {return duration;}
    public StringProperty roomProperty() {return room;}
    public IntegerProperty capacityProperty() {return capacity;}
    public IntegerProperty enrolledProperty() {return enrolled;}


    public boolean canEnrol() {
        return enrolled.get() < capacity.get();
    }

    public void enrol() {
        enrolled.set(enrolled.get() + 1);
    }

    public void withdraw() {
        enrolled.set(enrolled.get() - 1);
    }

    public boolean matches(int subjectNumber, String group) {
        return subject.matches(subjectNumber) && group.equals(this.group.get());
    }

    @Override
    public String toString() {
        return String.format("%d %s %d %s %s %02d:00 %dhrs %d/%d", subject.getNumber(), group.get(), number.get(), day.get(), room.get(), start.get(), duration.get(), enrolled.get(), capacity.get());
    }
}
