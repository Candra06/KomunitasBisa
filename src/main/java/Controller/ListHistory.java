package Controller;

import Helper.Helper;
import Model.Donasi;
import Model.Volunteer;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListHistory implements Initializable {

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableView<Donasi> table1;

    @FXML
    private TableColumn<Donasi, String> colEventDns;

    @FXML
    private TableColumn<Donasi, String> colNominal;

    @FXML
    private TableColumn<Donasi, String> colStatusDns;

    @FXML
    private TableView<Volunteer> table2;

    @FXML
    private TableColumn<Volunteer, String> colEventVln;

    @FXML
    private TableColumn<Volunteer, String> colStatusVln;

    ObservableList<Donasi> listDonasi = FXCollections.observableArrayList();
    ObservableList<Volunteer> listVolunteer = FXCollections.observableArrayList();

    @FXML
    void btnCloseOnClick(ActionEvent event) {
        Helper.closeWindow(event, this.btnClose);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_user");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEventDns.setCellValueFactory(new PropertyValueFactory<>("event"));
        colStatusDns.setCellValueFactory(new PropertyValueFactory<>("status"));
        colNominal.setCellValueFactory(new PropertyValueFactory<>("jumlah_donasi"));

        colEventVln.setCellValueFactory(new PropertyValueFactory<>("event"));
        colStatusVln.setCellValueFactory(new PropertyValueFactory<>("status"));

        ArrayList<Volunteer> dataVln = Volunteer.getVolunteerByUser();
        for (Volunteer volunteer : dataVln){
            listVolunteer.add(new Volunteer(volunteer.getEvent(), volunteer.getStatus()));
        }
        table2.setItems(listVolunteer);

        ArrayList<Donasi> dataDns = Donasi.getDonasiByUser();
        for (Donasi donasi : dataDns){
            listDonasi.add(new Donasi(donasi.getJumlah_donasi(), donasi.getStatus(), donasi.getEvent()));
        }
        table1.setItems(listDonasi);
    }
}
