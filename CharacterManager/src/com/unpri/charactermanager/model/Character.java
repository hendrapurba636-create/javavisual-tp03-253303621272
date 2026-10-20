
package com.unpri.charactermanager.model;

import java.util.Objects;

/**
 * Merepresentasikan karakter dalam aplikasi.
 */
public class Character {

    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Menghitung semua objek Character yang dibuat
    private static int totalCharacterCreated = 0;

    // Constructor karakter baru
    public Character(String name, CharacterType type, int level) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter tidak boleh null");
        }
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }

        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Constructor untuk karakter yang sudah memiliki data
    public Character(int id, String name, CharacterType type,
                     int level, int hitPoints, int attackPower) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter tidak boleh null");
        }
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }

        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;

        totalCharacterCreated++;
    }

    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif");
        }

        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Menghitung jumlah objek Character yang telah dibuat
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Dua karakter dianggap sama jika namanya sama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return Objects.equals(this.name, other.name);
    }

    // hashCode harus konsisten dengan equals
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{id=" + id
                + ", name='" + name + '\''
                + ", type=" + type
                + ", level=" + level
                + ", hp=" + hitPoints
                + ", atk=" + attackPower
                + ", mana=" + mana
                + '}';
    }
}
