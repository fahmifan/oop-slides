package bank;

public class Bank {
    int tabunganCount = 0;
    public Tabungan[] listTabungan = new Tabungan[5];

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
