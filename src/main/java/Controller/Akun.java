package Controller;

import Helper.ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Akun extends ORM {
    private static final String TABLE = "akun";
    private int id_akses;
    private String email;
    private String password;
    private String level;
    private String status;
    private String create_at;

    public Akun(int id_akses, String email, String password, String level, String status, String create_at) {
        this.id_akses = id_akses;
        this.email = email;
        this.password = password;
        this.level = level;
        this.status = status;
        this.create_at = create_at;
    }

    public int getId_akses() {
        return id_akses;
    }

    public void setId_akses(int id_akses) {
        this.id_akses = id_akses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public static ArrayList<Users> getAkun(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Users> users = new ArrayList<Users>();
//        try {
//            while (resultSet.next()){
//                String email =resultSet.getString("nama");
//                String gender =resultSet.getString("gender");
//                String telepon =resultSet.getString("telepon");
//                String pekerjaan =resultSet.getString("pekerjaan");
//                String alamat =resultSet.getString("alamat");
//                String status =resultSet.getString("status");
//
//                Users usersModel = new Users(nama, gender, telepon, pekerjaan, alamat, status);
//                users.add(usersModel);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return users;
    }

    public static boolean InsertAkun(){
        Map<String, String> data = null;
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdateAkun(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }


}
