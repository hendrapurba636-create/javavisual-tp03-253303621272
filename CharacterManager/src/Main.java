
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== CHARACTER MANAGER TP5 ===");

        CharacterManager manager = new CharacterManager();

        // A. Menambahkan karakter
        Character arjuna = new Character(
                "Arjuna", CharacterType.WARRIOR, 5);

        Character merlin = new Character(
                "Merlin", CharacterType.MAGE, 3);

        Character athena = new Character(
                "Athena", CharacterType.ARCHER, 4);

        System.out.println("\n--- A. Menambahkan Karakter ---");
        System.out.println("Arjuna ditambahkan: "
                + manager.addCharacter(arjuna));
        System.out.println("Merlin ditambahkan: "
                + manager.addCharacter(merlin));
        System.out.println("Athena ditambahkan: "
                + manager.addCharacter(athena));

        // A. Menguji penolakan nama duplikat
        Character arjunaDuplikat = new Character(
                "Arjuna", CharacterType.MAGE, 2);

        System.out.println("Arjuna duplikat ditambahkan: "
                + manager.addCharacter(arjunaDuplikat));
        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        // A. Mencari karakter berdasarkan nama
        System.out.println("\n--- Pencarian Nama ---");
        Character hasilCari = manager.findByName("Merlin");

        if (hasilCari != null) {
            System.out.println("Karakter ditemukan: " + hasilCari);
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }

        // B. Menghitung rata-rata level
        System.out.println("\n--- B. Rata-rata Level ---");
        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // B. Mencari karakter berdasarkan tipe
        System.out.println("\n--- Pencarian Berdasarkan Tipe ---");
        ArrayList<Character> warriors =
                manager.findByType(CharacterType.WARRIOR);

        for (Character character : warriors) {
            System.out.println(character);
        }

        // C. Fitur tambahan: menghitung karakter berdasarkan tipe
        System.out.println("\n--- C. Count By Type ---");
        System.out.println("Jumlah WARRIOR: "
                + manager.countByType(CharacterType.WARRIOR));
        System.out.println("Jumlah MAGE: "
                + manager.countByType(CharacterType.MAGE));

        // A. Menguji salinan daftar
        System.out.println("\n--- Eksperimen Defensive Copy ---");
        ArrayList<Character> salinan = manager.getAllCharacters();

        System.out.println("Jumlah daftar asli sebelum clear: "
                + manager.getTotalCharacters());

        salinan.clear();

        System.out.println("Jumlah daftar salinan setelah clear: "
                + salinan.size());
        System.out.println("Jumlah daftar asli setelah clear: "
                + manager.getTotalCharacters());

        // A. Menghapus karakter
        System.out.println("\n--- Menghapus Karakter ---");
        System.out.println("Arjuna berhasil dihapus: "
                + manager.removeCharacter("Arjuna"));
        System.out.println("Total setelah penghapusan: "
                + manager.getTotalCharacters());

        // Menguji rata-rata saat daftar kosong
        System.out.println("\n--- Rata-rata Daftar Kosong ---");
        manager.removeCharacter("Merlin");
        manager.removeCharacter("Athena");

        System.out.println("Total karakter: "
                + manager.getTotalCharacters());
        System.out.println("Rata-rata level saat kosong: "
                + manager.getAverageLevel());

        // Menguji reference dan static
        System.out.println("\n--- Eksperimen Reference ---");
        Character a = new Character(
                "Bima", CharacterType.WARRIOR, 3);

        Character b = a;
        b.setLevel(8);

        System.out.println("Level a setelah level b diubah: "
                + a.getLevel());
        System.out.println("a == b: " + (a == b));

        Character c = new Character(
                a.getName(), a.getType(), a.getLevel());

        System.out.println("a == c: " + (a == c));
        System.out.println("a.equals(c): " + a.equals(c));

        System.out.println("Total objek Character yang dibuat: "
                + Character.getTotalCharacterCreated());

        // Menguji equals
        System.out.println("\n--- Pengujian equals ---");
        System.out.println("Nama a dan c sama: " + a.equals(c));

        System.out.println("\n=== PROGRAM SELESAI ===");
    }
}
