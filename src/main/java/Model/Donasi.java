package Model;

import Helper.ORM;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class Donasi extends ORM {
    private static final String TABLE= "donasi";
    private int id_event;
    private int id_donasi;
    private int id_user;
    private int jumlah_donasi;
    private String bukti_donasi;
    private String nama;
    private String status;
    private String create_at;
    private String update_at;
    private String event;

    public Donasi(int id_event, int id_user, int jumlah_donasi, String bukti_donasi, String status, String create_at, String update_at) {
        this.id_event = id_event;
        this.id_user = id_user;
        this.jumlah_donasi = jumlah_donasi;
        this.bukti_donasi = bukti_donasi;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Donasi(int jumlah_donasi, String status, String event) {
        this.jumlah_donasi = jumlah_donasi;
        this.status = status;
        this.event = event;
    }

    public Donasi(int jumlah_donasi, String status, String event, String tanggal, String nama, int id_donasi) {
        this.jumlah_donasi = jumlah_donasi;
        this.status = status;
        this.event = event;
        this.create_at = tanggal;
        this.nama = nama;
        this.id_donasi = id_donasi;
    }

    public String getNama() {
        return nama;
    }

    public int getId_donasi() {
        return id_donasi;
    }

    public void setId_donasi(int id_donasi) {
        this.id_donasi = id_donasi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
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

    public static ArrayList<Donasi> getDonasiByKomunitas(){
        int id_komunitas = 0;
        Preferences p = Preferences.userRoot();
        id_komunitas = p.getInt("id_komunitas", id_komunitas);
        ResultSet resultSet = selectAll(TABLE, "id_komunitas="+id_komunitas+" AND donasi.status='diteruskan' OR donasi.status='diterima'","event","id_event", "user", "id_user");
        ArrayList<Donasi> donasi = new ArrayList<Donasi>();
        try {
            while (resultSet.next()){
                String event = resultSet.getString("judul_event");
                String status = resultSet.getString("status");
                String tanggal = resultSet.getString("create_at");
                String nama = resultSet.getString("nama");
                int nominal = resultSet.getInt("jmlh_donasi");
                int id = resultSet.getInt("id");
                Donasi donasi_ = new Donasi(nominal, status, event,tanggal, nama, id);
                donasi.add(donasi_);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return donasi;
    }

    public static ArrayList<Donasi> getDonasiByUser(){
        int id = 0;
        Preferences pref = Preferences.userRoot();
        id = pref.getInt("id", id);
        ResultSet resultSet = selectAll(TABLE, "id_user="+id, "event", "id_event");
        ArrayList<Donasi> donasi = new ArrayList<Donasi>();
        try {
            while (resultSet.next()){
                String event = resultSet.getString("judul_event");
                String status = "Di"+resultSet.getString("status");
                int nominal = resultSet.getInt("jumlah_donasi");
                Donasi donasi_ = new Donasi(nominal, status, event);
                donasi.add(donasi_);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return donasi;
    }

    public static boolean InsertDonasi(int id_event, int jumlah_donasi, String bukti){
        int id_user = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Preferences pr = Preferences.userRoot();
        id_user = pr.getInt("id", id_user);
        Date date = new Date();
        String create_at = format.format(date);
        Map<String, String> data = new HashMap<String, String>();
        data.put("id_event", "'"+id_event+"'");
        data.put("id_user", "'"+id_user+"'");
        data.put("jumlah_donasi", "'"+jumlah_donasi+"'");
        data.put("bukti_donasi", "'"+bukti+"'");
        data.put("create_at", "'"+create_at+"'");
        data.put("update_at", "'"+create_at+"'");
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdateDonasi(int id, String status, String keterangan){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String create_at = format.format(date);
        Map<String, String> data = new HashMap<String, String>();
        data.put("status", "'"+ status +"'");
        data.put("keterangan", "'"+ keterangan +"'");
        data.put("update_at", "'"+ create_at +"'");
        boolean hasil = update(TABLE, data, "id="+id);
        return hasil;
    }
}
