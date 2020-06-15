package komunitas;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ProfilAdminKomunitas implements Initializable {
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

    public void getDetail(){
        ArrayList<Pengurus> data = Pengurus.getPengurus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetail();
    }
}
