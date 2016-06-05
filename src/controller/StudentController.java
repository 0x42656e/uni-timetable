package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
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

    @FXML Button withdrawBtn;
    @FXML Button enrolBtn;
    @FXML Button logoutBtn;

    @FXML ComboBox subjectCb;

    @FXML TableView<Activity> studentsTv;
    @FXML TableView<Activity> subjectsTv;

    @FXML TableColumn<Activity, String> stdSubjectClm;
    @FXML TableColumn<Activity, String> stdGroupClm;
    @FXML TableColumn<Activity, String> stdActivityClm;
    @FXML TableColumn<Activity, String> stdDayClm;
    @FXML TableColumn<Activity, String> stdStartClm;
    @FXML TableColumn<Activity, String> stdDurationClm;
    @FXML TableColumn<Activity, String> stdRoomClm;
    @FXML TableColumn<Activity, String> stdCapacityClm;
    @FXML TableColumn<Activity, String> stdEnrolledClm;

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
        stdSubjectClm.setCellValueFactory(cellData -> cellData.getValue().subjectProperty().asString());
        stdGroupClm.setCellValueFactory(cellData -> cellData.getValue().groupProperty());
        stdActivityClm.setCellValueFactory(cellData -> cellData.getValue().numberProperty().asString());
        stdDayClm.setCellValueFactory(cellData -> cellData.getValue().dayProperty());
        stdStartClm.setCellValueFactory(cellData -> cellData.getValue().startProperty().asString());
        stdDurationClm.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asString());
        stdRoomClm.setCellValueFactory(cellData -> cellData.getValue().roomProperty());
        stdCapacityClm.setCellValueFactory(cellData -> cellData.getValue().capacityProperty().asString());
        stdEnrolledClm.setCellValueFactory(cellData -> cellData.getValue().enrolledProperty().asString());

        subSubjectClm.setCellValueFactory(cellData -> cellData.getValue().subjectProperty().asString());
        subGroupClm.setCellValueFactory(cellData -> cellData.getValue().groupProperty());
        subActivityClm.setCellValueFactory(cellData -> cellData.getValue().numberProperty().asString());
        subDayClm.setCellValueFactory(cellData -> cellData.getValue().dayProperty());
        subStartClm.setCellValueFactory(cellData -> cellData.getValue().startProperty().asString());
        subDurationClm.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asString());
        subRoomClm.setCellValueFactory(cellData -> cellData.getValue().roomProperty());
        subCapacityClm.setCellValueFactory(cellData -> cellData.getValue().capacityProperty().asString());
        subEnrolledClm.setCellValueFactory(cellData -> cellData.getValue().enrolledProperty().asString());

        subjectCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                subjectsTv.setItems(getSubjectList(newValue).getActivities());
            }
        });
        studentsTv.setItems(model.getActivities());



        studentsTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> withdrawBtn.setDisable(newSubject == null)
        );
        subjectsTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> enrolBtn.setDisable(newSubject == null)
        );
    }

    private Subject getSubjectList(Object value) {
        for (Subject x : getStudent().getUniversity().getSubjects()) {
            if (x == value) return x;
        }
        return null;
    }

    private Activity getSelectedWithdraw() {
        return studentsTv.getSelectionModel().getSelectedItem();
    }
    private Activity getSelectedActivity() {
        return subjectsTv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void handleWithdraw() {
        model.withdraw(getSelectedWithdraw());
    }

    @FXML
    public void handleEnrol() {
        model.enrol(getSelectedActivity());
        subjectsTv.getSelectionModel().clearSelection();
    }

    @FXML
    public void handleLogout() {
        stage.close();
    }
}

