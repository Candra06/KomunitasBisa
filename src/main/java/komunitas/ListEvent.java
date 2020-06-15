package komunitas;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListEvent implements Initializable {

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXListView<Label> listEvent;

    @FXML
    void cellOnClick(MouseEvent event) {
//        System.out.println("Yang di click "+ listEvent.getSelectionModel().getSelectedItems().toString());
        Helper.changePage(event,"detail_event");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Berhasil");
        String data[] = {"Reboisasi untuk masa depan", "Menanam bakau demi kelestarian laut", "Gerakan bersih diri"};
        for (int i = 0; i < data.length; i++) {
            try {
                Label label = new Label(data[i]);
                this.listEvent.getItems().add(label);

            }catch (Exception e){
                System.out.println("Error gan "+e.getMessage());
            }
        }
        getData();
    }

    public void getData(){
        ArrayList<Event> data = Event.getEvent();
    }

    public void btnLoginOnClick(ActionEvent actionEvent) {
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
