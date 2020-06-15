package Controller;

import Helper.ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Users extends ORM {
    private static final String TABLE = "user";
    private String nama;
    private String gender;
    private String telepon;
    private String pekerjaan;
    private String alamat;

    public Users(String s, String nama, String gender, String telepon, String pekerjaan, String alamat) {
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

    public static boolean insertUser(String nama, String gender, String telepon, String pekerjaan, String alamat, String status){
        Map<String, String> data = new HashMap<String, String>();
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
