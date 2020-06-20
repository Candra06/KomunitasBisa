package Controller;

import Helper.Helper;
import Model.Volunteer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class RegisterVolunteer {
    private int id_event;

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnSimpan;

    @FXML
    private JFXCheckBox cbbAgree;

    @FXML
    private JFXTextArea txtKeterangan;

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnSimpanOnClick(ActionEvent actionEvent) {
        String kriteria = "";
        if (this.cbbAgree.isSelected()){
            kriteria = "memenuhi";
        }else {
            kriteria = "kurang_memenuhi";
        }
        boolean status = Volunteer.InsertVolunteer(getId_event(), kriteria, this.txtKeterangan.getText());
        if (status == true){
            Helper.alert("Berhasil mendaftar volunteer", "Berhasil", "sukses");
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }else {
            Helper.alert("Gagal mendaftar volunteer", "Gagal", "gagal");
        }
    }
}
