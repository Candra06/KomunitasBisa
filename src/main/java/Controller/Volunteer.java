package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;


public class Volunteer {
    private static final String TABLE= "volunteer";
    private  int id_event;
    private  int id_user;
    private  String kriteria;
    private  String keterangan;
    private  String status;
    private  String create_at;
    private  String update_at;

    public Volunteer(int id_event, int id_user, String kriteria, String keterangan, String status, String create_at, String update_at) {
        this.id_event = id_event;
        this.id_user = id_user;
        this.kriteria = kriteria;
        this.keterangan = keterangan;
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




}
