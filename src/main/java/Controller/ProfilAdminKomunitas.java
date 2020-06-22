package Controller;

import Helper.Helper;
import Model.Akun;
import Model.Pengurus;
import Model.Users;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Helper.ORM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class ProfilAdminKomunitas implements Initializable {
    @FXML
    private JFXTextField txtNamaUser;

    @FXML
    private JFXTextField txtEmailUser;

    @FXML
    private JFXPasswordField txtPasswordUser;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private Label txtNamaKomunitas;

    @FXML
    private JFXTextField txtTelepon;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDataDetail();
    }

    void getDataDetail(){
        int id_komunitas = 0;
        Preferences pref = Preferences.userRoot();
        id_komunitas = pref.getInt("id_komunitas", id_komunitas);
        ResultSet rs = ORM.selectColumn("komunitas", new String[]{"nama_komunitas"}, "id="+id_komunitas);
        HashMap<String, String> data = (HashMap<String, String>) Akun.getInfoAdminKomunitas();
        this.txtNamaUser.setText(data.get("nama"));
        this.txtTelepon.setText(data.get("telepon"));
        this.txtEmailUser.setText(data.get("email"));
        try {
            rs.next();
            this.txtNamaKomunitas.setText(rs.getString("nama_komunitas"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void update(){
        boolean status = Pengurus.UpdatePengurus(this.txtNamaUser.getText(),this.txtTelepon.getText());
        if (status == true){
            boolean akun = Akun.UpdateAkun(this.txtEmailUser.getText(), this.txtPasswordUser.getText());
            if (akun == true){
                Helper.alert("Berhasil mengupdate data", "Berhasil", "sukses");
            }else {
                Helper.alert("Gagal mengupdate data", "Gagal", "gagal");
            }
        }else {
            Helper.alert("Gagal mengupdate data", "Gagal", "gagal");
        }
    }

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        if (this.txtNamaUser.getText().equals("") || this.txtEmailUser.getText().equals("") || this.txtTelepon.getText().equals("") || this.txtPasswordUser.getText().equals("")){
            Helper.alert("Lengkapi form yang tersedia", "Info", "info");
        }else {
            update();
        }

    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_komunitas");
    }


    public void btnLogoutOnClick(ActionEvent actionEvent) {
        Helper.logOut(actionEvent, "home_screen");
    }
}
