package Toko;

public class BajuAnak extends Baju {
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

    @Override
    public void displayInfo() {
        System.out.println("Kode: " + getKode() + "\nNama: " + getNama() + "\nHarga: " + getHarga());
        System.out.println("Usia Min: " + usiaMin + "\nUsia Max: " + usiaMax);
    }
}