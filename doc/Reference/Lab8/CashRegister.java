import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;

import java.text.DecimalFormat;

public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0.0);
    }

    public String getCash() {
        return "$" + formatDouble(cash.get());
    }
    public Property cashProperty() { return cash; }

    public void add(double money) {
        cash.set(cash.get() + money);
    }

    public String formatDouble(double n) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(n);
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}