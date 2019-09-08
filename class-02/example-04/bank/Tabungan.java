package bank;

public class Tabungan {
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