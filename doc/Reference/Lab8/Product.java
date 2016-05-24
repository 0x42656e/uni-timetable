
import javafx.beans.property.*;

import java.util.LinkedList;

public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private final String name;
    private IntegerProperty stock = new SimpleIntegerProperty();
    private final double price;

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock.set(stock);
        this.price = price;
    }

    public final String getName() {
        return name;
    }

    public final String getPrice() {
        return "$" + price;
    }

    public String getStock() {
        return stock.get() + " items";
    }

    public ReadOnlyIntegerProperty stockProperty() {return stock;}

    public void sell(int n) {
        if ( n <= stock.get()) {
            this.stock.set(this.stock.get() - n);
            double money = n * price;
            for (ProductObserver observer : observers)
                observer.handleSale(money);
        }
    }

    public boolean has(int n) {
        return stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}