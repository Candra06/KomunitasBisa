package Controller;

import Helper.Helper;
import Model.Donasi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DonasiPage implements Initializable{

    @FXML
    private JFXComboBox<?> cbbFilter;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private JFXButton btnClose;

    @FXML
    private TableView<Donasi> table;

    @FXML
    private TableColumn<Donasi, String>  clEvent;

    @FXML
    private TableColumn<Donasi, String> clNama;

    @FXML
    private TableColumn<Donasi, String> clDonasi;

    @FXML
    private TableColumn<Donasi, String> clTanggal;

    @FXML
    private TableColumn<Donasi, String> clStatus;

    ObservableList<Donasi> list = FXCollections.observableArrayList();

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clEvent.setCellValueFactory(new PropertyValueFactory<>("event"));
        clNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        clTanggal.setCellValueFactory(new PropertyValueFactory<>("create_at"));
        clDonasi.setCellValueFactory(new PropertyValueFactory<>("jumlah_donasi"));
        clStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ArrayList<Donasi> data = Donasi.getDonasiByKomunitas();
        for (Donasi donasi:data){
            list.add(new Donasi(donasi.getJumlah_donasi(), donasi.getStatus(), donasi.getEvent(), donasi.getCreate_at(), donasi.getNama()));
        }
        table.setItems(list);
    }

}
