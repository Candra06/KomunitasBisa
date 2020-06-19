package Model;

import Helper.ORM;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Komunitas extends ORM{
    private static final String TABLE = "komunitas";
    private String nama_komunitas;
    private String visi;
    private String misi;
    private String deskripsi;
    private String logo;
    private String no_rekening;
    private String status;
    private String create_at;
    private String update_at;
    private int rating;
    private int id;

    public Komunitas(String nama_komunitas, String visi, String misi, String deskripsi, String logo, String no_rekening, String status, String create_at, String update_at, int rating) {
        this.nama_komunitas = nama_komunitas;
        this.visi = visi;
        this.misi = misi;
        this.deskripsi = deskripsi;
        this.logo = logo;
        this.no_rekening = no_rekening;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.rating = rating;
    }

    public Komunitas(String nama_komunitas, int rating, int id) {
        this.nama_komunitas = nama_komunitas;
        this.rating = rating;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_komunitas() {
        return nama_komunitas;
    }

    public void setNama_komunitas(String nama_komunitas) {
        this.nama_komunitas = nama_komunitas;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNo_rekening() {
        return no_rekening;
    }

    public void setNo_rekening(String no_rekening) {
        this.no_rekening = no_rekening;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static ArrayList<Komunitas> getKomuitas(){
        ResultSet resultSet = selectAll(TABLE);
        ArrayList<Komunitas> komunitas = new ArrayList<Komunitas>();
        try {
            while (resultSet.next()){
                String nama_komunitas = resultSet.getString("nama_komunitas");
                int rating = resultSet.getInt("rating");
                int id = resultSet.getInt("id");
                Komunitas komunitas_ = new Komunitas(nama_komunitas, rating, id);
                komunitas.add(komunitas_);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return komunitas;
    }

    public ArrayList<Komunitas> getDetailKomuitas(int id){
        ResultSet resultSet = selectAll(TABLE, String.format("id=%s", id));
        ArrayList<Komunitas> komunitas = new ArrayList<Komunitas>();
        try {
            while (resultSet.next()){
                String nama_komunitas = resultSet.getString("nama_komunitas");
                String visi = resultSet.getString("visi");
                String misi = resultSet.getString("misi");
                String deskripsi = resultSet.getString("deskripsi");
//                Komunitas komunitas_ = new Komunitas(nama_komunitas, visi, misi, deskripsi, logo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return komunitas;
    }

    public static boolean InsertKomunitas(String nama, String visi, String misi, String deskripsi, String logo){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String create_at = format.format(date);
        Map<String, String> data = new HashMap<String, String>();
        data.put("nama_komunitas", "'"+nama+"'");
        data.put("visi", "'"+visi+"'");
        data.put("misi", "'"+misi+"'");
        data.put("deskripsi", "'"+deskripsi+"'");
        data.put("logo", "'"+logo+"'");
        data.put("create_at", "'"+create_at+"'");
        data.put("update_at", "'"+create_at+"'");
        boolean hasil = insert(TABLE, data);
        return hasil;
    }



    public static boolean UpdateKomunitas(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }

    public static boolean UpdateRating(){
        Map<String, String> data = null;
        String value= "";
        boolean hasil = update(TABLE, data, value);
        return hasil;
    }
}
