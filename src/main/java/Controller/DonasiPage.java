package Controller;

import Helper.Helper;
import Model.Donasi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
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
            list.add(new Donasi(donasi.getJumlah_donasi(), donasi.getStatus(), donasi.getEvent(), donasi.getCreate_at(), donasi.getNama(), donasi.getId_donasi()));
        }
        table.setItems(list);

        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/konfirmasi_donasi.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                    KonfirmasiDonasi kn = loader.getController();
                    kn.loaddata(table.getSelectionModel().getSelectedItem().getId_donasi());
                    Stage stage =new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(table.getSelectionModel().getSelectedItem().getId_donasi());
            }
        });
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_komunitas");
    }
}
