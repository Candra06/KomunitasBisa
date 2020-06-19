package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import Helper.ORM;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DetailKomunitas implements Initializable {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnUser;

    @FXML
    private Pane paneKomunitas1;

    @FXML
    private JFXButton btnNextLevel;

    @FXML
    private Label tabLangkah1;

    @FXML
    private Pane tabLangkah2;

    @FXML
    private Label txtNamaKomunitas;

    @FXML
    private Label txtVisi;

    @FXML
    private Label txtMisi;

    @FXML
    private Label txtDeskripsi;

    @FXML
    private Pane paneKomunitas2;

    @FXML
    private Pane tabLangkah1Done;

    @FXML
    private Pane tabLangkah2Go;

    @FXML
    private JFXButton btnBackLevel;

    @FXML
    private Label txtNamaKetua;

    @FXML
    private Label txtHpKetua;

    @FXML
    private Label txtNamaWakil;

    @FXML
    private Label txtHpWakil;

    @FXML
    private Label txtNamaSekertaris;

    @FXML
    private Label txtHpSekertaris;

    @FXML
    private Label txtNamaBendahara;

    @FXML
    private Label txtHpBendahara;

    @FXML
    private JFXButton btnClose;

    public void btnNextOnClick(ActionEvent actionEvent) {
        this.paneKomunitas2.setVisible(true);
        this.paneKomunitas1.setVisible(false);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_komunitas");
    }

    public void tab2Clicked(MouseEvent mouseEvent) {
    }

    public void tab1Clicked(MouseEvent mouseEvent) {
    }

    public void btnBackLevelOnClick(ActionEvent actionEvent) {
        this.paneKomunitas2.setVisible(false);
        this.paneKomunitas1.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.paneKomunitas2.setVisible(false);
        this.paneKomunitas1.setVisible(true);
        detailKomunitas();
        infoPengurus();
    }

    public void btnCloseEvent(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    void detailKomunitas(){
        Preferences pref = Preferences.userRoot();
        int id = 0;
        id = pref.getInt("id_komunitas", id);
        try {
            ResultSet rs = ORM.selectColumn("komunitas", new String[]{"nama_komunitas, visi,misi,deskripsi"}, String.format("id=%s",id));
            rs.next();
            this.txtNamaKomunitas.setText(rs.getString("nama_komunitas"));
            this.txtVisi.setText(rs.getString("visi"));
            this.txtMisi.setText(rs.getString("misi"));
            this.txtDeskripsi.setText(rs.getString("deskripsi"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void infoPengurus(){
        int id = 0;
        Preferences pref = Preferences.userRoot();
        id = pref.getInt("id_komunitas", id);
        ResultSet ketua = ORM.selectColumn("pengurus", new String[]{"nama", "telepon"}, String.format("id_komunitas=%s AND jabatan='%s'", id, "ketua"));
        ResultSet wakil = ORM.selectColumn("pengurus", new String[]{"nama", "telepon"}, String.format("id_komunitas=%s AND jabatan='%s'", id, "wakil"));
        ResultSet sekertaris = ORM.selectColumn("pengurus", new String[]{"nama", "telepon"}, String.format("id_komunitas=%s AND jabatan='%s'", id, "sekertaris"));
        ResultSet bendahara = ORM.selectColumn("pengurus", new String[]{"nama", "telepon"}, String.format("id_komunitas=%s AND jabatan='%s'", id, "bendahara"));
        try {
            ketua.next();
            wakil.next();
            sekertaris.next();
            bendahara.next();
            this.txtNamaKetua.setText(ketua.getString("nama"));
            this.txtHpKetua.setText(ketua.getString("telepon"));
            this.txtNamaWakil.setText(wakil.getString("nama"));
            this.txtHpWakil.setText(wakil.getString("telepon"));
            this.txtNamaSekertaris.setText(sekertaris.getString("nama"));
            this.txtHpSekertaris.setText(sekertaris.getString("telepon"));
            this.txtNamaBendahara.setText(bendahara.getString("nama"));
            this.txtHpBendahara.setText(bendahara.getString("telepon"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
