package controller;

import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import model.Student;
import model.University;

import javafx.fxml.*;
import javafx.scene.control.ListView;

public class UniversityController extends Controller<University> {

    @FXML private ListView<Student> studentsLv;
    
    public void handleAddStudent() throws Exception  {
        System.out.println("addStudent");
        ViewLoader.showStage(getStudent(), "/view/add_student.fxml", "Add Student", new Stage());
    }

    public void handleRemoveStudent() {
        model.remove(getStudent());
        System.out.println("removeStudent");
    }

    public void handleLogin() {
        System.out.println("login");
    }
    
    public final University getUniversity() {return model;}
    
    private Student getStudent() {return studentsLv.getSelectionModel().getSelectedItem();}
}
