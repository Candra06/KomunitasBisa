package Helper;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "bismillah5758";

    public static void changePage(Event event, String page){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(Helper.class.getResource("../View/"+page+".fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeWindow(Event event, Button buttonName){
        Stage stage = (Stage) buttonName.getScene().getWindow();
        stage.close();
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


}
