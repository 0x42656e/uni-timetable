package model;

public class Time {
    private final double time = System.nanoTime();
    
    public final String getTime() {return String.valueOf(time);}
}
