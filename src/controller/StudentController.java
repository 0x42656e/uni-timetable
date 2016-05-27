package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.Student;

public class StudentController extends Controller<Student> {
    @FXML Button logoutBtn;

    public void handleLogout() {
        stage.close();
    }
}

