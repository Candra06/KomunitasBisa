package Controller;

import Helper.Helper;
import Model.Users;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserPage implements Initializable {

    @FXML
    private JFXButton btnAddUser;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private TableView<Users> tableUser;

    @FXML
    private TableColumn<Users, String> colNama;

    @FXML
    private TableColumn<Users, String> colTelepon;

    @FXML
    private TableColumn<Users, String> colPekerjaan;

    @FXML
    private TableColumn<Users, String> colStatus;

    @FXML
    private JFXButton btnClose;

    ObservableList<Users> observableList = FXCollections.observableArrayList();

    public void cellOnClick(MouseEvent mouseEvent) {
//        System.out.println("Yang di click "+ listUser.getSelectionModel().getSelectedItems().toString());
        Helper.changePage(mouseEvent,"detail_user");
    }

    public void btnAddUserOnClick(ActionEvent actionEvent) {
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        colPekerjaan.setCellValueFactory(new PropertyValueFactory<>("pekerjaan"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ArrayList<Users> data = Users.getUsers();
        for (Users users : data){
            observableList.add(new Users(users.getNama(), users.getGender(), users.getTelepon(), users.getPekerjaan(), users.getAlamat(), users.getStatus()));
        }
        tableUser.setItems(observableList);
    }

}
