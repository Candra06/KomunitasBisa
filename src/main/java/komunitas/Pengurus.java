package komunitas;

import komunitas.ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

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

    public static boolean InsertPengurus(){
        Map<String, String> data = null;
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdatePengurus(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }

}
