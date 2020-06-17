package komunitas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddDonasiUser {
    @FXML
    private JFXTextField txtNamaUser;

    @FXML
    private JFXButton btnSimpanUser;

    @FXML
    private JFXButton btnSimpanUser1;

    @FXML
    private JFXButton btnClose;

//    @FXML
//    void btnCloseOnClick(ActionEvent event) {
//
//    }

    public void btnSimpanDonasiOnClick(ActionEvent actionEvent) {
        boolean status = Donasi.InsertDonasi();
        if (status == true){
            System.out.println("Insert Berhasil");
        }else {
            System.out.println("Insert Gagal");
        }
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
    }


}
