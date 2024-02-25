package main.java.sgu.ru;

public class Knight extends Character {
    int shieldStrength;

    public Knight(String name, int health, int damage, int shieldStrength) {
        super(name, health, damage);
        this.shieldStrength = shieldStrength;
    }

    @Override
    public int hashCode() {
        return health + damage * 10 + shieldStrength * 100;
    }

    public boolean useShield() {
        return shieldStrength > 0;
    }

    @Override
    public void get_attacked(Character enemy) {
        int damage = enemy.damage;
        if (this.useShield())
        {
            damage -= this.shieldStrength;
            this.shieldStrength -= enemy.damage;
            System.out.printf("%s заблокировал удар щитом, его прочность теперь %d \n",
                    this.name, this.shieldStrength);
            if (damage < 0)
            {
                damage = 0;
            }

        }
        this.health -= damage;

        System.out.printf("%s нанёс %d урона %s \n", enemy.name, damage, this.name);
        System.out.printf("У %s осталось очков здоровья %d \n", this.name, this.health);
    }

}
