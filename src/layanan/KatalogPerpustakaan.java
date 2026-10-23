package layanan;

import model.Koleksi;
import ekespsi.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi k) { daftar.add(k); }

    public List<Koleksi> getDaftar() { return daftar; }

    // Soal 3: polimorfik TANPA instanceof
    public void cetakStatus() {
        System.out.println("=== STATUS KATALOG ===");
        for (Koleksi k : daftar) {
            System.out.println(k.deskripsi());
        }
        System.out.println();
    }

    // Soal 4: urut dengan Comparator dari luar
    public void urut(Comparator<Koleksi> comparator) {
        daftar.sort(comparator);
    }

    // Soal 5: method pinjam melempar eksepsi
    public void pinjam(String kode) throws PustakaException {
        Koleksi target = null;
        for (Koleksi k : daftar) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                target = k;
                break;
            }
        }
        if (target == null) {
            throw new PustakaException("Koleksi dengan kode " + kode + " tidak ditemukan.");
        }
        if (target.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                    "Maaf, koleksi \"" + target.getJudul() + "\" sedang dipinjam orang lain.");
        }
        if (!target.layakDipinjam()) {
            throw new KoleksiTidakLayakException(
                    "Maaf, koleksi \"" + target.getJudul() + "\" belum bisa dipinjam saat ini.");
        }
        target.setSedangDipinjam(true);
        System.out.println("Berhasil meminjam: " + target.getJudul());
    }
}