package Controller;

import Helper.Helper;
import Model.Event;
import Model.Users;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.prefs.Preferences;


public class AddEvent {
    @FXML
    private JFXButton btnAddData;

    @FXML
    private JFXButton btnClose;

    @FXML
    private Pane paneKomunitas1;

    @FXML
    private JFXTextField txtNamaKomuitas;

    @FXML
    private JFXTextArea txtDeskripsi;

    @FXML
    private JFXButton btnUploadLogo;

    @FXML
    private JFXButton btnSimpan;

    @FXML
    private JFXTextField txtJmlhVolunteer;

    @FXML
    private JFXTextField txtJumlahDonasi;

    @FXML
    private DatePicker tglEvent;

    @FXML
    private Label txtNameImage;

    public void btnAddDataOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "event_page");
    }

    void getImage(){
        FileChooser fc = new FileChooser();
        File fs = fc.showOpenDialog(null);
        File tf = new File("src/main/resources/Poster/"+fs.getName());
        this.txtNameImage.setText(fs.getName());
        try {
            FileUtils.copyFile(fs,tf);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void simpanEvent(){
        int id_komunitas = 0;
        Preferences userPreferences = Preferences.userRoot();
        String info = userPreferences.get("id_komunitas", String.valueOf(id_komunitas));
        id_komunitas = Integer.parseInt(info);
        int jml_donasi = Integer.parseInt(this.txtJumlahDonasi.getText());
        int jml_volunteer = Integer.parseInt(this.txtJmlhVolunteer.getText());
        System.out.println(this.tglEvent.getValue().toString());

        String tgl_event = this.tglEvent.getValue().toString();
        boolean status = Event.InsertEvent(id_komunitas, this.txtNamaKomuitas.getText(), tgl_event, this.txtDeskripsi.getText(), jml_donasi, jml_volunteer, this.txtNameImage.getText());
        if (status == true){
            Helper.alert("Berhasil menambahkan event", "Berhasil", "sukses");

        }else {
            Helper.alert("Gagal menambahkan event", "Gagal", "gagal");
        }
    }

    public void btnUploasOnClick(ActionEvent actionEvent) {
        getImage();
    }

    public void btnSimpanOnclick(ActionEvent actionEvent) {
        if (this.txtNamaKomuitas.getText().equals("") || this.txtDeskripsi.getText().equals("") || this.tglEvent.getValue().equals("") || this.txtJmlhVolunteer.getText().equals("") || this.txtJumlahDonasi.getText().equals("")){
            Helper.alert("Data tidak valid, harap periksa kembali data anda!", "Info", "info");
        }else {
            simpanEvent();
            Helper.changePage(actionEvent, "event_page");
        }
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
