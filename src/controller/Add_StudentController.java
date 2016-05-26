package controller;

import au.edu.uts.ap.javafx.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import model.*;
import javafx.beans.binding.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;

public class Add_StudentController extends Controller<Student> {

    @FXML TextField numberTf;
    @FXML TextField nameTf;
    @FXML Button addBtn;
    @FXML ToggleGroup attendanceTg;
    @FXML CheckBox scholarshipCb;
    boolean ben = true;

    @FXML
    private void initialize() {
         BooleanBinding booleanBind = Bindings.or(numberTf.textProperty().isEmpty(),
         nameTf.textProperty().isEmpty());

        addBtn.disableProperty().bind(attendanceTg.selectedToggleProperty().isNull() .or(booleanBind));

    }

    @FXML
    public void handleCancel() throws Exception {

        stage.close();
    }
}
