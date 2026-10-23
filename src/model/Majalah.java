package model;

public class Majalah extends Koleksi implements Terarsip {
    private int edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;
    private String nomorRak;

    public Majalah(String kode, String judul, int tahunTerbit,
                   int edisi, String bulanTerbit, boolean edisiTerbaru,
                   String nomorRak) {
        super(kode, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.nomorRak = nomorRak;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru; // layak kalau BUKAN edisi terbaru
    }

    @Override
    public String jenis() { return "Majalah"; }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public String lokasiLantai() { return "1"; }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + String.format(" | Edisi %d %s | %s | %s",
                edisi, bulanTerbit,
                ringkasanArsip(),
                layakDipinjam() ? "Layak" : "Tidak Layak");
    }
}