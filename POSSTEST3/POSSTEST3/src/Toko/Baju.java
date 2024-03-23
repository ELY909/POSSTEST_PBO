package Toko;

public class Baju {
    private String kode;
    private String nama;
    private int harga;

    public Baju(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}

class BajuAnak extends Baju {
    private int usiaMin;
    private int usiaMax;

    public BajuAnak(String kode, String nama, int harga, int usiaMin, int usiaMax) {
        super(kode, nama, harga);
        this.usiaMin = usiaMin;
        this.usiaMax = usiaMax;
    }

    public int getUsiaMin() {
        return usiaMin;
    }

    public int getUsiaMax() {
        return usiaMax;
    }

    public void setUsiaMin(int usiaMin) {
        this.usiaMin = usiaMin;
    }

    public void setUsiaMax(int usiaMax) {
        this.usiaMax = usiaMax;
    }
}