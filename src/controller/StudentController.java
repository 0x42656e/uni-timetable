package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.Student;

public class StudentController extends Controller<Student> {
    public final Student getStudent() {return model;}

    @FXML Button logoutBtn;

    public void handleWithdraw() {

    }

    public void handleEnrol() {

    }

    public void handleLogout() {
        stage.close();
    }
}

