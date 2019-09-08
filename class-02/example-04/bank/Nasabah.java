package bank;

public class Nasabah {
    int id;
    String nama;
    String alamat;
    String telp;

    // Constructor adalah method khusus 
    // yang dapat dipanggil ketika instansiasi class
    public Nasabah(int id, String nama, String alamat, String telp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
    }
}

