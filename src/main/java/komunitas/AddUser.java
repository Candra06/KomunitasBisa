package komunitas;

import Helper.Helper;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddUser {
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
    private JFXButton btnShowData;

    @FXML
    private JFXButton btnClose;

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "user_page");
    }


    public void btnShowDataOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "user_page");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
