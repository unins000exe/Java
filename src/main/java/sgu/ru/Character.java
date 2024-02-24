package main.java.sgu.ru;

public abstract class Character {
    private int health;
    private int damage;
    private int level;
    public String name;

    public Character(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public abstract void attack();
}
