package Controller;

import Helper.Helper;
import Helper.ORM;
import Model.Komunitas;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

import java.sql.ResultSet;

public class AddRating {
    private int rate;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnSimpan;

    @FXML
    private Label txtNamaKomunitas;

    @FXML
    private Rating rating;


    public void btnCloseOnClick(javafx.event.ActionEvent actionEvent) {
        close();
    }

    void close(){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    public void getData(int id){
        setId(id);
        ResultSet rs = ORM.selectColumn("komunitas", new String[]{"nama_komunitas", "rating", "id"}, "id="+id);
        try{
            rs.next();
            this.txtNamaKomunitas.setText(rs.getString("nama_komunitas"));
            this.rating.setRating(rs.getInt("rating"));
            rating.ratingProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    rate = t1.intValue();
                    System.out.println("ratingnya "+rate);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnSimpanOnClick(ActionEvent actionEvent) {
        boolean update = Komunitas.UpdateRating(getId(), this.rate);
        if (update == true){
            Helper.alert("Berhasil memberi rating", "Berhasil", "sukses");
            close();
        }else {
            Helper.alert("Gagal memberi rating", "Gagal", "gagal");
        }
    }
}
