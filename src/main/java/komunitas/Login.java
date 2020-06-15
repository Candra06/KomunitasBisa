package komunitas;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Login implements Initializable {
    public JFXPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JFXPasswordField txtPassword) {

        this.txtPassword = txtPassword;

    }

    public JFXTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JFXTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXCheckBox showPassword;

    @FXML
    private JFXButton btnLogin;

    public void btnLoginOnClick(ActionEvent actionEvent) {
        login();
        if (this.txtEmail.getText().equals("admin") && this.txtPassword.getText().equals("admin")){
            Helper.changePage(actionEvent, "dashboard_admin");
        }else if (this.txtEmail.getText().equals("komunitas") && this.txtPassword.getText().equals("komunitas")){
            Helper.changePage(actionEvent, "dashboard_komunitas");
        }else if (this.txtEmail.getText().equals("user") && this.txtPassword.getText().equals("user")){
            Helper.changePage(actionEvent, "dashboard_user");
        }else {
            System.out.println("Login gagal");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void login(){
        ArrayList<Akun> data = Akun.getAkun();
    }

}
