import java.util.ArrayList;
import java.util.Scanner;

class User {
    String Nama;
    String Fakultas;
    String Prodi;
    String nim;

    User(String nama, String Fakultas, String Prodi, String nim) {
        this.Nama = nama;
        this.Fakultas = Fakultas;
        this.Prodi = Prodi;
        this.nim = nim;
    }
}

class Book {
    int stokBuku;
    String author;
    String idBuku;
    String judul;
    String kategori;

    Book(int stokBuku, String author, String idBuku, String judul, String kategori) {
        this.stokBuku = stokBuku;
        this.author = author;
        this.idBuku = idBuku;
        this.judul = judul;
        this.kategori = kategori;
    }
}

public class Main {
    static ArrayList<User> userStudent = new ArrayList<>();
    static ArrayList<Book> bookList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main list = new Main();
        userStudent.add(new User("Radit", "Teknik", "Informatika", "202310370311224"));
        userStudent.add(new User("Adi", "Teknik", "sipil", "202310370311221"));
        userStudent.add(new User("Rifqi", "Teknik", "Informatika", "202310370311252"));

        bookList.add(new Book(2, "Mohan", "e466-u888-k999", "Panduan sholat", "Keagamaan"));
        bookList.add(new Book(3, "Tantra", "e455-988b-c355", "Panduan mengaji", "keagamaan"));
        bookList.add(new Book(9, "Ari", "k444-o099-p877", "panduan Haji", "kegamaan"));

        list.Menu();
    }

    void Menu() {
        String nim;
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
                    if (checkNim(nim)) {
                        menuStudent();
                    }else{
                    System.out.println("User tidak ditemukan");
                    }
                    break;
                case 2:
                    loginAdmin();
                    break;
                case 3:
                    System.exit(0);
                    System.out.println("Terima Kasih!!!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!!\nPilih Nomor (1-3) !!!");
            }
        } while (pilihan != 3);

       
    }

    boolean checkNim(String nomor) {
        for (User student : userStudent) {
            if (student.nim.equals(nomor)) {
                return true;
            }
        }
        return false;
    }

    void menuStudent() {
        Student siswa = new Student();
        int pilihan;
        do {
            System.out.println("====== Student menu ======");
            System.out.println("1. Buku Terpinjam");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Logout");
            System.out.print("Pilih Opsi (1-3): ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    // buku terpinjam
                    break;
                case 2:
                    siswa.displayBooks();
                    System.out.println("\nInput ID Buku yang Ingin diPinjam (Ketik 99 Untuk Kembali ke-Menu Awal)");
                    System.out.print("Input : "); 
                    String id = input.next();
                   
                    if (id.equals("99")) {
                        System.out.println("Kembali ke Menu Awal...");
                        menuStudent();                        
                    }
                    break;
                case 3:
                    Menu();
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!!\nPilih Nomor (1-3) !!!");
            }
        } while (pilihan != 3);

        input.close();
    }

    static void loginAdmin() {
        System.out.print("Masukan Username (admin) : ");
        String username = input.next();
        input.nextLine();
        System.out.print("Masukan Password (admin) : ");
        String pw = input.next();

        if (username.equals("admin") && pw.equals("admin")) {
            menuAdmin();
        } else {
            System.out.println("Admin User Not Found!!");
        }
    }

    static void menuAdmin() {
        Admin admin = new Admin();
        int pilihan;
        do {
            System.out.println("===== Dashboard Admin =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilih Opsi (1-3): ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.displayStudent();
                    break;
                case 3:
                    System.out.println("System Logout...");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!!\nPilih Nomor (1-3) !!!");
            }
        } while (pilihan != 3);
        System.out.println("");
    }
}

class Student {
    void displayBooks() {
        for (Book namaBuku : Main.bookList) {
            System.out.print( "\nDaftar buku\n");
            System.out.println("id buku     :" + namaBuku.idBuku);
            System.out.println("nama buku   :" + namaBuku.judul);
            System.out.println("author      :" + namaBuku.author);
            System.out.println("kategori    :" + namaBuku.kategori);
            System.out.println("stok        :" + namaBuku.stokBuku);
        }
    }
}

class Admin {
    Scanner Input = new Scanner(System.in);
    String nama;
    String nim;
    String fakultas;
    String prodi;

    void addStudent() {
        System.out.print("Nama     : ");
        nama = Input.nextLine();
        do {
            System.out.print("NIM      : ");
            nim = Input.next();
            if (nim.length() != 15)
                System.out.println("NIM harus 15 digit !!!");
        } while (nim.length() != 15);
        System.out.print("Fakultas : ");
        fakultas = Input.next();
        System.out.print("Prodi    : ");
        prodi = Input.next();

        // Program untuk tambah mahasiswa
        // User mahasiswa = new User(nama, nim, fakultas, prodi);
        // Code tambah mahasiswa
    }

    void displayStudent() {
        System.out.println("===== Daftar Mahasiswa =====");
        for (User mahasiswa : Main.userStudent) {
            System.out.println("Nama     : " + mahasiswa.Nama);
            System.out.println("NIM      : " + mahasiswa.nim);
            System.out.println("Fakultas : " + mahasiswa.Fakultas);
            System.out.println("Prodi    : " + mahasiswa.Prodi);
            System.out.println("---------------------------------");
        }
    }
}
