package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class AddKomunitas implements Initializable {

    @FXML
    private JFXButton btnAddData;

    @FXML
    private JFXButton btnClose;

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

    public void btnUploasOnClick(ActionEvent actionEvent) {
    }

    public void btnNextOnClick(ActionEvent actionEvent) {
        this.paneKomunitas2.setVisible(true);
        this.paneKomunitas1.setVisible(false);
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnBackOnClick(ActionEvent actionEvent) {
        this.paneKomunitas2.setVisible(false);
        this.paneKomunitas1.setVisible(true);
    }

    public void btnSaveOnClick(ActionEvent actionEvent) {
    }

    public void btnAddDataOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "komunitas_page");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.paneKomunitas2.setVisible(false);
        this.paneKomunitas1.setVisible(true);
    }
}
