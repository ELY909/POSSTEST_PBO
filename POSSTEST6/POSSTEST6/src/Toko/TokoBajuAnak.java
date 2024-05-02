package Toko;

import java.util.ArrayList;
import java.util.Scanner;

// Interface Transaksi
interface Transaksi {
    void prosesTransaksi();
    void batalkanTransaksi();
}

// Interface Pembayaran
interface Pembayaran {
    void prosesPembayaran();
    void batalPembayaran();
}

public class TokoBajuAnak implements Transaksi, Pembayaran {
    static final ArrayList<Baju> daftarBaju = new ArrayList<>();
    static final ArrayList<Baju> daftarBajuPemesanan = new ArrayList<>(); // Daftar baju yang dipesan
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuUtama();
    }

    static void tambahBajuBaru() {
        System.out.println("\n======== Tambah baju ke dalam toko Pa Fakhri ========");
        System.out.print("Masukkan kode baju : ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama baju : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga baju : ");
        int harga = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan usia minimal: ");
        int usiaMin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan usia maksimal: ");
        int usiaMax = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=====================================================");

        BajuAnak baju = new BajuAnak(kode, nama, harga, usiaMin, usiaMax);
        daftarBaju.add(baju);
        System.out.println("Baju berhasil ditambahkan ke toko.");
    }

    static void pesanBajuBaru() {
        System.out.println("\n======== Pesan baju dari Toko Pa Fakhri ========");
        System.out.print("Masukkan kode baju yang ingin dipesan: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama baju yang ingin dipesan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga baju yang ingin dipesan: ");
        int harga = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan usia minimal yang diinginkan: ");
        int usiaMin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan usia maksimal yang diinginkan: ");
        int usiaMax = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=====================================================");

        BajuAnak baju = new BajuAnak(kode, nama, harga, usiaMin, usiaMax);
        daftarBajuPemesanan.add(baju);
        System.out.println("Baju berhasil dipesan dari toko.");
    }

    static void lihatDaftarBaju() {
        System.out.println("\n============ Daftar Baju Toko Pa Fakhri (Milik Pemilik) ============");
        if (daftarBaju.isEmpty()) {
            System.out.println("Daftar baju kosong.");
        } else {
            for (Baju baju : daftarBaju) {
                baju.displayInfo();
                System.out.println();
            }
        }
    }

    static void lihatDaftarBajuPemesanan() {
        System.out.println("\n============ Daftar Baju yang Dipesan (Untuk Pemesanan) ============");
        if (daftarBajuPemesanan.isEmpty()) {
            System.out.println("Belum ada baju yang dipesan.");
        } else {
            for (Baju baju : daftarBajuPemesanan) {
                baju.displayInfo();
                System.out.println();
            }
        }
    }

    static void ubahInformasiBaju() {
        System.out.println("\n======= Ubah Informasi Baju (Milik Pemilik) =======");
        System.out.print("Masukkan kode baju yang ingin diubah: ");
        String kode = scanner.nextLine();
        System.out.println("===================================================");

        boolean ditemukan = false;
        for (Baju baju : daftarBaju) {
            if (baju.getKode().equals(kode)) {
                System.out.print("Masukkan nama baru: ");
                String namaBaru = scanner.nextLine();
                System.out.print("Masukkan harga baru: ");
                int hargaBaru = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan usia minimal baru: ");
                int usiaMinBaru = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan usia maksimal baru: ");
                int usiaMaxBaru = scanner.nextInt();
                scanner.nextLine();

                ((BajuAnak) baju).setNama(namaBaru);
                ((BajuAnak) baju).setHarga(hargaBaru);
                ((BajuAnak) baju).setUsiaMin(usiaMinBaru);
                ((BajuAnak) baju).setUsiaMax(usiaMaxBaru);
                ditemukan = true;
                System.out.println("Informasi baju berhasil diubah.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Baju dengan kode tersebut tidak ditemukan di toko.");
        }
    }

    static void sumbangBaju() {
        System.out.println("\n================== Menyumbangkan Baju (Milik Pemilik) =================");
        System.out.print("Masukkan kode baju yang ingin disumbangkan ke panti: ");
        String kode = scanner.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < daftarBaju.size(); i++) {
            if (daftarBaju.get(i).getKode().equals(kode)) {
                daftarBaju.remove(i);
                ditemukan = true;
                System.out.println("Baju sudah disumbangkan.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Baju dengan kode tersebut tidak ditemukan di toko.");
        }
    }

    static void batalkanPemesananBaju() {
        System.out.println("\n======== Batalkan Pemesanan Baju (Untuk Pemesanan) =======");
        System.out.print("Masukkan kode baju yang ingin dibatalkan pesanannya: ");
        String kode = scanner.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < daftarBajuPemesanan.size(); i++) {
            if (daftarBajuPemesanan.get(i).getKode().equals(kode)) {
                daftarBajuPemesanan.remove(i);
                ditemukan = true;
                System.out.println("Pemesanan baju dengan kode " + kode + " berhasil dibatalkan.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Baju dengan kode tersebut tidak ditemukan dalam daftar pemesanan.");
        }
    }

    static void menuUtama() {
        int pilihan;
        do {
            System.out.println("\n========== Toko Baju Anak - Anak Pa Fakhri ========== ");
            System.out.println("  1. Tambah Baju Baru (Milik Pemilik)");
            System.out.println("  2. Pesan Baju (Untuk Pemesanan)");
            System.out.println("  3. Lihat Daftar Baju (Milik Pemilik)");
            System.out.println("  4. Lihat Daftar Baju yang Dipesan");
            System.out.println("  5. Ubah Informasi Baju (Milik Pemilik)");
            System.out.println("  6. Sumbang Baju (Milik Pemilik)");
            System.out.println("  7. Batalkan Pemesanan Baju (Untuk Pemesanan)");
            System.out.println("  8. Keluar");
            System.out.println("=====================================================");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahBajuBaru();
                    break;
                case 2:
                    pesanBajuBaru();
                    break;
                case 3:
                    lihatDaftarBaju();
                    break;
                case 4:
                    lihatDaftarBajuPemesanan();
                    break;
                case 5:
                    ubahInformasiBaju();
                    break;
                case 6:
                    sumbangBaju();
                    break;
                case 7:
                    batalkanPemesananBaju();
                    break;
                case 8:
                    System.out.println("Terima kasih telah berkunjung ke Toko Pa Fakhri.");
                    break;
                default:
                    System.out.println("Pilihan tidak ada. Silakan pilih kembali.");
            }
        } while (pilihan != 8);
    }

    @Override
    public void prosesTransaksi() {
        System.out.println("Proses pemesanan sedang berjalan...");
    }

    @Override
    public void batalkanTransaksi() {
        System.out.println("Pemesanan dibatalkan.");
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Proses pembayaran sedang berjalan...");
    }

    @Override
    public void batalPembayaran() {
        System.out.println("Pembayaran dibatalkan.");
    }

    public static boolean validasiUsia(int usiaMin, int usiaMax) {
        return usiaMin >= 0 && usiaMax >= usiaMin;
    }

    private static int totalTransaksi = 0; // Variabel static untuk menyimpan total transaksi

    public static void tambahTotalTransaksi(int jumlah) {
        totalTransaksi += jumlah;
    }

    public static int getTotalTransaksi() {
        return totalTransaksi;
    }
}
