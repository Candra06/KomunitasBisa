package Controller;

import Helper.Helper;
import Helper.ORM;
import Model.Komunitas;
import Model.Pengurus;
import Model.Users;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Register implements Initializable {
    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnKomunitas;

    @FXML
    private Pane paneUser;

    @FXML
    private JFXTextField txtNamaUser;

    @FXML
    private JFXTextField txtPekerjaan;

    @FXML
    private JFXTextField txtEmailUser;

    @FXML
    private JFXTextField txtNoHPUser;

    @FXML
    private JFXComboBox<String> cbbGender;

    @FXML
    private JFXPasswordField txtPasswordUser;

    @FXML
    private JFXTextArea txtAlamatUser;

    @FXML
    private JFXCheckBox cbSetuju;

    @FXML
    private JFXButton btnSimpanUser;

    @FXML
    private Pane paneKomunitas1;

    @FXML
    private JFXTextField txtNamaKomuitas;

    @FXML
    private JFXTextArea txtVisi;

    @FXML
    private JFXTextArea txtMisi;

    @FXML
    private JFXTextArea txtDeskripsi;

    @FXML
    private JFXButton btnUploadLogo;

    @FXML
    private JFXButton btnNextLevel;

    @FXML
    private Label tabLangkah1;

    @FXML
    private Pane tabLangkah2;

    @FXML
    private JFXButton btnBack;

    @FXML
    private Pane paneKomunitas2;

    @FXML
    private Pane tabLangkah1Done;

    @FXML
    private Pane tabLangkah2Go;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXTextField txtNamaKetua;

    @FXML
    private JFXTextField txtNoHPKetua;

    @FXML
    private JFXTextField txtNamaWakil;

    @FXML
    private JFXTextField txtNoHPWakil;

    @FXML
    private JFXTextField txtNamaSekertaris;

    @FXML
    private JFXTextField txtNoHPSekertaris;

    @FXML
    private JFXTextField txtNamaBendahara;

    @FXML
    private JFXTextField txtNoHPBendahara;


    @FXML
    private JFXButton btnSave;

    @FXML
    void btnBackPageOnClick(ActionEvent event) {
        Helper.changePage(event, "home_screen");
    }

    public void btnUserOnClick(ActionEvent actionEvent) {

        this.paneKomunitas1.setVisible(false);
        this.paneKomunitas2.setVisible(false);
        this.paneUser.setVisible(true);

        this.btnUser.setStyle("-fx-border-color: #fff;"+"-fx-border-radius: 10px;");
        this.btnKomunitas.setStyle("-fx-border-color: #6eecc6;"+"-fx-border-radius: 10px;");
    }

    public void btnKomunitasOnClick(ActionEvent actionEvent) {
        this.paneUser.setVisible(false);
        this.paneKomunitas2.setVisible(false);
        this.paneKomunitas1.setVisible(true);

        this.btnUser.setStyle("-fx-border-color: #6eecc6");
        this.btnKomunitas.setStyle("-fx-border-color: #fff;"+"-fx-border-radius: 10px;");

    }

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        if (cbSetuju.isSelected()){
            simpanAkun();
            Helper.changePage(actionEvent, "home_screen");
        }else {
            Helper.alert("Harap menyetujui ketentuan yang berlaku!", "Warning", "info");
        }
    }

    void simpanUser(){
        String gender = (String) cbbGender.getValue();
        boolean status = Users.insertUser(txtNamaUser.getText(), gender, txtNoHPUser.getText(), txtPekerjaan.getText(), txtAlamatUser.getText(), "aktif");
        if (status == true){
            Helper.alert("Pendaftaran Berhasil", "Berhasil", "sukses");

        }else {
            Helper.alert("Pendaftaran Gagal", "Gagal", "gagal");
        }
    }
    void simpanAkun(){
        boolean status = Users.insertAkun(txtEmailUser.getText(), txtPasswordUser.getText());
        if (status == true){
            simpanUser();
        }else {
            Helper.alert("Pendaftaran Gagal", "Gagal", "gagal");
        }
    }

    void simpanKomunitas(){
        boolean status = Komunitas.InsertKomunitas(this.txtNamaKomuitas.getText(), this.txtVisi.getText(), this.txtMisi.getText(), this.txtDeskripsi.getText(), "Logo.png");
        if (status == true){
            simpanAkunKetua();
        }else {
            Helper.alert("Pendaftaran Gagal", "Gagal", "gagal");
        }
    }

    void simpanAkunKetua(){
        String email = txtNoHPKetua.getText();
        boolean status = Users.insertAkun(email, "adminkomunitasbisa123");
        if (status == true){
            simpanKetua();
        }else {
            Helper.alert("Pendaftaran Gagal", "Gagal", "gagal");
        }
    }

    void simpanKetua(){
        boolean status = Pengurus.InsertPengurus(txtNamaKetua.getText(), txtNoHPKetua.getText(), "ketua");
        if (status == true){
            simpanAkunWakil();
        }
    }

    void simpanWakil(){
        boolean status = Pengurus.InsertPengurus(txtNamaWakil.getText(), txtNoHPWakil.getText(), "wakil");
        if (status == true){
            simpanAkunSekertaris();
        }
    }

    void simpanSekertaris(){
        boolean status = Pengurus.InsertPengurus(txtNamaSekertaris.getText(), txtNoHPSekertaris.getText(), "sekertaris");
        if (status == true){
            simpanAkunBendahara();
        }
    }

    void simpanBendahara(){
        boolean status = Pengurus.InsertPengurus(txtNamaBendahara.getText(), txtNoHPBendahara.getText(), "bendahara");
        if (status == true){
            Helper.alert("Pendaftaran Berhasil", "Berhasil", "sukses");
        }
    }

    void simpanAkunWakil(){
        String email = txtNoHPWakil.getText();
        boolean status = Users.insertAkun(email, "adminkomunitasbisa123");
        if (status == true){
            simpanWakil();
        }else {
            Helper.alert("Pendaftaran Gagal", "Gagal", "gagal");
        }
    }

    void simpanAkunSekertaris(){
        String email = txtNoHPSekertaris.getText();
        boolean status = Users.insertAkun(email, "adminkomunitasbisa123");
        if (status == true){
            simpanSekertaris();
        }else {
            Helper.alert("Pendaftaran Gagal", "Gagal", "gagal");
        }
    }

    void simpanAkunBendahara(){
        String email = txtNoHPBendahara.getText();
        boolean status = Users.insertAkun(email, "adminkomunitasbisa123");
        if (status == true){
            simpanBendahara();
        }else {
            Helper.alert("Pendaftaran Gagal", "Gagal", "gagal");
        }
    }

    public void cbSetujuChecked(ActionEvent actionEvent) {
    }

    public void btnUploasOnClick(ActionEvent actionEvent) {
    }

    public void btnNextOnClick(ActionEvent actionEvent) {
        this.paneUser.setVisible(false);
        this.paneKomunitas1.setVisible(false);
        this.paneKomunitas2.setVisible(true);
    }

    public void btnBackOnClick(ActionEvent actionEvent) {
        this.paneUser.setVisible(false);
        this.paneKomunitas2.setVisible(false);
        this.paneKomunitas1.setVisible(true);
    }

    public void btnSaveOnClick(ActionEvent actionEvent) {
        simpanKomunitas();
        Helper.changePage(actionEvent, "home_screen");
    }

    public JFXTextField getTxtNamaUser() {
        return txtNamaUser;
    }

    public void setTxtNamaUser(JFXTextField txtNamaUser) {
        this.txtNamaUser = txtNamaUser;
    }

    public JFXTextField getTxtPekerjaan() {
        return txtPekerjaan;
    }

    public void setTxtPekerjaan(JFXTextField txtPekerjaan) {
        this.txtPekerjaan = txtPekerjaan;
    }

    public JFXTextField getTxtEmailUser() {
        return txtEmailUser;
    }

    public void setTxtEmailUser(JFXTextField txtEmailUser) {
        this.txtEmailUser = txtEmailUser;
    }

    public JFXTextField getTxtNoHPUser() {
        return txtNoHPUser;
    }

    public void setTxtNoHPUser(JFXTextField txtNoHPUser) {
        this.txtNoHPUser = txtNoHPUser;
    }

    public JFXComboBox<String> getCbbGender() {
        return cbbGender;
    }

    public void setCbbGender(JFXComboBox<String> cbbGender) {
        this.cbbGender = cbbGender;
    }

    public JFXPasswordField getTxtPasswordUser() {
        return txtPasswordUser;
    }

    public void setTxtPasswordUser(JFXPasswordField txtPasswordUser) {
        this.txtPasswordUser = txtPasswordUser;
    }

    public JFXTextArea getTxtAlamatUser() {
        return txtAlamatUser;
    }

    public void setTxtAlamatUser(JFXTextArea txtAlamatUser) {
        this.txtAlamatUser = txtAlamatUser;
    }

    public JFXCheckBox getCbSetuju() {
        return cbSetuju;
    }

    public void setCbSetuju(JFXCheckBox cbSetuju) {
        this.cbSetuju = cbSetuju;
    }

    public JFXTextField getTxtNamaKomuitas() {
        return txtNamaKomuitas;
    }

    public void setTxtNamaKomuitas(JFXTextField txtNamaKomuitas) {
        this.txtNamaKomuitas = txtNamaKomuitas;
    }

    public JFXTextArea getTxtVisi() {
        return txtVisi;
    }

    public void setTxtVisi(JFXTextArea txtVisi) {
        this.txtVisi = txtVisi;
    }

    public JFXTextArea getTxtMisi() {
        return txtMisi;
    }

    public void setTxtMisi(JFXTextArea txtMisi) {
        this.txtMisi = txtMisi;
    }

    public JFXTextArea getTxtDeskripsi() {
        return txtDeskripsi;
    }

    public void setTxtDeskripsi(JFXTextArea txtDeskripsi) {
        this.txtDeskripsi = txtDeskripsi;
    }

    public JFXTextField getTxtNamaKetua() {
        return txtNamaKetua;
    }

    public void setTxtNamaKetua(JFXTextField txtNamaKetua) {
        this.txtNamaKetua = txtNamaKetua;
    }

    public JFXTextField getTxtNoHPKetua() {
        return txtNoHPKetua;
    }

    public void setTxtNoHPKetua(JFXTextField txtNoHPKetua) {
        this.txtNoHPKetua = txtNoHPKetua;
    }

    public JFXTextField getTxtNamaWakil() {
        return txtNamaWakil;
    }

    public void setTxtNamaWakil(JFXTextField txtNamaWakil) {
        this.txtNamaWakil = txtNamaWakil;
    }

    public JFXTextField getTxtNoHPWakil() {
        return txtNoHPWakil;
    }

    public void setTxtNoHPWakil(JFXTextField txtNoHPWakil) {
        this.txtNoHPWakil = txtNoHPWakil;
    }

    public JFXTextField getTxtNamaSekertaris() {
        return txtNamaSekertaris;
    }

    public void setTxtNamaSekertaris(JFXTextField txtNamaSekertaris) {
        this.txtNamaSekertaris = txtNamaSekertaris;
    }

    public JFXTextField getTxtNoHPSekertaris() {
        return txtNoHPSekertaris;
    }

    public void setTxtNoHPSekertaris(JFXTextField txtNoHPSekertaris) {
        this.txtNoHPSekertaris = txtNoHPSekertaris;
    }

    public JFXTextField getTxtNamaBendahara() {
        return txtNamaBendahara;
    }

    public void setTxtNamaBendahara(JFXTextField txtNamaBendahara) {
        this.txtNamaBendahara = txtNamaBendahara;
    }

    public JFXTextField getTxtNoHPBendahara() {
        return txtNoHPBendahara;
    }

    public void setTxtNoHPBendahara(JFXTextField txtNoHPBendahara) {
        this.txtNoHPBendahara = txtNoHPBendahara;
    }

    ObservableList<String> gender = FXCollections.observableArrayList("Pilih kelamin", "Laki-laki", "Perempuan");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbbGender.setItems(gender);

        this.paneKomunitas1.setVisible(false);
        this.paneKomunitas2.setVisible(false);
        this.paneUser.setVisible(true);
    }

    public void btnBackStepOnClick(ActionEvent actionEvent) {
    }

    public void btnExitOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnExit);
    }
}
