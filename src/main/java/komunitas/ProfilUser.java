package komunitas;

import Helper.Helper;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ProfilUser implements Initializable {
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
    public void getDetail(){
        ArrayList<Users> data = Users.getUsers();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetail();
    }
}
