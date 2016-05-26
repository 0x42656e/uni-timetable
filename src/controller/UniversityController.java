package controller;

import au.edu.uts.ap.javafx.*;
import javafx.fxml.*;
import javafx.stage.*;
import model.*;

/**
 * Created by epicpc on 5/26/16.
 */
public class UniversityController extends Controller<University> {

    @FXML
    public void handleAddStudent() throws Exception {

        ViewLoader.showStage(model, "/view/add_student.fxml", "Add Student", new Stage());
    }
}
