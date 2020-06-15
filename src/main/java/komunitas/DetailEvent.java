package komunitas;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailEvent implements Initializable {
    public void btnSimpanUserOnClick(ActionEvent actionEvent) {

    }

    public void getDetail(){
        ArrayList<Event> data = Event.getDetailEvent();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetail();
    }
}
