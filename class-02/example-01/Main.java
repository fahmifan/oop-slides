public class Main {
    public static void main(String[] args) {
        String nama = new String("miun");

        System.out.println(">>>>> membandingkan object >>>>>");
        System.out.println(nama == "miun" ? "true" : "false");
        System.out.println(nama.equals("miun") ? "true" : "false");


        System.out.println("\n>>>>> kalau ini bisa >>>>>");
        String nama2 = "miun";
        System.out.println(nama2 == "miun" ? "true" : "false");

    }
}