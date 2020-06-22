package Controller;
import Helper.Helper;
import Model.Akun;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import Helper.ORM;
import javafx.event.ActionEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class ProfilAdmin implements Initializable {
    @FXML
    private JFXTextField txtNamaUser;

    @FXML
    private JFXTextField txtEmailUser;

    @FXML
    private JFXPasswordField txtPasswordUser;

    @FXML
    private JFXButton btnSimpanUser;

    @FXML
    private JFXButton btnBack;

    @FXML
    private Button btnClose;

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        if (txtEmailUser.getText().equals("") || txtPasswordUser.getText().equals("") ){
            Helper.alert("Data tidak valid", "Info", "info");
        }else {
            update();
            Helper.changePage(actionEvent, "dashboard_admin");
        }
    }

    void update(){
        boolean edit = Akun.UpdateAkun(this.txtEmailUser.getText(), this.txtPasswordUser.getText());
        if (edit == true){
            Helper.alert("Berhasil merubah data", "Berhasil", "sukses");
        }else {
            Helper.alert("Gagal merubah data", "Gagal", "gagal");
        }
    }

    void getDetail(){
        int id = 0;
        Preferences pref = Preferences.userRoot();
        id = pref.getInt("id_akun",id);
        ResultSet rs = ORM.selectColumn("akun", new String[]{"email,password,id"}, "id="+id);
        try {
            rs.next();
            txtEmailUser.setText(rs.getString("email"));
            txtNamaUser.setText("Admin Sistem");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetail();
    }

    public void btnBackOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_admin");
    }
}
