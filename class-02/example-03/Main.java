class Nasabah {
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

class Tabungan {
    int id;
    Nasabah nasabah;
    double debit;
    double credit;

    public void deposit(int amount) {
        this.debit += amount;
    }

    public double getSaldo() {
        return this.debit - this.credit;
    }

    public String toString() {
        return String.format("Saldo Tn.%s sebesar $%f\n",
            this.nasabah.nama,
            this.getSaldo());
    }
}

public class Main {
    public static void main(String[] args) {
        Nasabah nasabah = new Nasabah(1, "fahmi", "bandung", "08123123");
        nasabah.id = 99;
        nasabah.nama = "fahmi";
        Tabungan tabungan = new Tabungan();
        tabungan.nasabah = nasabah;

        System.out.println(tabungan);
        tabungan.deposit(100);
        System.out.println(tabungan);
    }
}