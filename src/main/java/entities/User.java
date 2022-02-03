package entities;

public class User {

    int id;
    String fname;
    String lname;
    String pw;
    String phone;
    String adress;

    public User(String fname, String lname, String pw, String phone, String adress) {
        this.fname = fname;
        this.lname = lname;
        this.pw = pw;
        this.phone = phone;
        this.adress = adress;
    }

    public User(int id, String fname, String lname, String pw, String phone, String adress) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.pw = pw;
        this.phone = phone;
        this.adress = adress;
    }
}
