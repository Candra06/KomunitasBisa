package Controller;
import Helper.Helper;
import Model.Donasi;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Helper.ORM;
import java.sql.ResultSet;

public class KonfirmasiDonasi {

    private int id_donasi;

    public int getId_donasi() {
        return id_donasi;
    }

    public void setId_donasi(int id_donasi) {
        this.id_donasi = id_donasi;
    }

    @FXML
    private JFXTextArea txtKeterangan;

    @FXML
    private JFXButton btnKonfirmasi;

    @FXML
    private Label txtEvent;

    @FXML
    private Label txtDonatur;

    @FXML
    private Label txtNominal;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private ImageView imgBukti;

    @FXML
    private Label txtStatus;

    public void btnCancelOnclick(ActionEvent actionEvent) {
        close();
    }

    void close(){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void loaddata(int id){
        setId_donasi(id);
        ResultSet rs = ORM.selectColumn("donasi , event, user", new String[]{"event.judul_event", "user.nama, donasi.status", "donasi.jumlah_donasi", "donasi.bukti_donasi", "donasi.id"}, "donasi.id_event=event.id AND donasi.id_user=user.id AND donasi.id="+id);
        try {
            rs.next();
            this.txtEvent.setText(rs.getString("judul_event"));
            this.txtDonatur.setText(rs.getString("nama"));
            this.txtNominal.setText(rs.getString("jumlah_donasi"));
            this.txtStatus.setText(rs.getString("status"));
            Image image = new Image(getClass().getResourceAsStream("/Assets/BuktiTF/"+rs.getString("bukti_donasi")));
            imgBukti.setPreserveRatio(true);
            imgBukti.setSmooth(true);
            imgBukti.setImage(image);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnKonfirmasiOnclick(ActionEvent actionEvent) {
        if (this.txtStatus.getText().equals("diteruskan")){
            update(getId_donasi(), "diterima");
            System.out.println("idnya"+getId_donasi()+" "+this.txtKeterangan.getText());
            close();
        }else {
            Helper.alert("Donasi sudah diterima", "Info","info");
        }
    }
    void update(int id, String status){
        boolean data = Donasi.UpdateDonasi(id, status, this.txtKeterangan.getText());
        if (data == true){
            Helper.alert("Berhasil menerima donasi", "Konfirmasi Berhasil","sukses");
        }else {
            Helper.alert("Gagal menerima donasi", "Konfirmasi Gagal","gagal");
        }
    }
}
