package Controller;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import Helper.ORM;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class AdminKomunitasPage implements Initializable {
    private int id_akun = 0;
    private int id_komunitas = 0;
    @FXML
    private JFXButton btnBack;

    @FXML
    private Pane paneKomunitas2;

    @FXML
    private JFXTextField txtNamaKetua;

    @FXML
    private JFXTextField txtTeleponKetua;

    @FXML
    private JFXTextField txtEmailKetua;

    @FXML
    private JFXPasswordField txtPasswordKetua;

    @FXML
    private JFXTextField txtNamaWakil;

    @FXML
    private JFXTextField txtTeleponWakil;

    @FXML
    private JFXTextField txtEmailWakil;

    @FXML
    private JFXPasswordField txtPasswordWakil;

    @FXML
    private JFXButton btnSimpan;

    @FXML
    private JFXTextField txtNamaSekertaris;

    @FXML

    private JFXTextField txtTeleponSekertaris;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnClose;

    Preferences pref = Preferences.userRoot();

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getKetua();
        getWakil();
        getSeker();
    }

    public void btnBackOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_komunitas");
    }

    public void btnSimpanOnClick(ActionEvent actionEvent) {
    }

    void getKetua(){
        this.id_komunitas = pref.getInt("id_komunitas", id_komunitas);
        ResultSet rs = ORM.selectColumn("akun, pengurus", new String[]{"pengurus.id_akun", "pengurus.nama", "akun.email", "pengurus.telepon"}, "pengurus.jabatan='ketua' AND pengurus.id_akun=akun.id AND pengurus.id_komunitas="+id_komunitas);
        try {
            rs.next();
            this.txtNamaKetua.setText(rs.getString("nama"));
            this.txtEmailKetua.setText(rs.getString("email"));
            this.txtTeleponKetua.setText(rs.getString("telepon"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void getWakil(){
        this.id_komunitas = pref.getInt("id_komunitas", id_komunitas);
        ResultSet rs = ORM.selectColumn("akun, pengurus", new String[]{"pengurus.id_akun", "pengurus.nama", "akun.email", "pengurus.telepon"}, "pengurus.jabatan='wakil' AND pengurus.id_akun=akun.id AND pengurus.id_komunitas="+id_komunitas);
        try {
            rs.next();
            this.txtNamaWakil.setText(rs.getString("nama"));
            this.txtEmailWakil.setText(rs.getString("email"));
            this.txtTeleponWakil.setText(rs.getString("telepon"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void getSeker(){
        this.id_komunitas = pref.getInt("id_komunitas", id_komunitas);
        ResultSet rs = ORM.selectColumn("akun, pengurus", new String[]{"pengurus.id_akun", "pengurus.nama", "akun.email", "pengurus.telepon"}, "pengurus.jabatan='sekertaris' AND pengurus.id_akun=akun.id AND pengurus.id_komunitas="+id_komunitas);
        try {
            rs.next();
            this.txtNamaSekertaris.setText(rs.getString("nama"));
            this.txtEmail.setText(rs.getString("email"));
            this.txtTeleponSekertaris.setText(rs.getString("telepon"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
