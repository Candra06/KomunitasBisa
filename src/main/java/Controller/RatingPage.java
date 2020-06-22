package Controller;

import Helper.Helper;
import Model.Komunitas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RatingPage implements Initializable {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtCari;

    @FXML
    private JFXButton btnClose;

    @FXML
    private TableView<Komunitas> table;

    @FXML
    private TableColumn<Komunitas, String> clNama;

    @FXML
    private TableColumn<Komunitas, String> clRating;

    public void btnCloseOnClick(ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }

    ObservableList<Komunitas> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clNama.setCellValueFactory(new PropertyValueFactory<>("nama_komunitas"));
        clRating.setCellValueFactory(new PropertyValueFactory<>("rating"));

        ArrayList<Komunitas> data = Komunitas.getKomuitas();
        for (Komunitas komunitas :data){
            list.add(new Komunitas(komunitas.getNama_komunitas(), komunitas.getRating(), komunitas.getId()));
        }
        table.setItems(list);

        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/add_rating.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                    AddRating ar = loader.getController();
                    ar.getData(table.getSelectionModel().getSelectedItem().getId());
                    Stage stage =new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void btnBackOnClick(ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_admin");
    }
}
