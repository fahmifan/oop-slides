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

    public Tabungan(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

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
        Tabungan[] manyTabungan = new Tabungan[5];

        Nasabah nasabah = new Nasabah(1, "fahmi", "bandung", "08123123");
        Tabungan tabungan = new Tabungan(nasabah);
        System.out.println(tabungan);

        tabungan.deposit(100);
        manyTabungan[0] = tabungan;

        System.out.println(manyTabungan[0]);

        manyTabungan[1] = new Tabungan(new Nasabah(2, "vega", "aceh", "08123123"));
        manyTabungan[2] = new Tabungan(new Nasabah(3, "argil", "bandung", "08123123"));

        System.out.println(manyTabungan[1]);
        System.out.println(manyTabungan[2]);
    }
}