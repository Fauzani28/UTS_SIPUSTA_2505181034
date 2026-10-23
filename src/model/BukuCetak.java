package model;

public class BukuCetak extends Koleksi implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit,
                     int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String jenis() { return "BukuCetak"; }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public String lokasiLantai() { return "2"; } // lantai buku cetak

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + String.format(" | %d hlm | %s | %s",
                jumlahHalaman,
                ringkasanArsip(),
                layakDipinjam() ? "Layak" : "Tidak Layak");
    }
}