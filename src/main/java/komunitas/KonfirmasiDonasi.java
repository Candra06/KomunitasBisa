package komunitas;

public class KonfirmasiDonasi {
    public void konfirmasi(){
        boolean konfirmasiDonasi = Donasi.UpdateDonasi();
        if (konfirmasiDonasi){
            System.out.println("Berhasil");
        }else {
            System.out.println("Gagal");
        }
    }
}
