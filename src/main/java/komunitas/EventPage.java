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

public class EventPage implements Initializable {

    @FXML
    private JFXListView<Label> listEvent;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnAddEvent;

    @FXML
    private JFXComboBox<?> cbbFilter;

    @FXML
    private JFXTextField txtCari;

    public void cellOnClick(MouseEvent mouseEvent) {
        System.out.println("Yang di click "+ listEvent.getSelectionModel().getSelectedItems().toString());
        Helper.changePage(mouseEvent, "detail_event");
    }

    public void btnLoginOnClick(ActionEvent actionEvent) {
    }

    public void btnAddEventOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "add_event");
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
    }

    public void getData(){
        ArrayList<Event> data = Event.getEvent();
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
