package komunitas;

import komunitas.ORM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Event extends ORM{
    private static final String TABLE = "event";
    private int id_komunitas;
    private String judul_event;
    private String tanggal;
    private String poster;
    private String deskripsi;
    private int jumlah_donasi;
    private String status;
    private String create_at;
    private String update_at;

    public Event(int id_komunitas, String judul_event, String tanggal, String poster, String deskripsi, int jumlah_donasi, String status, String create_at, String update_at) {
        this.id_komunitas = id_komunitas;
        this.judul_event = judul_event;
        this.tanggal = tanggal;
        this.poster = poster;
        this.deskripsi = deskripsi;
        this.jumlah_donasi = jumlah_donasi;
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
        return event;
    }

    public static boolean InsertEvent(){
        Map<String, String> data = null;
        boolean hasil = insert(TABLE, data);
        return hasil;
    }

    public static boolean UpdateEvent(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }

    public static ArrayList<Event> getDetailEvent(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Event> event = new ArrayList<Event>();
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
        return event;
    }
}
