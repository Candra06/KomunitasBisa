package Controller;

import Helper.Helper;
import Model.Komunitas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class KomunitasPage implements Initializable {

    @FXML
    private JFXButton btnBackKmnts;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnAddData;

    @FXML
    private JFXListView<Label> listKomunitas;

    @FXML
    private JFXTextField txtCariKomunitas;

    @FXML
    private TableView<Komunitas> tableKomunitas;

    @FXML
    private TableColumn<Komunitas, String> colNama;

    @FXML
    private TableColumn<Komunitas, String> colRating;
    @FXML
    private TableView<Komunitas> tabelKomunitas;

    @FXML
    private TableColumn<Komunitas, String> clNamaKomunitas;

    @FXML
    private TableColumn<Komunitas, String> clRatingKmnts;

    @FXML
    private TableColumn<Komunitas, String> clRekening;

    ObservableList<Komunitas> observableList = FXCollections.observableArrayList();
    ObservableList<Komunitas> list = FXCollections.observableArrayList();

    public void btnAddDataOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "add_komunitas");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String level = "";
        Preferences pref = Preferences.userRoot();
        level = pref.get("level", "user");

        if (level.equals("user")){
            colNama.setCellValueFactory(new PropertyValueFactory<>("nama_komunitas"));
            colRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
            ArrayList<Komunitas> data = Komunitas.getKomuitas();
            for (Komunitas komunitas:data){
                observableList.add(new Komunitas(komunitas.getNama_komunitas(), komunitas.getRating(),komunitas.getId()));
            }
            tableKomunitas.setItems(observableList);
        }else {
            clNamaKomunitas.setCellValueFactory(new PropertyValueFactory<>("nama_komunitas"));
            clRatingKmnts.setCellValueFactory(new PropertyValueFactory<>("rating"));
            clRekening.setCellValueFactory(new PropertyValueFactory<>("no_rekening"));
            ArrayList<Komunitas> dataKomunitas = Komunitas.getDataKomuitas();
            for (Komunitas komunitas : dataKomunitas) {
                list.add(new Komunitas(komunitas.getNama_komunitas(), komunitas.getRating(), komunitas.getId(), komunitas.getNo_rekening()));
            }
            tabelKomunitas.setItems(list);
        }
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        String level = "";
        Preferences pref = Preferences.userRoot();
        level = pref.get("level", "user");

        if (level.equals("user")){
            Helper.changePage(actionEvent, "dashboard_user");
        }else {
            Helper.changePage(actionEvent, "dashboard_admin");
        }
    }

    public void txtCariOnChange(ActionEvent actionEvent) {
    }

    public void btnBackKmntsOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_admin");
    }
}
