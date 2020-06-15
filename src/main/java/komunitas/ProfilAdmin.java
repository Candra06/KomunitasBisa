package komunitas;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProfilAdmin implements Initializable {
    public void btnCloseOnClick(ActionEvent actionEvent) {
    }

    public void btnSimpanUserOnClick(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetail();
    }

    public void getDetail(){
        ArrayList<Pengurus> data = Pengurus.getPengurus();
    }
}
