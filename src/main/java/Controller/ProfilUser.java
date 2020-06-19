package Controller;

import Helper.Helper;
import Model.Akun;
import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class ProfilUser implements Initializable {
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
    private JFXButton btnSimpanUser;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnLogout;

    ObservableList<String> gender = FXCollections.observableArrayList("Pilih kelamin", "Laki-laki", "Perempuan");

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        updateProfile();
        Helper.changePage(actionEvent, "dashboard_user");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    void getDetail(){
        HashMap<String, String> data = ((HashMap<String, String>) Users.getDetailUsers());
        HashMap<String, String> dataAkun = (HashMap<String, String>) Akun.getInfoUser();
        this.txtNamaUser.setText(data.get("nama"));
        this.txtAlamatUser.setText(data.get("alamat"));
        this.txtPekerjaan.setText(data.get("pekerjaan"));
        this.txtNoHPUser.setText(data.get("telepon"));
        this.cbbGender.setValue(data.get("gender"));
        this.txtEmailUser.setText(dataAkun.get("email"));
    }

    void updateProfile(){
        String gender = (String) cbbGender.getValue();
        boolean status = Users.updateUser(this.txtNamaUser.getText(), gender, this.txtNoHPUser.getText(), this.txtPekerjaan.getText(), this.txtAlamatUser.getText());
        if (status == true){
            updateAkun();
        }else {
            Helper.alert("Update Gagal", "Gagal", "gagal");
        }
    }

    void updateAkun(){
        boolean status = Akun.UpdateAkun(this.txtEmailUser.getText(), this.txtPasswordUser.getText());
        if (status == true){
            Helper.alert("Berhasil mengubah data", "Berhasil", "sukses");
        }else {
            Helper.alert("Update Gagal", "Gagal", "gagal");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbbGender.setItems(gender);

        getDetail();
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_user");
    }

    public void btnLogoutOnClick(ActionEvent actionEvent) {
        Helper.logOut(actionEvent, "home_screen");
    }
}
