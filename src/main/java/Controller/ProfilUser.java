package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;


public class ProfilUser {
    @FXML
    private JFXTextField txtNamaUser;

    @FXML
    private JFXTextField txtPekerjaan;

    @FXML
    private JFXTextField txtEmailUser;

    @FXML
    private JFXTextField txtNoHPUser;

    @FXML
    private JFXComboBox<?> cbbGender;

    @FXML
    private JFXPasswordField txtPasswordUser;

    @FXML
    private JFXTextArea txtAlamatUser;

    @FXML
    private JFXButton btnSimpanUser;

    @FXML
    private JFXButton btnClose;

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_user");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
