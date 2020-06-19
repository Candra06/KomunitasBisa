package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DashboardUser implements Initializable {

    @FXML
    private Label txtNamaAkun;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnEven;

    @FXML
    private JFXButton btnKomunitas;

    @FXML
    private JFXButton btnProfil;

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnEvenOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "event_page");
    }

    public void btnKomunitasOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "komunitas_page_user");
    }

    public void btnProfilOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "profil_user");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String nama = "";
        Preferences pref = Preferences.userRoot();
        nama = pref.get("nama", nama);
        this.txtNamaAkun.setText(nama);
    }
}
