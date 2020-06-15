package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminKomunitasPage implements Initializable {

    @FXML
    private JFXButton btnAddData;

    @FXML
    private JFXListView<Label> listKomunitas;

    @FXML
    private JFXTextField txtCariKomunitas;

    @FXML
    private JFXButton btnClose;
    public void btnAddDataOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "add_admin");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String data[] = {"Komunitas Pecinta Lingkungan Jember", "Mapala Balwana", "Graha Pecinta Alam Sukorambi"};
        for (int i = 0; i < data.length; i++) {
            try {
                Label label = new Label(data[i]);
                this.listKomunitas.getItems().add(label);

            }catch (Exception e){
                System.out.println("Error gan "+e.getMessage());
            }
        }
    }
}