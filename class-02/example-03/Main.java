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
    private double debit;
    private double credit;

    public Tabungan(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public void deposit(int amount) {
        this.debit += amount;
    }

    // withdraw will increase the credit amount & return boolean
    // success will return true else return false
    public boolean withdraw(int amount) {
        if (this.getSaldo() > amount) {
            this.credit += amount;
            return true;
        }

        return false;
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

class Bank {
    int tabunganCount = 0;
    Tabungan[] listTabungan = new Tabungan[5];

    public void addTabungan(Tabungan tb) {
        this.listTabungan[this.tabunganCount] = tb;
        this.tabunganCount++;
    }

    public String toString() {
        String fmt = "";
        for (int i = 0; i < this.tabunganCount; i++) {
            Tabungan tb = this.listTabungan[i]; 
            fmt = fmt.concat(tb.toString());
        }

        return fmt;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addTabungan(new Tabungan(new Nasabah(1, "Eko", "bandung", "08123123")));
        bank.addTabungan(new Tabungan(new Nasabah(2, "Fajar", "bandung", "08123123")));
        bank.addTabungan(new Tabungan(new Nasabah(3, "Putra", "bandung", "08123123")));
        System.out.println(bank);

        bank.listTabungan[0].deposit(100);
        System.out.println(bank);
        boolean ok = bank.listTabungan[0].withdraw(200);
        if (!ok) {
            System.err.println("failed to withdraw");
        }

        ok = bank.listTabungan[0].withdraw(90);
        if (ok) {
            System.out.printf("success withdraw $%d\n", 90);
        }
        System.out.println(bank);

    }
}