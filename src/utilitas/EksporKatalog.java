package utilitas;

import model.Koleksi;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EksporKatalog {
    public static void ekspor(List<Koleksi> daftar, String path) {
        // try-with-resources -> aliran otomatis ditutup
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(String.format("%-8s | %-35s | %-6s | %-12s | %-10s%n",
                    "KODE", "JUDUL", "TAHUN", "JENIS", "STATUS"));
            bw.write("-".repeat(90));
            bw.newLine();
            for (Koleksi k : daftar) {
                bw.write(String.format("%-8s | %-35s | %-6d | %-12s | %-10s%n",
                        k.getKode(), k.getJudul(), k.getTahunTerbit(),
                        k.jenis(),
                        k.layakDipinjam() ? "Layak" : "Tidak"));
            }
            System.out.println("Katalog berhasil diekspor ke " + path);
        } catch (IOException e) {
            System.err.println("Gagal menulis berkas: " + e.getMessage());
        }
    }
}