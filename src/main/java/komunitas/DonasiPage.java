package komunitas;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DonasiPage implements Initializable{

    @FXML
    private JFXListView<Label> listEvent;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXComboBox<?> cbbFilter;

    @FXML
    private JFXTextField txtCari;
    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void cellOnClick(MouseEvent mouseEvent) {
        Helper.changePage(mouseEvent, "add_donasi_user");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String data[] = {"Reboisasi untuk masa depan", "Menanam bakau demi kelestarian laut", "Gerakan bersih diri"};
        for (int i = 0; i < data.length; i++) {
            try {
                Label label = new Label(data[i]);
                this.listEvent.getItems().add(label);

            }catch (Exception e){
                System.out.println("Error gan "+e.getMessage());
            }
        }
        listDonasi();
    }

    public void listDonasi(){
        ArrayList<Donasi> data = Donasi.getDonasi();
    }
}
