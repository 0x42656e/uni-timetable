package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.javafx.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class SobekController extends Controller {
    
    @FXML
    public void handleAdder() {
        System.out.println("add");
        model.Adder adder = new model.Adder();
        try {
            ViewLoader.showStage(adder, "/view/adder.fxml", "Sobek", new Stage());
        } catch (IOException ex) {
            System.out.println("nah");
        }
    }
    
    @FXML
    public void handleTime() {
        System.out.println("time");
         model.Time time = new model.Time();
                try {
            ViewLoader.showStage(time, "/view/time.fxml", "Sobek", new Stage());
        } catch (IOException ex) {
            System.out.println("nah");
        }
    }
}
