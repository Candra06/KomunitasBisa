package Controller;

import Helper.Helper;
import Model.Users;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUser implements Initializable {
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
    private JFXButton btnShowData;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnClose;

    ObservableList<String> gender = FXCollections.observableArrayList("Pilih kelamin", "Laki-laki", "Perempuan");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbbGender.setItems(gender);
    }

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
        simpanAkun();
        Helper.changePage(actionEvent, "user_page");
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


    public void btnShowDataOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "user_page");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "user_page");
    }


}
