## Pertemuan 2

* String method
* Class
    * Enkapsulasi

---

## String Method: Equals
String equal digunakan untuk membandingkan apakah dua object itu sama.
Meskipun pada String jika diberi value dengan string literal, maka bisa 
langsung dibandingkan dengan string literal lain.

---

## String Method: Equals

```java
// dibeari value object (instansiasi)
String nama = new String("fahmi");
System.out.println(">>>>> membandingkan object >>>>>");
System.out.println(nama == "fahmi" ? "true" : "false"); // false
System.out.println(nama.equals("fahmi") ? "true" : "false"); // true

// dibeari value string literal
String nama2 = "fahmi";
System.out.println("\n>>>>> kalau ini bisa >>>>>");
System.out.println(nama2 == "fahmi" ? "true" : "false"); // true
```

---

## String Method: Concat
String concat me-return hasil gabungan string awal dengan yang diconcat
```java
String nama = "miun";
String concat = nama.concat("173");

System.out.println(concat); // miun173
``` 

---

## Class
Class adalah konsep utama dari OOP pada java. Mirip dengan struct pada C, 
class juga dapat diapakai sebagai penampung nilai.

---

## Class: atribut
```java
class Nasabah {
    int id;
    String nama;
    String alamat;
    String telp;
}

class Tabungan {
    int id;
    Nasabah nasabah;
    double debit;
    double credit;
}

public class Main {

    public static void main(String[] args) {
        Nasabah nasabah = new Nasabah();
        nasabah.id = 99;
        nasabah.nama = "fahmi";
        Tabungan tabungan = new Tabungan();
        tabungan.nasabah = nasabah;

        System.out.printf("Saldo Tn.%s sebesar $%f\n", 
            tabungan.nasabah.nama, 
            tabungan.debit);
    }
}
```

---

## Class: Method
Class dapat memiliki method sendiri yang melekat pada class itu. 
Tambahkan method `deposit` & `getSaldo` berikut.

fyi: pada akutansi, saldo itu adalah semua deposit dikurang semua credit yang kita punya.

---

## Class: Method
```java
class Tabungan {
    ...
    public void deposit(int amount) {
        this.debit += amount;
    }

    public double getSaldo() {
        return this.debit - this.credit;
    }
}

public class Main {
    public static void main(String[] args) {
        ...
        System.out.printf("Saldo Tn.%s sebesar $%f\n", tabungan.nasabah.nama, tabungan.getSaldo());
        tabungan.deposit(100);
        System.out.printf("Saldo Tn.%s sebesar $%f\n", tabungan.nasabah.nama, tabungan.getSaldo());
    }
}


```

---

## Class: toString
Class memiliki method khusus bernama `toString` 
yg dapat memformat output class tersebut jika diprint ke console

---

## Class: toString
```java
class Tabungan {
    ...
    public String toString() {
        return String.format("Saldo Tn.%s sebesar $%f\n",
            this.nasabah.nama,
            this.getSaldo());
    }
}


public class Main {
    public static void main(String[] args) {
        ...
        System.out.println(tabungan);
        tabungan.deposit(100);
        System.out.println(tabungan);
    }
}

```

---

## Class: Constructor
Method khusus lain pada class adalah Constructor. Method ini memiliki nama yang sama dengan nama class.
Method ini yang digunakan ketika instansiasi

---

## Class: Constructor
```java
class Nasabah {
    ...
    public Nasabah(int id, String nama, String alamat, String telp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
    }
}

public class Main {
    public static void main(String[] args) {
        Nasabah nasabah = new Nasabah(1, "fahmi", "bandung", "08123123");
        Tabungan tabungan = new Tabungan();
        tabungan.nasabah = nasabah;

        System.out.println(tabungan);
        tabungan.deposit(100);
        System.out.println(tabungan);
    }
}
```
---

## Class: Constructor: refactor
```java
class Nasabah {
    ...
    public Nasabah(int id, String nama, String alamat, String telp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
    }
}

class Tabungan {
    ...
    public Tabungan(Nasabah nasabah) {
        this.nasabah = nasabah;
    }
    ...
}

public class Main {
    public static void main(String[] args) {
        Nasabah nasabah = new Nasabah(1, "fahmi", "bandung", "08123123");
        Tabungan tabungan = new Tabungan(nasabah);

        System.out.println(tabungan);
        tabungan.deposit(100);
        System.out.println(tabungan);
    }
}
```

---

## Class: Array of Class
Misalkan kita membuat aplikasi Bank, tentunya akan ada banyak nasabah.
Pada struktur data, kita mengenal namanya array, kita dapat menyimpan nasabah2 itu kedalam array

---

## Class: Array of Class
```java
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
```
---

## Class: Array of Class: refactor
Mari kita coba buat class Bank yang akan memuat Array of Tabungan
```java
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
    }
}
```
---

## Class: Access Modifier
Pada saat kita menarik uang dari tabungan, tentu tidak boleh melebihi saldo yang ada bukan?
Agar itu bisa terjadi, kita perlu membuat atribute credit tidak bisa ditambah.
Pada java terdapat fitur access modifier yang dapat digunakan pada kasus ini.

---

## Class: Access Modifier
Modifier    |	Class   |   Package |	Subclass    |	World
--          | --        | --        | --            |---
public      | Y	        | Y         | Y             | Y
protected   | Y         | Y         | Y             | N
no modifier	| Y         | Y         | N             | N
private     | Y         | N         | N             | N

---

## Class: Access Modifier
```java
class Tabungan {
    ...
    private double debit;
    private double credit;

    ...
    // withdraw will increase the credit amount & return boolean
    // success will return true else return false
    public boolean withdraw(int amount) {
        if (this.getSaldo() > amount) {
            this.credit += amount;
            return true;
        }

        return false;
    }
    ...
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


```