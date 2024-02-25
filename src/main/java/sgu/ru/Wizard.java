package main.java.sgu.ru;

public class Wizard extends Character {
    private int mana;

    public Wizard(String name, int health, int damage, int mana) {
        super(name, health, damage);
        this.mana = mana;
    }

    @Override
    public int hashCode() {
        return health + damage * 10 + mana * 100;
    }

    public boolean castSpell(int damage) {
        return mana - damage > 0;
    }

    @Override
    public void get_attacked(Character enemy) {
        super.get_attacked(enemy);

        int spellDamage = enemy.damage % 10;
        if (this.castSpell(spellDamage) && this.health > 0)
        {
            enemy.health -= spellDamage;
            System.out.printf("%s нанёс %d урона в ответ заклинанием %s \n", this.name, spellDamage, enemy.name);
            System.out.printf("У %s осталось очков здоровья %d \n", enemy.name, enemy.health);
        }
    }
}
