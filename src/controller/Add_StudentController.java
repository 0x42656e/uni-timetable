package controller;

import au.edu.uts.ap.javafx.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import model.*;
import javafx.beans.binding.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;

public class Add_StudentController extends Controller<University> {
    public final University getUniversity() {return model;}

    @FXML TextField numberTf;
    @FXML TextField nameTf;
    @FXML Button addBtn;
    @FXML ToggleGroup attendanceTg;
    @FXML CheckBox scholarshipCb;
    @FXML Label errorLb;

    @FXML
    private void initialize() {
         BooleanBinding booleanBind = Bindings.or(numberTf.textProperty().isEmpty(),
         nameTf.textProperty().isEmpty());

        addBtn.disableProperty().bind(attendanceTg.selectedToggleProperty().isNull() .or(booleanBind));
    }

    @FXML
    public void handleAdd() throws Exception {
        if (model.isStudent(numberTf.getText())) {
            errorLb.setVisible(true);
            return;
        }
        getUniversity().addStudent(numberTf.getText(), nameTf.getText(), attendanceTg.getSelectedToggle().getUserData().toString(), scholarshipCb.isSelected());
        stage.close();
    }

    @FXML
    public void handleCancel() throws Exception {
        stage.close();
    }
}
