package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DashboardKomunitas implements Initializable {

    private String nama;
    private int id_akun;
    private int id;
    private int id_komunitas;

    @FXML
    private Label txtNama;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnEvent;

    @FXML
    private JFXButton btnDonasi;

    @FXML
    private JFXButton btnVolunteer;


    @FXML
    private JFXButton btnKomunitas;

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnProfil;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId_akun() {
        return id_akun;
    }

    public void setId_akun(int id_akun) {
        this.id_akun = id_akun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_komunitas() {
        return id_komunitas;
    }

    public void setId_komunitas(int id_komunitas) {
        this.id_komunitas = id_komunitas;
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnEventOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "event_page");
    }

    public void btnDonasiOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "donasi_page");
    }

    public void btnVolunteerOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "list_volunteer");
    }

    public void btnKomunitasOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "detail_komunitas");
    }

    public void btnProfilbtnProfil(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "profil_admin_komunitas");
    }

    public void btnAdminOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "admin_komunitas_page");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Preferences userPreferences = Preferences.userRoot();
        String info = userPreferences.get("nama", nama);
        this.txtNama.setText(info);
    }
}
