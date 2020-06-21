package Controller;

import Helper.Helper;
import Model.Volunteer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListVolunteer implements Initializable {

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXComboBox<String> cbbFilter;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private TableView<Volunteer> table;

    @FXML
    private TableColumn<Volunteer, String> clEvent;

    @FXML
    private TableColumn<Volunteer, String>  clNama;

    @FXML
    private TableColumn<Volunteer, String>  clStatus;

    @FXML
    private TableColumn<Volunteer, String> clKriteria;

    ObservableList<Volunteer> list = FXCollections.observableArrayList();

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        clEvent.setCellValueFactory(new PropertyValueFactory<>("event"));
        clStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        clKriteria.setCellValueFactory(new PropertyValueFactory<>("kriteria"));

        ArrayList<Volunteer> data = Volunteer.getVolunteerByKomunitas();
        for (Volunteer volunteer : data){
            list.add(new Volunteer(volunteer.getId_volunteer(), volunteer.getKriteria(),volunteer.getStatus(), volunteer.getEvent(), volunteer.getNama()));
        }
        table.setItems(list);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/konfirmasi_volunteer.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                    KonfirmaiVolunteer kn = loader.getController();
                    kn.getData(table.getSelectionModel().getSelectedItem().getId_volunteer());
                    kn.setId_volunteer(table.getSelectionModel().getSelectedItem().getId_volunteer());
//                    KonfirmaiVolunteer konfirmaiVolunteer = loader.getController();
//                    konfirmaiVolunteer.getData(table.getSelectionModel().getSelectedItem().getId_volunteer());
//                    konfirmaiVolunteer.setId_volunteer(table.getSelectionModel().getSelectedItem().getId_volunteer());
                    Stage stage =new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(table.getSelectionModel().getSelectedItem().getId_volunteer());
            }
        });
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_komunitas");
    }
}
