package Controller;

import Helper.Helper;
import Model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EventPage implements Initializable {
    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnAddEvent;

    @FXML
    private JFXComboBox<?> cbbFilter;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private TableView<Event> table;

    @FXML
    private TableColumn<Event, String> colJudul;

    @FXML
    private TableColumn<Event, String> colTanggal;

    @FXML
    private TableColumn<Event, String> colStatus;

    ObservableList<Event> observableList = FXCollections.observableArrayList();

    public void cellOnClick(MouseEvent mouseEvent) {
//        System.out.println("Yang di click "+ listEvent.getSelectionModel().getSelectedItems().toString());
        Helper.changePage(mouseEvent, "detail_event");
    }

    public void btnLoginOnClick(ActionEvent actionEvent) {
    }

    public void btnAddEventOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "add_event");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colJudul.setCellValueFactory(new PropertyValueFactory<>("judul_event"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ArrayList<Event> data = Event.getEventByKomunitas();
        for (Event event :data){
            observableList.add(new Event(event.getId_event(), event.getJudul_event(), event.getTanggal(),event.getStatus()));
        }
        table.setItems(observableList);
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_komunitas");
    }
}
