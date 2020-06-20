package Controller;

import Helper.Helper;
import Helper.ORM;
import Model.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class DetailEvent implements Initializable {
    private int id_event;

    @FXML
    private JFXButton btnClose;

    @FXML
    private Label txtNamaEvent;

    @FXML
    private Label txtTanggal;

    @FXML
    private ImageView imgPoster;

    @FXML
    private Label txtDeskripsi;

    @FXML
    private ProgressBar prgrsVolunteer;

    @FXML
    private ProgressBar prgrsDonasi;

    @FXML
    private JFXButton btnVolunteer;

    @FXML
    private JFXButton btnDonasi;

    @FXML
    private Label txtVolunteer;

    @FXML
    private Label txtDonasi;

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("idnya bro "+getId_event());
    }

    public void LoadData(int id){
        simpanID(id);
        System.out.println("idnya bro "+getId_event());
        HashMap<String, String> data = ((HashMap<String, String>) Event.getDetailEvent(id));
        ResultSet conVlntr = ORM.selectColumn("volunteer", new String[]{"count(id) as jmlh_volunteer"}, "id_event="+data.get("id")+" Group by id_event");
        ResultSet conDns = ORM.selectColumn("donasi", new String[]{"sum(jumlah_donasi) as jmlh_donasi"}, "id_event="+data.get("id"));
        int vlntr = 0;
        int dns = 0;
        double dns_ , vlntr_;
        try {
            conVlntr.next();
            conDns.next();
            vlntr = conVlntr.getInt("jmlh_volunteer");
            dns = conDns.getInt("jmlh_donasi");
            this.txtVolunteer.setText(vlntr+"/"+data.get("volunteer"));
            this.txtDonasi.setText(dns+"/"+data.get("donasi"));
            dns_ = dns / Double.parseDouble(data.get("donasi"));
            vlntr_ = vlntr / Double.parseDouble(data.get("volunteer"));

            this.prgrsDonasi.setProgress(dns_);
            this.prgrsVolunteer.setProgress(vlntr_);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.txtNamaEvent.setText(data.get("judul"));
        this.txtDeskripsi.setText(data.get("deskripsi"));
        this.txtTanggal.setText(data.get("tanggal"));

        Image image = new Image(getClass().getResourceAsStream("/Assets/Poster/"+data.get("poster")), 190, 480, true, true);
        imgPoster.setPreserveRatio(true);
        imgPoster.setSmooth(true);
        imgPoster.setImage(image);

    }

    public static int simpanID(int id){
        return id;
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnVolunteerOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/register_volunteer.fxml"));
            Parent root = null;
            root = loader.load();
            RegisterVolunteer rv = loader.getController();
            rv.setId_event(getId_event());
            Stage stage =new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnDonasiOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/add_donasi_user.fxml"));
            Parent root = null;
            root = loader.load();
            AddDonasiUser addDonasiUser = loader.getController();
            addDonasiUser.load(getId_event());
            Stage stage =new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
