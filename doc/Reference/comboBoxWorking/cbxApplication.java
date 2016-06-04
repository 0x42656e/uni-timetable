/**
 * Created by epicpc on 6/4/16.
 */
import jvfx.*;
import javafx.application.*;
import javafx.stage.*;
import model.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class cbxApplication extends Application {

    public static void main(String[] args) { //launch(args);
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Cbx cbx = new Cbx("ben", 1, 2);
        //ViewLoader.showStage(university, "/view/university.fxml", "University", stage);
        ViewLoader.showStage(cbx, "/view/cbx.fxml", "CBX", stage);
    }
}

