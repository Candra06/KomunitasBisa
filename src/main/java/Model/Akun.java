package Model;

import Helper.ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

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

    public static ArrayList<Akun> getLogin(String email, String pass){
        email = email.replaceAll("'", "").replaceAll(" ", "");
        pass = pass.replaceAll("'", "").replaceAll(" ", "");
        ResultSet rs = selectAll("akun", String.format("email = '%s' and password = '%s' and status='aktif'", email, pass));
        ArrayList<Akun> akun = new ArrayList<Akun>();
        try {
            if (!rs.next()){
                return null;
            }else {
                String email_ = rs.getString("email");
                String password_ = rs.getString("password");
                String level_ = rs.getString("level");
                int id_akes_ = rs.getInt("id");
                String status_ = rs.getString("status");
                String create_at_ = rs.getString("create_at");
                Akun akuns = new Akun(id_akes_, email_, password_,level_, status_, create_at_);
                akun.add(akuns);
                return akun;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Map getInfoAdminKomunitas(){
        Map<String, String> hasil = null;
        int id_akun = 0;
        int id_komunitas = 0;
        Preferences pref = Preferences.userRoot();
        id_akun = pref.getInt("id_akun", id_akun);
        id_komunitas = pref.getInt("id_komunitas", id_komunitas);
        ResultSet rs = ORM.selectAll("pengurus", "pengurus.id_akun="+id_akun, TABLE, "id_akun");
        try {
            rs.next();
            Map<String, String> data = new HashMap<String, String>();
            data.put("nama", rs.getString("nama"));
            data.put("telepon", rs.getString("telepon"));
            data.put("email", rs.getString("email"));
            hasil = data;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(hasil);
        return hasil;
    }



    public static String getDataAdminKomunitas(int id_akun){
        return null;
    }

    public static String getDataAdminSistem(int id_akun){
        return null;
    }

    public static Akun getUser(){
        return null;
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

    public static ArrayList<Akun> getAkun(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Akun> akun = new ArrayList<Akun>();
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
        return akun;
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
