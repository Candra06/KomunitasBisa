package Controller;

import Helper.Helper;
import Model.Event;
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
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class EventPage implements Initializable {
    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnAddEvent;

    @FXML
    private JFXComboBox<?> cbbFilter;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private TableView<Event> table;

    @FXML
    private TableColumn<Event, String> colJudul;

    @FXML
    private TableColumn<Event, String> colTanggal;

    @FXML
    private TableColumn<Event, String> colStatus;

    @FXML
    private TableView<Event> tableUsr;

    @FXML
    private TableColumn<Event, String> colKomunitasUsr;

    @FXML
    private TableColumn<Event, String> colJudulUsr;

    @FXML
    private TableColumn<Event, String> colTanggalUsr;

    @FXML
    private TableColumn<Event, String> colStatusUsr;

    @FXML
    private TableColumn<Event, Integer> colJmlhDonasi;

    @FXML
    private TableColumn<Event, Integer> colJmlhVolunteer;

    ObservableList<Event> observableList = FXCollections.observableArrayList();
    ObservableList<Event> observableListUser = FXCollections.observableArrayList();

    public void cellOnClick(MouseEvent mouseEvent) {
//        System.out.println("Yang di click "+ listEvent.getSelectionModel().getSelectedItems().toString());
//        Helper.changePage(mouseEvent, "detail_event");
    }

    public void btnLoginOnClick(ActionEvent actionEvent) {
    }

    public void btnAddEventOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "add_event");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String level = "";
        Preferences pf = Preferences.userRoot();
        level = pf.get("level", level);
        if (level.equals("komunitas")){
            colJudul.setCellValueFactory(new PropertyValueFactory<>("judul_event"));
            colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            ArrayList<Event> data = Event.getEventByKomunitas();
            for (Event event :data){
                observableList.add(new Event(event.getId_event(), event.getJudul_event(), event.getTanggal(),event.getStatus()));
            }
            table.setItems(observableList);
        }else{
            colKomunitasUsr.setCellValueFactory(new PropertyValueFactory<>("komunitas"));
            colJudulUsr.setCellValueFactory(new PropertyValueFactory<>("judul_event"));
            colTanggalUsr.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            colJmlhDonasi.setCellValueFactory(new PropertyValueFactory<>("jumlah_donasi"));
            colJmlhVolunteer.setCellValueFactory(new PropertyValueFactory<>("jumlah_volunteer"));
            colStatusUsr.setCellValueFactory(new PropertyValueFactory<>("status"));

            ArrayList<Event> data = Event.getEventByUser();
            for (Event event :data){
                observableListUser.add(new Event(event.getId_event(), event.getJudul_event(), event.getTanggal(), event.getJumlah_donasi() , event.getJumlah_volunteer() ,event.getStatus(), event.getKomunitas()));
            }
            tableUsr.setItems(observableListUser);

            tableUsr.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/detail_event.fxml"));
                        Parent root = loader.load();
                        DetailEvent detailEvent = loader.getController();
                        detailEvent.LoadData(tableUsr.getSelectionModel().getSelectedItem().getId_event());
                        detailEvent.setId_event(tableUsr.getSelectionModel().getSelectedItem().getId_event());
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
    }

    void detailEvent(int id_event){

    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    public void btnBackPageOnClick(ActionEvent actionEvent) {
        String level = "";
        Preferences pf = Preferences.userRoot();
        level = pf.get("level", level);
        if (level.equals("komunitas")){
            Helper.changePage(actionEvent, "dashboard_komunitas");
        }else {
            Helper.changePage(actionEvent, "dashboard_user");
        }
    }
}
