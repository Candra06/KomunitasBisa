package komunitas;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;

public class AddRating {

    @FXML
    private JFXButton btnSimpanUser2;

    @FXML
    private JFXButton btnSimpanUser;

    @FXML
    void btnSimpanUserOnClick(ActionEvent event) {

    }

    public void btnSimpanRatingOnClick(javafx.event.ActionEvent actionEvent) {
        updateRating();
    }

    public void updateRating(){
        boolean hasil = Komunitas.UpdateRating();
    }
}
