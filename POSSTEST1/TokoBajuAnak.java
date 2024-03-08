import java.util.ArrayList;
import java.util.Scanner;

class Baju {
    String kode;
    String nama;
    int harga;

    public Baju(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }
}

public class TokoBajuAnak {
    static ArrayList<Baju> daftarBaju = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuUtama();
    }

    static void tambahBajuBaru() {
        System.out.println("\n======== Tambah baju ke dalam toko Pa Fakhri ========");
        System.out.print("                Masukkan kode baju : ");
        String kode = scanner.nextLine();
        System.out.print("                Masukkan nama baju : ");
        String nama = scanner.nextLine();
        System.out.print("                Masukkan harga baju : ");
        int harga = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("=====================================================");

        Baju baju = new Baju(kode, nama, harga);
        daftarBaju.add(baju);
        System.out.println(" baju berhasil ditambahkan ke toko");
    }

    static void lihatDaftarBaju() {
        System.out.println("\n============ Daftar Baju Toko Pa fakhri =============");
        if (daftarBaju.isEmpty()) {
            System.out.println("               Belum ada baju di toko");
            System.out.println("=====================================================");
        } else {
            for (Baju baju : daftarBaju) {
                System.out.println("Kode: " + baju.kode + ", Nama: " + baju.nama + ", Harga: " + baju.harga);
            }
        }
    }

    static void ubahInformasiBaju() {
        System.out.println("\n======= Ubah Baju tidak layak jual dengan baru ======");
        System.out.print("        Masukkan kode baju yang ingin diubah: ");
        String kode = scanner.nextLine();
        System.out.println("=====================================================");
        boolean ditemukan = false;

        for (Baju baju : daftarBaju) {
            if (baju.kode.equals(kode)) {
                System.out.print("Masukkan nama baru: ");
                String namaBaru = scanner.nextLine();
                System.out.print("Masukkan harga baru: ");
                int hargaBaru = scanner.nextInt();
                scanner.nextLine();

                baju.nama = namaBaru;
                baju.harga = hargaBaru;
                ditemukan = true;
                System.out.println("baju berhasil disimpankan ke toko.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("baju kode tersebut tidak ditemukan di toko.");
        }
    }

    static void sumbangBaju() {
        System.out.println("\n================== Menyumbangkan Baju ==================");
        System.out.print(" Masukkan kode baju yang ingin disumbangkan ke panti: ");
        String kode = scanner.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < daftarBaju.size(); i++) {
            if (daftarBaju.get(i).kode.equals(kode)) {
                daftarBaju.remove(i);
                ditemukan = true;
                System.out.println(" baju sudah disumbangkan.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("baju dengan kode tersebut tidak ditemukan di toko.");
        }
    }

    static void menuUtama() {
        int pilihan;
        do {
            System.out.println("\n========== Toko Baju Anak - Anak Pa Fakhri ========== ");
            System.out.println("                1. Tambah Baju Baru :                   ");
            System.out.println("                2. Lihat Daftar Baju :                  ");
            System.out.println("                3. Ubah Informasi Baju (ubah data)       ");
            System.out.println("                4. Sumbang Baju (hapus) :               ");
            System.out.println("                5. Keluar                               ");
            System.out.println("=====================================================");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahBajuBaru();
                    break;
                case 2:
                    lihatDaftarBaju();
                    break;
                case 3:
                    ubahInformasiBaju();
                    break;
                case 4:
                    sumbangBaju();
                    break;
                case 5:
                    System.out.println("Terima kasih telah Berkunjung Ke toko Pa Fakhri.");
                    break;
                default:
                    System.out.println("Pilihan tidak ada. Silakan pilih kembali.");
            }
        } while (pilihan != 5);
    }
}
