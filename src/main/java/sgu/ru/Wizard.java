package main.java.sgu.ru;

public class Wizard extends Character {
    private int mana;

    public Wizard(int id, String name, int health, int damage, int mana) {
        super(id, name, health, damage);
        this.mana = mana;
    }

    public boolean castSpell(int damage) {
        return mana - damage > 0;
    }

    public boolean equals(Wizard other)
    {
        if (this.health != other.health)
            return false;

        if (this.damage != other.damage)
            return false;

        if (this.mana != other.mana)
            return false;

        return true;
    }

    public String toString()
    {
        return this.name + " {" + Integer.toString(this.health) + ", "
                + Integer.toString(this.damage) + ", "
                + Integer.toString(this.mana) + "}";
    }

    @Override
    public void getAttacked(Character enemy) {
        super.getAttacked(enemy);

        int spellDamage = enemy.damage % 10;
        if (this.castSpell(spellDamage) && this.health > 0)
        {
            enemy.health -= spellDamage;
            System.out.printf("%s нанёс %d урона в ответ заклинанием %s \n", this.name, spellDamage, enemy.name);
            System.out.printf("У %s осталось очков здоровья %d \n", enemy.name, enemy.health);
        }
    }
}
