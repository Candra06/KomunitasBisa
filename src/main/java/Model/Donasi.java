package Model;

import Helper.ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Donasi extends ORM {
    private static final String TABLE= "donasi";
    private int id_event;
    private int id_user;
    private int jumlah_donasi;
    private String bukti_donasi;
    private String status;
    private String create_at;
    private String update_at;

    public Donasi(int id_event, int id_user, int jumlah_donasi, String bukti_donasi, String status, String create_at, String update_at) {
        this.id_event = id_event;
        this.id_user = id_user;
        this.jumlah_donasi = jumlah_donasi;
        this.bukti_donasi = bukti_donasi;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getJumlah_donasi() {
        return jumlah_donasi;
    }

    public void setJumlah_donasi(int jumlah_donasi) {
        this.jumlah_donasi = jumlah_donasi;
    }

    public String getBukti_donasi() {
        return bukti_donasi;
    }

    public void setBukti_donasi(String bukti_donasi) {
        this.bukti_donasi = bukti_donasi;
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

    public static ArrayList<Donasi> getDonasi(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Donasi> donasi = new ArrayList<Donasi>();
        return donasi;
    }

    public static boolean InsertDonasi(){
        Map<String, String> data = null;
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdateDonasi(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }
}
