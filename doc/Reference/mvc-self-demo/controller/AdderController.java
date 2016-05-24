package controller;

import util.javafx.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class AdderController extends Controller {
    @FXML TextField input1Tf;
    @FXML TextField input2Tf;
    @FXML Text resultTxt;
    
    public void handleAdd() {
        System.out.println("add Time");
        String toResult = String.valueOf(Integer.valueOf(input1Tf.getText()) + Integer.valueOf(input2Tf.getText()));
        resultTxt.setText(toResult);
    }
}
