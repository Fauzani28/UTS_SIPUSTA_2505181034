package layanan;

import model.Koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi a, Koleksi b) {
        // layak (true) dulu -> false < true, jadi pakai Boolean.compare(b, a)
        int layak = Boolean.compare(b.layakDipinjam(), a.layakDipinjam());
        if (layak != 0) return layak;
        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}