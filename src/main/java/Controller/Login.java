package Controller;

import Helper.Helper;
import Helper.ORM;
import Model.Akun;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class Login implements Initializable {
    public String Nama = "";
    public String LEVEL = "";
    public int ID = 0;
    public int ID_AKUN = 0;
    public int ID_KOMUNITAS = 0;

    DashboardKomunitas dbk = new DashboardKomunitas();
    DashboardAdmin dba = new DashboardAdmin();
    DashboardUser dbu = new DashboardUser();

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

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(String LEVEL) {
        this.LEVEL = LEVEL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_AKUN() {
        return ID_AKUN;
    }

    public void setID_AKUN(int ID_AKUN) {
        this.ID_AKUN = ID_AKUN;
    }

    public int getID_KOMUNITAS() {
        return ID_KOMUNITAS;
    }

    public void setID_KOMUNITAS(int ID_KOMUNITAS) {
        this.ID_KOMUNITAS = ID_KOMUNITAS;
    }

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
                    Preferences userPreferences = Preferences.userRoot();
                    userPreferences.put("nama",resultSet.getString("nama"));
                    userPreferences.put("id_akun",resultSet.getString("id_akun"));
                    userPreferences.put("id",resultSet.getString("id"));
                    userPreferences.put("level", "user");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Helper.changePage(actionEvent, "dashboard_user");
            }else if (level.equals("admin_komunitas")){
                try {
                    ResultSet resultSet = ORM.selectColumn("pengurus", new String[]{"id, id_akun,nama, id_komunitas"}, "id_akun="+id_akun);
                    resultSet.next();
                    setLEVEL("Komunitas");
                    Preferences userPreferences = Preferences.userRoot();
                    userPreferences.put("nama",resultSet.getString("nama"));
                    userPreferences.put("id_akun",resultSet.getString("id_akun"));
                    userPreferences.put("id_komunitas",resultSet.getString("id_komunitas"));
                    userPreferences.put("id",resultSet.getString("id"));
                    userPreferences.put("level", "komunitas");
                    Helper.alert("Selamat datang!", "Berhasil", "sukses");
                    Helper.changePage(actionEvent, "dashboard_komunitas");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if (level.equals("admin_sistem")){
                try {
                    ResultSet resultSet = ORM.selectColumn("akun", new String[]{"id"}, "id="+id_akun);
                    resultSet.next();
                    Preferences userPreferences = Preferences.userRoot();
                    userPreferences.put("nama", "Admin");
                    userPreferences.put("id_akun",resultSet.getString("id"));
                    userPreferences.put("level", "admin");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Helper.alert("Selamat datang!", "Berhasil", "sukses");
                Helper.changePage(actionEvent,"dashboard_admin");
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
