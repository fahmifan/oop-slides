import bank.Tabungan;
import bank.Bank;
import bank.Nasabah;

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