package Model;

import Helper.ORM;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class Volunteer extends ORM {
    private static final String TABLE= "volunteer";
    private  int id_event;
    private  int id_user;
    private  String kriteria;
    private  String keterangan;
    private  String status;
    private  String create_at;
    private  String update_at;
    private String event;

    public Volunteer(int id_event, int id_user, String kriteria, String keterangan, String status, String create_at, String update_at) {
        this.id_event = id_event;
        this.id_user = id_user;
        this.kriteria = kriteria;
        this.keterangan = keterangan;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Volunteer(String status, String event) {
        this.status = status;
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

    public String getKriteria() {
        return kriteria;
    }

    public void setKriteria(String kriteria) {
        this.kriteria = kriteria;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public static ArrayList<Volunteer> getVolunteerByUser(){
        int id = 0;
        Preferences pref = Preferences.userRoot();
        id = pref.getInt("id", id);
        ResultSet resultSet = selectAll(TABLE, "id_user="+id, "event", "id_event");
        ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
        try {
            while (resultSet.next()){
                String event = resultSet.getString("judul_event");
                String status = "Di"+resultSet.getString("status");

                Volunteer volunteer = new Volunteer(event, status);
                volunteers.add(volunteer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return volunteers;
    }

    public static boolean InsertVolunteer(int id_event, String kriteria, String keterangan){
        int id_user = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Preferences pr = Preferences.userRoot();
        id_user = pr.getInt("id", id_user);
        Date date = new Date();
        String create_at = format.format(date);
        Map<String, String> data = new HashMap<String, String>();
        data.put("id_event", "'"+id_event+"'");
        data.put("id_user", "'"+id_user+"'");
        data.put("kriteria", "'"+kriteria+"'");
        data.put("keterangan", "'"+keterangan+"'");
        data.put("create_at", "'"+create_at+"'");
        data.put("update_at", "'"+create_at+"'");
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdateVolunteer(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }



}
