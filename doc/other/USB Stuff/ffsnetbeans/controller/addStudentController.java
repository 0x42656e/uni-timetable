package controller;

import au.edu.uts.ap.javafx.*;
import model.*;

public class addStudentController extends Controller<University> {
    public void handleAdd() throws Exception {
        System.out.println("add");
        model.addStudent("1123123", "Ben McSickly", "full", true);
        stage.close();
    }

    public void handleCancel(){
        System.out.println("cancel");
        stage.close();
    }
}
