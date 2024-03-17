package main.java.sgu.ru;

public class Knight extends Character {
    int shieldStrength;

    public Knight(int id, String name, int health, int damage, int shieldStrength) {
        super(id, name, health, damage);
        this.shieldStrength = shieldStrength;
    }

    public boolean equals(Knight other)
    {
        if (this.health != other.health)
            return false;

        if (this.damage != other.damage)
            return false;

        if (this.shieldStrength != other.shieldStrength)
            return false;

        return true;
    }

    public String toString()
    {
        return this.name + " {" + Integer.toString(this.health) + ", "
                                + Integer.toString(this.damage) + ", "
                                + Integer.toString(this.shieldStrength) + "}";
    }

    public boolean useShield() {
        return shieldStrength > 0;
    }

    @Override
    public void getAttacked(Character enemy) {
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
