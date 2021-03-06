package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class AddAdmin {

    @FXML
    private JFXTextField txtNamaUser;

    @FXML
    private JFXTextField txtEmailUser;

    @FXML
    private JFXComboBox<?> cbbGender;

    @FXML
    private JFXPasswordField txtPasswordUser;

    @FXML
    private JFXButton btnSimpanUser;

    @FXML
    private JFXButton btnShowData;

    @FXML
    private JFXButton btnClose;

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "admin_komunitas_page");
    }

    public void btnShowDataOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "admin_komunitas_page");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
