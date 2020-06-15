package Controller;

import Helper.Helper;
import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.fxml.FXML;

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

    @FXML
    void btnRegisterOnClick(ActionEvent event) {

    }

    public void btnEventOnClick(javafx.event.ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "dashboard_admin");
    }

    public void btnRegisterOnClick(javafx.event.ActionEvent actionEvent) {
        Helper.changePage(actionEvent, "pg_register");
    }

    public void btnCloseOnClick(javafx.event.ActionEvent actionEvent) {
        Helper.closeWindow(actionEvent, this.btnClose);
    }
}
