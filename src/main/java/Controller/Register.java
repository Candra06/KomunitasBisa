package Controller;

import Model.Users;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;



public class Register {
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
    private Pane paneKomunitas2;

    @FXML
    private Pane tabLangkah1Done;

    @FXML
    private Pane tabLangkah2Go;

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
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSave;
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

        cbbGender = new JFXComboBox<String>();
        cbbGender.getItems().addAll(
                "pria",
                "wanita"
        );
        cbbGender.setPromptText("Pilih Gender");
//        setCbbGender();

        String gender = (String) cbbGender.getValue();
        boolean status = Users.insertUser(txtNamaUser.getText(), gender, txtNoHPUser.getText(), txtPekerjaan.getText(), txtAlamatUser.getText(), "aktif");
        if (status == true){
            System.out.println("Insert Berhasil");
        }else {
            System.out.println("Insert Gagal");
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
}
