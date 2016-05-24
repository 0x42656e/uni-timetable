import model.*;
import util.javafx.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class SobekApplication extends Application {
    public static void main(String[] args) {launch(args);}
    
    @Override
    public void start(Stage stage) throws Exception {
        Sobek sobek = new Sobek();
        ViewLoader.showStage(sobek, "/view/sobek.fxml", "Sobek", stage);
    }
}
