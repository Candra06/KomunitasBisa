package komunitas;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DashboardAdmin {
    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnKomunitas;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnRating;

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnEvent;

    @FXML
    private JFXButton btnVolunteer;

    @FXML
    private JFXButton btnDonasi;

    @FXML
    private JFXButton btnLogout;

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnKomunitasOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "komunitas_page");
    }

    public void btnUserOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "user_page");
    }

    public void btnRatingOnClick(ActionEvent actionEvent) {

        komunitas.Helper.changePage(actionEvent, "rating_page");

    }

    public void btnAdminOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "admin_komunitas_page");
    }

    public void btnEventOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "event_page");
    }

    public void btnVolunteerOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "list_volunteer");
    }

    public void btnDonasiOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "donasi_page");
    }

    public void btnLogoutOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "profil_admin");
    }
}
