package komunitas;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VolunteerPage implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetail();
    }

    public void getDetail(){
        ArrayList<Volunteer> data = Volunteer.getVolunteer();
    }
}
