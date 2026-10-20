package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola daftar karakter dan menyediakan fitur pencarian.
 */
public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    /**
     * Menambahkan karakter jika namanya belum terdaftar.
     * @return true jika berhasil ditambahkan.
     */
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (characters.contains(character)) {
            return false;
        }

        characters.add(character);
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     */
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equals(name)) {
                return character;
            }
        }

        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama.
     * @return true jika karakter berhasil dihapus.
     */
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        return characters.remove(character);
    }

    /**
     * Mengembalikan jumlah karakter yang tersimpan.
     */
    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Mengembalikan salinan daftar, bukan daftar aslinya.
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    /**
     * Menghitung rata-rata level karakter.
     */
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    /**
     * Mencari semua karakter berdasarkan tipe.
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Fitur tambahan: menghitung jumlah karakter berdasarkan tipe.
     */
    public int countByType(CharacterType type) {
        int count = 0;

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}