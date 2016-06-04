package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.Activity;
import model.Student;
import model.Subject;
import model.University;

public class StudentController extends Controller<Student> {
    public final Student getStudent() {return model;}

    @FXML Button logoutBtn;

    @FXML ComboBox subjectCb;

    @FXML TableView<Activity> subjectsTv;

    @FXML TableColumn<Activity, String> subSubjectClm;
    @FXML TableColumn<Activity, String> subGroupClm;
    @FXML TableColumn<Activity, String> subActivityClm;
    @FXML TableColumn<Activity, String> subDayClm;
    @FXML TableColumn<Activity, String> subStartClm;
    @FXML TableColumn<Activity, String> subDurationClm;
    @FXML TableColumn<Activity, String> subRoomClm;
    @FXML TableColumn<Activity, String> subCapacityClm;
    @FXML TableColumn<Activity, String> subEnrolledClm;

    @FXML
    public void initialize() {
        subSubjectClm.setCellValueFactory(cellData -> cellData.getValue().subjectProperty().asString());
        subGroupClm.setCellValueFactory(cellData -> cellData.getValue().groupProperty());

        subjectCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                subjectsTv.setItems(getSubjectList(newValue).getActivities());
            }
        });
    }

    private Subject getSubjectList(Object value) {
        for (Subject x : getStudent().getUniversity().getSubjects()) {
            if (x == value) return x;
        }
        return null;
    }

    public void handleWithdraw() {

    }

    public void handleEnrol() {

    }

    public void handleLogout() {
        stage.close();
    }
}

