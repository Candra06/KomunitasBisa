package komunitas;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DashboardKomunitas {
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
        komunitas.Helper.changePage(actionEvent, "profil_admin_komunitas");
    }

    public void btnAdminOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "admin_komunitas_page");
    }
}
