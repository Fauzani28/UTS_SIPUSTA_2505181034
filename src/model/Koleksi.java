package model;

public abstract class Koleksi {
    private String kode;
    private String judul;
    private int tahunTerbit;
    private boolean sedangDipinjam;

    public Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    public String getKode() { return kode; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
    public boolean isSedangDipinjam() { return sedangDipinjam; }
    public void setSedangDipinjam(boolean v) { this.sedangDipinjam = v; }

    // method abstract aturan kelayakan
    public abstract boolean layakDipinjam();

    // method abstract jenis koleksi (untuk deskripsi)
    public abstract String jenis();

    // method deskripsi memakai super di turunan
    public String deskripsi() {
        return String.format("%-6s | %-35s | %d | %s",
                kode, judul, tahunTerbit, jenis());
    }
}