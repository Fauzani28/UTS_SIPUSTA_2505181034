package model;

public class BerkasDigital extends Koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit,
                         double ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean layakDipinjam() { return true; } // selalu layak

    @Override
    public String jenis() { return "BerkasDigital"; }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + String.format(" | %.1f MB | %s | %s",
                ukuranMB, tautanUnduh,
                layakDipinjam() ? "Layak" : "Tidak Layak");
    }
}