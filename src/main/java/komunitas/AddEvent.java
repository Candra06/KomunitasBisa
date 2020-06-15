package komunitas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


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
    private JFXButton btnNextLevel;

    @FXML
    private JFXTextField txtNamaKomuitas1;

    @FXML
    private JFXTextField txtNamaKomuitas11;

    public void btnAddDataOnClick(ActionEvent actionEvent) {
        addEvent();
    }

    public void btnUploasOnClick(ActionEvent actionEvent) {
    }

    public void btnNextOnClick(ActionEvent actionEvent) {
    }

    public void btnBackOnClick(ActionEvent actionEvent) {
    }

    public void btnSaveOnClick(ActionEvent actionEvent) {
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
    }

    public void addEvent(){
        boolean simpan = Event.InsertEvent();

    }
}
