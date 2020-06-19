package Model;

import Helper.Helper;
import Helper.ORM;
import impl.org.controlsfx.collections.MappingChange;
import javafx.util.StringConverter;
import javafx.util.converter.DateTimeStringConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class Users extends ORM {
    private static final String TABLE = "user";
    private String nama;
    private String gender;
    private String telepon;
    private String pekerjaan;
    private String alamat;

    public Users( String nama, String gender, String telepon, String pekerjaan, String alamat, String status) {
        this.nama = nama;
        this.gender = gender;
        this.telepon = telepon;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
        this.status = status;
    }

    public static ArrayList<Users> getUsers(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Users> users = new ArrayList<Users>();
        try {
            while (resultSet.next()){
                String nama =resultSet.getString("nama");
                String gender =resultSet.getString("gender");
                String telepon =resultSet.getString("telepon");
                String pekerjaan =resultSet.getString("pekerjaan");
                String alamat =resultSet.getString("alamat");
                String status =resultSet.getString("status");

                Users usersModel = new Users(nama, gender, telepon, pekerjaan, alamat, status);
                users.add(usersModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Users> getDetailUsers(int id_akun){
        ResultSet resultSet = selectAll("user", String.format("id_akun = '%s'", id_akun));
        ArrayList<Users> users = new ArrayList<Users>();
        try {
            while (resultSet.next()){
                String nama =resultSet.getString("nama");
                String gender =resultSet.getString("gender");
                String telepon =resultSet.getString("telepon");
                String pekerjaan =resultSet.getString("pekerjaan");
                String alamat =resultSet.getString("alamat");
                String status =resultSet.getString("status");

                Users usersModel = new Users(nama, gender, telepon, pekerjaan, alamat, status);
                users.add(usersModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static boolean insertAkun(String email, String password, String level){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String create_at = format.format(date);
        Map<String, String> data = new HashMap<String, String>();
        data.put("email", "'"+email+"'");
        data.put("password", "'"+password+"'");
        data.put("level", "'"+level+"'");
        data.put("status", "'aktif'");
        data.put("create_at", "'"+create_at+"'");
        boolean hasil = insert("akun", data);
        return hasil;
    }

    public static boolean insertUser(String nama, String gender, String telepon, String pekerjaan, String alamat, String status){
        String[] col = {"id"};
        ResultSet rs = selectAll("akun ORDER BY create_at DESC LIMIT 1");
        int last_id = 0;
        try {
            rs.next();
            last_id = rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, String> data = new HashMap<String, String>();
        data.put("id_akun", "'"+ last_id +"'");
        data.put("nama", "'"+ nama +"'");
        data.put("gender", "'"+ gender +"'");
        data.put("telepon", "'"+ telepon +"'");
        data.put("pekerjaan", "'"+ pekerjaan +"'");
        data.put("alamat", "'"+ alamat +"'");
        data.put("status", "'"+ status +"'");
        boolean hasil = insert(TABLE, data);
        return hasil;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
}
