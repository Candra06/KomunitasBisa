package Controller;

import Helper.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class RatingPage implements Initializable {

    @FXML
    private JFXListView<Label> listRating;

    @FXML
    private JFXButton btnAddUser;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private JFXButton btnClose;
    public void cellOnClick(MouseEvent mouseEvent) {
    }

    public void btnAddRatingOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "add_rating");
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
                this.listRating.getItems().add(label);

            }catch (Exception e){
                System.out.println("Error gan "+e.getMessage());
            }
        }
    }
}
