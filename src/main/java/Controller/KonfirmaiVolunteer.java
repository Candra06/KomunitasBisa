package Controller;
import Helper.Helper;
import Model.Volunteer;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import Helper.ORM;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.mail.Transport.send;
public class KonfirmaiVolunteer implements Initializable {

    private int id_volunteer;

    public int getId_volunteer() {
        return id_volunteer;
    }

    public void setId_volunteer(int id_volunteer) {
        this.id_volunteer = id_volunteer;
    }

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnKonfirmasi;

    @FXML
    private Label txtNama;

    @FXML
    private Label txtPekerjaan;

    @FXML
    private Label txtHp;

    @FXML
    private JFXButton btnTolak;
    @FXML
    private Label txtEmail;

    @FXML
    private Label txtKeterangan;

    public void getData(int id){
        ResultSet rs = ORM.selectColumn("volunteer, user, akun", new String[]{"volunteer.id", "user.nama", "user.telepon", "user.pekerjaan", "volunteer.kriteria", "akun.email", "volunteer.keterangan"}, "volunteer.id_user=user.id AND user.id_akun=akun.id AND volunteer.id="+id);
        try {
            rs.next();
            this.txtNama.setText(rs.getString("nama"));
            this.txtEmail.setText(rs.getString("email"));
            this.txtPekerjaan.setText(rs.getString("pekerjaan"));
            this.txtHp.setText(rs.getString("telepon"));
            this.txtKeterangan.setText(rs.getString("keterangan"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void terima(){
        boolean koonf = Volunteer.UpdateVolunteer(getId_volunteer(), "Terima");
        if (koonf == true){
            try {
                KonfirmaiVolunteer.sendMail(this.txtEmail.getText(), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Helper.alert("Berhasil menerima volunteer", "Konfirmasi Berhasil","sukses");
            close();
        }else {
            Helper.alert("Gagal menerima volunteer", "Konfirmasi Gagal","gagal");
        }
    }

    public void tolak(){
        boolean koonf = Volunteer.UpdateVolunteer(getId_volunteer(), "Tolak");
        if (koonf == true){
            try {
                KonfirmaiVolunteer.sendMail(this.txtEmail.getText(), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Helper.alert("Berhasil menolak volunteer", "Konfirmasi Berhasil","sukses");
            close();
        }else {
            Helper.alert("Gagal menolak volunteer", "Konfirmasi Gagal","gagal");
        }
    }

    public void btnKonfirmasiiiiiiOnclick(ActionEvent actionEvent) {
        terima();
    }

    public void btnCloseOnclick(ActionEvent actionEvent) {
        close();
    }

    void close(){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnTolakOnClick(ActionEvent actionEvent) {
        tolak();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void sendMail(String recepient, int acc) throws Exception{
        System.out.println("Proses mengirim email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccount = "chenzwahyu@gmail.com";
        String pass = "oekgmjqudrrqukiv";


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, pass);
            }
        });

        Message message = prepareMessage(session, myAccount, recepient, acc);
        send(message);
        System.out.println("Berhasil mengirim email");
    }

    private static Message prepareMessage(Session session, String email, String recipient, int acc) {
        try {
            String pesan = "";
            if (acc == 1){
                pesan = "Halo "+recipient+" \n Selamat, Kamu diterima menjadi Volunteer untuk event kami, cek waktu acara yaa gaes";
            }else {
                pesan = "Halo "+recipient+" \n Maaf, Kamu belum bisa menjadi Volunteer untuk event kami. \n Kita tunggu next event yaa gaes, Salam lestari!";
            }
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Komunitas Bisa-Konfirmasi Penerimaan Volunteer");
            message.setText(pesan);
            return message;
        }catch (Exception e){
            Logger.getLogger(KonfirmaiVolunteer.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
