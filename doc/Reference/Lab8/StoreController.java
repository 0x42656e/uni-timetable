import com.sun.istack.internal.Nullable;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.text.*;


public class StoreController {
    private Store store = new Store();
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;

    @FXML public void handleSell() {
        store.getProduct().sell(Integer.valueOf(amountTf.getText()));
        amountTf.setText("0");
    }

    public Store getStore() { return store; }
}