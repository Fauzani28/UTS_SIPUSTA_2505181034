import model.*;
import layanan.*;
import ekespsi.*;
import utilitas.EksporKatalog;

public class Main {

    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        isiDataUji(katalog);
        cetakStatusAwal(katalog);
        urutkanKatalog(katalog);
        ujiPinjam(katalog);
        eksporKatalog(katalog);
    }

    // ---------- Data Uji ----------
    private static void isiDataUji(KatalogPerpustakaan katalog) {
        katalog.tambah(new BukuCetak(
                "BK-001", "Cara Memahami HTML, CSS, dan JavaScript",
                2022, 620, "A-12", false));
        katalog.tambah(new BukuCetak(
                "BK-002", "Desain Komponen Struktur Beton Bertulang",
                2021, 410, "B-04", true));
        katalog.tambah(new Majalah(
                "MJ-001", "Info Teknologi Edisi 88",
                2026, 88, "Agustus", true, "C-01"));
        katalog.tambah(new Majalah(
                "MJ-002", "Info Teknologi Edisi 87",
                2026, 87, "Juli", false, "C-02"));
        katalog.tambah(new BerkasDigital(
                "BD-001", "Panduan Pemrograman Java",
                2024, 15.0, "unduh.polmed.ac.id/bd001"));
        katalog.tambah(new BerkasDigital(
                "BD-002", "Jurnal Perancangan Perangkat Lunak",
                2025, 8.0, "unduh.polmed.ac.id/bd002"));
    }

    // ---------- Status Awal ----------
    private static void cetakStatusAwal(KatalogPerpustakaan katalog) {
        System.out.println("=== STATUS AWAL ===");
        katalog.cetakStatus();
    }

    // ---------- Urut Katalog ----------
    private static void urutkanKatalog(KatalogPerpustakaan katalog) {
        System.out.println("\n=== SETELAH DIURUT (Layak dulu, lalu Judul) ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();
    }

    // ---------- Uji Pinjam ----------
    private static void ujiPinjam(KatalogPerpustakaan katalog) {
        System.out.println("\n=== UJI PINJAM ===");

        cobaPinjam(katalog, "BK-001"); // sukses
        cobaPinjam(katalog, "BK-002"); // tidak layak (diperbaiki)
        cobaPinjam(katalog, "MJ-001"); // tidak layak (edisi terbaru)
        cobaPinjam(katalog, "BD-001"); // sukses
        cobaPinjam(katalog, "BD-001"); // sedang dipinjam
    }

    private static void cobaPinjam(KatalogPerpustakaan katalog, String kode) {
        try {
            katalog.pinjam(kode);
            System.out.println("Berhasil pinjam: " + kode);
        } catch (PustakaException e) {
            System.out.println("Gagal pinjam " + kode + ": " + e.getMessage());
        }
    }

    // ---------- Ekspor ----------
    private static void eksporKatalog(KatalogPerpustakaan katalog) {
        System.out.println("\n=== EKSPOR KATALOG ===");
        EksporKatalog.ekspor(katalog.getDaftar(), "katalog.txt");
        System.out.println("Katalog diekspor ke katalog.txt");
    }
}