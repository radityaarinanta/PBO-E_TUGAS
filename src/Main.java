import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nim, username, password;
        int pilihan;

        do {
            System.out.println("====== Library System ======");
            System.out.println("1. Login Sebagai Mahasiswa");
            System.out.println("2. Login Sebagai Admin");
            System.out.println("3. Exit");
            System.out.print("Pilih Opsi (1-3): ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukan NIM : ");
                    nim = input.next();
                    if (nim.length() == 15) {
                        System.out.println("Successfull Login As Student!! ");
                    } else {
                        System.out.println("User Not Found!!");
                    }
                    break;
                case 2:
                    System.out.print("Masukan Username (admin) : ");
                    username = input.next();
                    System.out.print("Masukan Password (admin) : ");
                    password = input.next();
                    if (username.equals("admin") && password.equals("admin")) {
                        System.out.println("Succesfull Login As Admin!!");
                    } else {
                        System.out.println("Admin User Not Found!!");
                    }
                    break;
                case 3:
                    System.out.println("Terima Kasih!!!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!!\nPilih Nomor (1-3) !!!");
            }
        } while (pilihan != 3);

        input.close();
    }
}