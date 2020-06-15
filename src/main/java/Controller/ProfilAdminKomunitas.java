package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;


public class ProfilAdminKomunitas {
    @FXML
    private JFXTextField txtNamaUser;

    @FXML
    private JFXTextField txtEmailUser;

    @FXML
    private JFXComboBox<?> cbbKomunitas;

    @FXML
    private JFXPasswordField txtPasswordUser;

    @FXML
    private JFXButton btnSimpanUser;

    @FXML
    private JFXButton btnClose;
    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_komunitas");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
