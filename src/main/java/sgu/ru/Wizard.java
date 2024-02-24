package main.java.sgu.ru;

public class Wizard extends Character {
    private int mana;

    public Wizard(int health, int damage, int mana) {
        super(health, damage);
        this.mana = mana;
    }

    public void castSpell() {
    }

    @Override
    public void attack() {
        castSpell();
    }

}
