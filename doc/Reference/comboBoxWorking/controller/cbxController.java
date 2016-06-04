package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import jvfx.*;
import model.*;

/**
 * Created by epicpc on 6/4/16.
 */
public class cbxController extends Controller<Cbx> {
    @FXML ComboBox opusCb;
    @FXML Text opusTx;
    @FXML Button opusBtn;
    @FXML TableView<Cbx> cbxTv;
    @FXML TableColumn<Cbx, String> nameClm;
    @FXML TableColumn<Cbx, String> xClm;
    @FXML TableColumn<Cbx, String> yClm;
    private ObservableList<Cbx> subjects = FXCollections.observableArrayList();
    private ObservableList<Cbx> santies = FXCollections.observableArrayList();
    private ObservableList<ObservableList> allOf = FXCollections.observableArrayList();



    @FXML
    public void initialize() {

        subjects.add(new Cbx("no", 24, 4));
        subjects.add(new Cbx("yes", 2, 432));
        subjects.add(new Cbx("santa", -1, 1));

        santies.add(new Cbx("ho", 3334, 334));
        santies.add(new Cbx("hoho", 222, 432222));
        santies.add(new Cbx("hohoho", -10, 10));

        allOf.addAll(
                subjects,
                santies
        );

        opusCb.getItems().addAll(
                allOf
        );

        //cbxTv.setItems(subjects);

        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        xClm.setCellValueFactory(cellData -> cellData.getValue().xProperty().asString());
        yClm.setCellValueFactory(cellData -> cellData.getValue().yProperty().asString());

        opusCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println("This: " + newValue);
                cbxTv.setItems(getList(newValue));
            }
        });
    }

    private ObservableList<Cbx> getList(Object value) {
        for (ObservableList<Cbx> hld : allOf) {
            if (hld == value) return hld;
        }
        return null;
        //if (value == subjects) return subjects;
        //if (value == santies) return santies;
        //return null;
    }
}
