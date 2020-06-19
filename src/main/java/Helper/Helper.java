package Helper;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void changePage(Event event, String page){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(Helper.class.getResource("../View/"+page+".fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeWindow(Event event, Button buttonName){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pesan Konfirmasi");
        alert.setContentText("Apakah anda yakin ingin keluar dari aplikasi?");
        alert.showAndWait().ifPresent(type -> {
            if (type == ButtonType.OK) {
                Stage stage = (Stage) buttonName.getScene().getWindow();
                stage.close();
            } else if (type == ButtonType.NO) {
                alert.close();
            }
        });

    }

    public static Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://localhost/db_komunitas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
            return conn;
        }catch (ClassNotFoundException ef){
            System.out.println("Class tidak ditemukan");
            return null;
        }catch (SQLException se){
            se.printStackTrace();
            System.out.println("Koneksi gagal");
            return null;
        }
    }

    public static void alert(String message, String judul, String type){
        String getTipe = "";
        if (type == "sukses"){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(judul);
            alert.setContentText(message);
            alert.showAndWait();
        }else if (type == "gagal"){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(judul);
            alert.setContentText(message);
            alert.showAndWait();
        }else if (type == "info"){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(judul);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }


}
