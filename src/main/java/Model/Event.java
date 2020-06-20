package Model;

import Helper.ORM;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class Event extends ORM{
    private static final String TABLE = "event";
    private int id_komunitas;
    private int id_event;
    private String judul_event;
    private String tanggal;
    private String poster;
    private String deskripsi;
    private int jumlah_donasi;
    private int jumlah_volunteer;
    private String status;
    private String create_at;
    private String update_at;
    private String komunitas;

    public Event(int id_event,int id_komunitas, String judul_event, String tanggal, String poster, String deskripsi, int jumlah_donasi, int jumlah_volunteer, String status, String create_at, String update_at) {
        this.id_event = id_event;
        this.id_komunitas = id_komunitas;
        this.judul_event = judul_event;
        this.tanggal = tanggal;
        this.poster = poster;
        this.deskripsi = deskripsi;
        this.jumlah_donasi = jumlah_donasi;
        this.jumlah_volunteer = jumlah_volunteer;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Event(int id_event, String judul_event, String tanggal, int jumlah_donasi, int jumlah_volunteer, String status, String komunitas) {
        this.judul_event = judul_event;
        this.tanggal = tanggal;
        this.jumlah_donasi = jumlah_donasi;
        this.jumlah_volunteer = jumlah_volunteer;
        this.status = status;
        this.komunitas = komunitas;
        this.id_event = id_event;
    }

    public Event(int id_event, String judul_event, String tanggal, String status) {
        this.id_event = id_event;
        this.judul_event = judul_event;
        this.tanggal = tanggal;
        this.status = status;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getJumlah_volunteer() {
        return jumlah_volunteer;
    }

    public void setJumlah_volunteer(int jumlah_volunteer) {
        this.jumlah_volunteer = jumlah_volunteer;
    }

    public String getKomunitas() {
        return komunitas;
    }

    public void setKomunitas(String komunitas) {
        this.komunitas = komunitas;
    }

    public int getId_komunitas() {
        return id_komunitas;
    }

    public void setId_komunitas(int id_komunitas) {
        this.id_komunitas = id_komunitas;
    }

    public String getJudul_event() {
        return judul_event;
    }

    public void setJudul_event(String judul_event) {
        this.judul_event = judul_event;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getJumlah_donasi() {
        return jumlah_donasi;
    }

    public void setJumlah_donasi(int jumlah_donasi) {
        this.jumlah_donasi = jumlah_donasi;
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

    public static ArrayList<Event> getEvent(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Event> event = new ArrayList<Event>();
        try {
            while (resultSet.next()){
                String judul_event =resultSet.getString("judul_event");
                int id_event =resultSet.getInt("id");
                int id_komunitas =resultSet.getInt("id_komunitas");
                String poster =resultSet.getString("poster");
                String deskripsi =resultSet.getString("deskripsi");
                String create_at =resultSet.getString("create_at");
                String update_at =resultSet.getString("update_at");
                String tanggal =resultSet.getString("tanggal");
                int jmlh_donasi =resultSet.getInt("jmlh_donasi");
                int jmlh_volunteer =resultSet.getInt("jmlh_volunteer");
                String status =resultSet.getString("status");
                Event events = new Event(id_event, id_komunitas, judul_event, tanggal,poster,deskripsi, jmlh_donasi, jmlh_volunteer,status,create_at,update_at);
                event.add(events);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return event;
    }

    public static ArrayList<Event> getEventByUser(){
        ResultSet resultSet = selectAll(TABLE, "komunitas", "id_komunitas");
        ArrayList<Event> event = new ArrayList<Event>();
        try {
            while (resultSet.next()){
                String judul_event =resultSet.getString("judul_event");
                int id_event =resultSet.getInt("id");
                String komunitas =resultSet.getString("nama_komunitas");
                String poster =resultSet.getString("poster");
                String deskripsi =resultSet.getString("deskripsi");
                String create_at =resultSet.getString("create_at");
                String update_at =resultSet.getString("update_at");
                String tanggal =resultSet.getString("tanggal");
                int jmlh_donasi =resultSet.getInt("jmlh_donasi");
                int jmlh_volunteer =resultSet.getInt("jmlh_volunteer");
                String status =resultSet.getString("status");
                Event events = new Event(id_event, judul_event, tanggal, jmlh_donasi, jmlh_volunteer,status, komunitas);
                event.add(events);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return event;
    }

    public static ArrayList<Event> getEventByKomunitas(){
        Preferences pref = Preferences.userRoot();
        String id_= "";
        id_ = pref.get("id_komunitas", String.valueOf(id_));
        ResultSet resultSet = selectAll(TABLE, String.format("id_komunitas=%s", id_));
        ArrayList<Event> event = new ArrayList<Event>();
        try {
            while (resultSet.next()){
                String judul_event =resultSet.getString("judul_event");
                int id_event =resultSet.getInt("id");
                int id_komunitas =resultSet.getInt("id_komunitas");
                String poster =resultSet.getString("poster");
                String deskripsi =resultSet.getString("deskripsi");
                String create_at =resultSet.getString("create_at");
                String update_at =resultSet.getString("update_at");
                String tanggal =resultSet.getString("tanggal");
                int jmlh_donasi =resultSet.getInt("jmlh_donasi");
                int jmlh_volunteer =resultSet.getInt("jmlh_volunteer");
                String status =resultSet.getString("status");
                Event events = new Event(id_event, id_komunitas, judul_event, tanggal,poster,deskripsi, jmlh_donasi, jmlh_volunteer,status,create_at,update_at);
                event.add(events);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return event;
    }

    public static boolean InsertEvent(int id_komunitas,String judul, String tanggal, String deskripsi, int jml_donasi, int jml_volunteer, String poster){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String create_at = format.format(date);

        Map<String, String> data = new HashMap<String, String>();
        data.put("id_komunitas", "'"+id_komunitas+"'");
        data.put("judul_event", "'"+judul+"'");
        data.put("tanggal", "'"+tanggal+"'");
        data.put("deskripsi", "'"+deskripsi+"'");
        data.put("jmlh_donasi", "'"+jml_donasi+"'");
        data.put("jmlh_volunteer", "'"+jml_volunteer+"'");
        data.put("poster", "'"+poster+"'");
        data.put("status", "'on_going'");
        data.put("create_at", "'"+create_at+"'");
        data.put("update_at", "'"+create_at+"'");
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdateEvent(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }

    public static Map getDetailEvent(int id){
        ResultSet resultSet = selectAll(TABLE, TABLE+".id="+id, "komunitas", "id_komunitas");
        Map<String,String> event = null;
        try {
            resultSet.next();
            Map<String, String> data= new HashMap<String, String>();
                data.put("judul", resultSet.getString("judul_event"));
                data.put("id", resultSet.getString("id"));
                data.put("id_komunitas", resultSet.getString("id_komunitas"));
                data.put("poster", resultSet.getString("poster"));
                data.put("deskripsi", resultSet.getString("deskripsi"));
                data.put("tanggal", resultSet.getString("tanggal"));
                data.put("donasi", resultSet.getString("jmlh_donasi"));
                data.put("volunteer", resultSet.getString("jmlh_volunteer"));
                data.put("status", resultSet.getString("status"));
                event =data;

        }catch (Exception e){
            e.printStackTrace();
        }
        return event;
    }
}
