package model;

import javafx.beans.property.*;

public class Cbx {

    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();

    public Cbx(String name, int x, int y) {
        this.name.set(name);
        this.x.set(x);
        this.y.set(y);
    }

    public void add(String name, int x, int y) {
        this.name.set(name);
        this.x.set(x);
        this.y.set(y);
    }

    public String getName() {return name.get();}
    public String getX() {return "" + x.get();}
    public String getY() {return "" + y.get();}
    public StringProperty nameProperty() {return name;}
    public IntegerProperty xProperty() {return x;}
    public IntegerProperty yProperty() {return y;}

    @Override
    public String  toString() {return   name.get() + " - " + x.get() + "/" + y.get();}
}
