package Controller;

import Helper.Helper;
import Model.Event;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ListEvent implements Initializable {

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXComboBox<String> cbbFilter;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private TableView<Event> table;

    @FXML
    private TableColumn<Event, String> clKomunitas;

    @FXML
    private TableColumn<Event, String> clEvent;

    @FXML
    private TableColumn<Event, String> clTanggal;

    @FXML
    private TableColumn<Event, String> clVolunteer;

    @FXML
    private TableColumn<Event, String> clDonasi;

    @FXML
    private TableColumn<Event, String> clStatus;

    @FXML
    private JFXButton btnBack;

    ObservableList<Event> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clKomunitas.setCellValueFactory(new PropertyValueFactory<>("komunitas"));
        clEvent.setCellValueFactory(new PropertyValueFactory<>("judul_event"));
        clTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        clDonasi.setCellValueFactory(new PropertyValueFactory<>("jumlah_donasi"));
        clVolunteer.setCellValueFactory(new PropertyValueFactory<>("jumlah_volunteer"));
        clStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ArrayList<Event> data = Event.getEventByUser();
        for (Event event :data){
            list.add(new Event(event.getId_event(), event.getJudul_event(), event.getTanggal(), event.getJumlah_donasi() , event.getJumlah_volunteer() ,event.getStatus(), event.getKomunitas()));
        }
        table.setItems(list);

        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/detail_event.fxml"));
                    Parent root = loader.load();
                    DetailEvent detailEvent = loader.getController();
                    detailEvent.LoadData(table.getSelectionModel().getSelectedItem().getId_event());
                    detailEvent.setId_event(table.getSelectionModel().getSelectedItem().getId_event());
                    Stage stage =new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void btnLoginOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent,"pg_login");
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent,"home_screen");
    }
}
