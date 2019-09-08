## Pertemuan 2

* String method
* Enkapsulasi
* UML
* package

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

## Class: method
Class dapat memiliki method sendiri yang melekat pada class itu. 
Tambahkan method `deposit` & `getSaldo` berikut.
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