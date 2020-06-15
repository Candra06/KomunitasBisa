package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

public class DashboardUser {

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
        Helper.changePage(actionEvent, "komunitas_page");
    }

    public void btnProfilOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "profil_user");

    }
}
