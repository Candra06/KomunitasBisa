package komunitas;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListVolunteer implements Initializable {
    public void cellOnClick(MouseEvent mouseEvent) {
    }

    public void btnCloseOnClick(ActionEvent actionEvent) {
    }

    public void btnLoginOnClick(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getData();
    }

    public void getData(){
        ArrayList<Volunteer> data = Volunteer.getVolunteer();
    }
}
