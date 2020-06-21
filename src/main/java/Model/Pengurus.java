package Model;

import Helper.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class Pengurus extends ORM{
    private static final String TABLE = "pengurus";
    private int id_komunitas;
    private String nama;
    private String telepon;
    private String jabatan;
    private String status;
    private String create_at;
    private String update_at;

    public Pengurus(int id_komunitas, String nama, String telepon, String jabatan, String status, String create_at, String update_at) {
        this.id_komunitas = id_komunitas;
        this.nama = nama;
        this.telepon = telepon;
        this.jabatan = jabatan;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public int getId_komunitas() {
        return id_komunitas;
    }

    public void setId_komunitas(int id_komunitas) {
        this.id_komunitas = id_komunitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
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

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public static ArrayList<Pengurus> getPengurus(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Pengurus> komunitas = new ArrayList<Pengurus>();
        return komunitas;
    }

    public static boolean InsertPengurus(String nama, String telepon, String jabatan){
        ResultSet rs = selectAll("akun ORDER BY id DESC LIMIT 1");
        ResultSet rss = selectAll("komunitas ORDER BY id DESC LIMIT 1");
        int last_id = 0;
        int last_id_komunitas = 0;
        try {
            rss.next();
            rs.next();
            last_id = rs.getInt("id");
            last_id_komunitas = rss.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String create_at = format.format(date);
        Map<String, String> data = new HashMap<String, String>();
        data.put("id_komunitas", "'"+last_id_komunitas+"'");
        data.put("id_akun", "'"+last_id+"'");
        data.put("nama", "'"+nama+"'");
        data.put("telepon", "'"+telepon+"'");
        data.put("jabatan", "'"+jabatan+"'");
        data.put("status", "'aktif'");
        data.put("create_at", "'"+create_at+"'");
        data.put("update_at", "'"+create_at+"'");
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdatePengurus(String nama, String telepon){
        int id = 0;
        Preferences p = Preferences.userRoot();
        id = p.getInt("id_akun", id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String create_at = format.format(date);
        Map<String, String> data = new HashMap<String, String>();
        data.put("nama", "'"+nama+"'");
        data.put("telepon", "'"+telepon+"'");
        data.put("update_at", "'"+create_at+"'");
        boolean hasil = update(TABLE, data, "id_akun="+id);
        return hasil;
    }

}
