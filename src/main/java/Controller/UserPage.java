package Controller;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class UserPage implements Initializable {
    @FXML
    private JFXListView<Label> listUser;

    @FXML
    private JFXButton btnAddUser;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private JFXButton btnClose;

    public void cellOnClick(MouseEvent mouseEvent) {
        System.out.println("Yang di click "+ listUser.getSelectionModel().getSelectedItems().toString());
        Helper.changePage(mouseEvent,"detail_user");
    }

    public void btnAddUserOnClick(ActionEvent actionEvent) {
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String data[] = {"Rizal Faqrul", "Fitria Rahmawaati", "Dyke Rifqy Aufar", "Abiyu Candra"};
        for (int i = 0; i < data.length; i++) {
            try {
                Label label = new Label(data[i]);
                this.listUser.getItems().add(label);

            }catch (Exception e){
                System.out.println("Error gan "+e.getMessage());
            }
        }
    }
}
