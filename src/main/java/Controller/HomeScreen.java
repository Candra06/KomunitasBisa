package Controller;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.awt.event.ActionEvent;

public class HomeScreen {

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnEvent;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnRegister;

    @FXML
    public void btnLoginOnClick(Event event) {
        Helper.changePage(event, "pg_login");
    }

    public void btnEventOnClick(javafx.event.ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "list_event_page");
    }

    public void btnRegisterOnClick(javafx.event.ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "pg_register");
    }

    public void btnCloseOnClick(javafx.event.ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
