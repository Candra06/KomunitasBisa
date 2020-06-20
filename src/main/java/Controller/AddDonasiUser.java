package Controller;

import Helper.Helper;
import Helper.ORM;
import Model.Donasi;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.sql.ResultSet;

public class AddDonasiUser {
    private String bukti;
    private int id_even;

    @FXML
    private Label txtNamaFile;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXTextField txtJumlahDonasi;

    @FXML
    private JFXButton btnSimpan;

    @FXML
    private JFXButton btnUpload;

    @FXML
    private Label txtNamaEvent;

    public int getId_even() {
        return id_even;
    }

    public void setId_even(int id_even) {
        this.id_even = id_even;
    }

    void getImage(){
        FileChooser fc = new FileChooser();
        File fs = fc.showOpenDialog(null);
        File tf = new File("src/main/resources/Assets/BuktiTF/"+fs.getName());
        this.bukti = fs.getName();
        this.txtNamaFile.setText(fs.getName());
        try {
            FileUtils.copyFile(fs,tf);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void load(int id){
        ResultSet rs = ORM.selectColumn("event", new String[]{"judul_event"}, "id="+id) ;
        try {
            rs.next();
            this.txtNamaEvent.setText(rs.getString("judul_event"));
            setId_even(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void btnSimpanOnClick(ActionEvent actionEvent) {
        if (this.bukti.equals("") || txtJumlahDonasi.getText().equals("")){
            Helper.alert("Harap lengkapi data", "Info", "info");
        }else {
            boolean status = Donasi.InsertDonasi(getId_even(), Integer.parseInt(this.txtJumlahDonasi.getText()), this.txtNamaFile.getText());
            if (status == true){
                Helper.alert("Berhasil melakukan donasi", "Berhasil", "sukses");
                Stage stage = (Stage) btnClose.getScene().getWindow();
                stage.close();
            }else {
                Helper.alert("Gagal melakukan donasi", "Gagal", "gagal");
            }
        }
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnUploadOnClick(ActionEvent actionEvent) {
        getImage();
    }
}
