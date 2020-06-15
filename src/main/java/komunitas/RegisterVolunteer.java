package komunitas;

public class RegisterVolunteer {
    public void register(){
        boolean insertVolunteer = Volunteer.InsertVolunteer();
        if (insertVolunteer){
            System.out.println("Berhasil");
        }else {
            System.out.println("Gagal");
        }
    }
}
