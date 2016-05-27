package controller;

import au.edu.uts.ap.javafx.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import model.*;

/**
 * Created by epicpc on 5/26/16.
 */
public class UniversityController extends Controller<University> {

    public final University getUniversity() {return model;}

    @FXML ListView<Student> studentsLv;
    @FXML Button removeBtn;
    @FXML Button loginBtn;


    @FXML
    private void initialize() {
        studentsLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    removeBtn.setDisable(newValue == null);
                    loginBtn.setDisable(newValue == null);
                }
        );
    }

    private Student getSelectedStudent() {
        return studentsLv.getSelectionModel().getSelectedItem();
    }

    //HANDLES
    @FXML
    public void handleAdd() throws Exception {
        ViewLoader.showStage(model, "/view/add_student.fxml", "Add Student", new Stage());
    }

    @FXML
    public void handleRemove() throws Exception {
        model.remove(getSelectedStudent());
    }

    @FXML
    public void handleLogin() throws Exception {
        ViewLoader.showStage(getSelectedStudent(), "/view/student.fxml", "Student", new Stage());
    }
}
