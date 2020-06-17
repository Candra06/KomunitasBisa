package Controller;

import Helper.Helper;
import Helper.ORM;
import Model.Akun;
import Model.Users;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Login implements Initializable {
    public String Nama = "";
    public String LEVEL = "";
    public int ID = 0;
    public int ID_AKUN = 0;
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
    private JFXButton btnClose;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXCheckBox showPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    void btnCloseEvent(ActionEvent event) {
        Helper.closeWindow(event, this.btnClose);
    }

    public void btnLoginOnClick(ActionEvent actionEvent) {
        if (this.txtEmail.getText().equals("") || this.txtPassword.equals("")){
            Helper.alert("Email dan Password tidak boleh kosong!", "Warning", "info");
        }else {
            ArrayList<Akun> data = Akun.getLogin(this.txtEmail.getText(), this.txtPassword.getText());
            String level = "";
            int id_akun = 0;
            String email = "";
            String status = "";

            for (Akun akun : data){
                level = akun.getLevel();
                id_akun = akun.getId_akses();
                email = akun.getEmail();
                status = akun.getStatus();
            }
            if (level.equals("user")){
                Helper.alert("Selamat datang!", "Berhasil", "sukses");
                try {
                    ResultSet resultSet = ORM.selectColumn("user", new String[]{"id, id_akun,nama"}, "id_akun="+id_akun);
                    resultSet.next();
                    LEVEL = "User";
                    Nama = resultSet.getString("nama");
                    ID = resultSet.getInt("id");
                    ID_AKUN = resultSet.getInt("id_akun");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Helper.changePage(actionEvent, "dashboard_user");
            }else if (level.equals("admin_komunitas")){
                try {
                    ResultSet resultSet = ORM.selectColumn("pengurus", new String[]{"id, id_akun,nama"}, "id_akun="+id_akun);
                    resultSet.next();
                    LEVEL = "Komunitas";
                    Nama = resultSet.getString("nama");
                    ID = resultSet.getInt("id");
                    ID_AKUN = resultSet.getInt("id_akun");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Helper.alert("Selamat datang!", "Berhasil", "sukses");
                System.out.println("Selamat datang komunitas");
            }else if (level.equals("admin_sistem")){
                try {
                    ResultSet resultSet = ORM.selectColumn("akun", new String[]{"id"}, "id_akun="+id_akun);
                    resultSet.next();
                    LEVEL = "Admin";
                    Nama = "Admin";
                    ID = resultSet.getInt("id");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Helper.alert("Selamat datang!", "Berhasil", "sukses");
                System.out.println("Selamat datang admin");
            }else {
                Helper.alert("Level tidak ditemukan!", "Warning", "info");
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "home_screen");
    }
}
